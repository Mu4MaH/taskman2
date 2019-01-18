package org.alex.service;

import org.alex.api.service.IAccessControlService;
import org.alex.controller.Bootstrap;
import org.alex.exception.IdAlreadyInListException;
import org.alex.exception.IdNotFoundException;
import org.alex.exception.IllegalStringException;
import org.alex.repository.AccessControlList;

import javax.crypto.*;
import java.io.ByteArrayOutputStream;
import java.security.NoSuchAlgorithmException;

public class SecurityService implements IAccessControlService {

    private final AccessControlList acl = new AccessControlList();
    private final Bootstrap bootstrap;
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final Cipher encryptCipher = Cipher.getInstance("AES");
    private final CipherOutputStream cos = new CipherOutputStream(bos, encryptCipher);

    private SecretKey secretKey;

    public SecurityService(Bootstrap bootstrap) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.bootstrap = bootstrap;
    }

    public boolean hasAccess(final String uidWhere, final String uidWho) throws IllegalStringException {
        if (uidWhere == null || uidWho == null) {
            throw new IllegalStringException();
        } else {
            final String accessList = acl.getObjectACL(uidWhere);
            return accessList.contains(uidWho);
        }

    }

    public void addToACL(final String uidWhere, final String uidWho) throws IdAlreadyInListException, IllegalStringException {
        if (uidWhere == null || uidWho == null) {
            throw new IllegalStringException();
        } else {
            final String accessList = acl.getObjectACL(uidWhere);
            if (!accessList.contains(uidWho)) {
                acl.setObjectACL(uidWhere, accessList + ";" + uidWho);
            } else throw new IdAlreadyInListException();
        }
    }

    public void removeFromACL(final String uidWhere, final String uidWho) throws IllegalStringException, IdNotFoundException {
        final StringBuffer accessList = new StringBuffer(acl.getObjectACL(uidWhere)); //SB т.к. требуется безгеморройное удаление из середины строки
        if (uidWhere.isEmpty() || uidWho.isEmpty() || uidWhere == null || uidWho == null) {
            throw new IllegalStringException();
        } else {
            final int i = accessList.indexOf(uidWho);
            if (i > -1) {
                accessList.delete(i, uidWho.length());
                acl.setObjectACL(uidWhere, accessList.toString());
                vacuumACL(uidWhere);
            } else throw new IdNotFoundException("Этого человека нет в списке доступа.");
        }
    }

    public void mergeACL(final String uidWhere, final String uidWho) throws IllegalStringException {
        if (uidWhere == null || uidWho == null) {
            final String accessList = acl.getObjectACL(uidWhere);
            acl.setObjectACL(uidWhere, accessList + ";" + uidWho);
            vacuumACL(uidWhere);
        } else throw new IllegalStringException();
    }

    private void vacuumACL(final String uidWhere) {
        //TODO: метод для удаления дублей из списка контроля доступа и неодинарных ';' остающихся после удаления учёток из списка.
    }

    public String generateToken(final String session) {

        secretKey = bootstrap.getMasterSecretKey();

        try{
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encrypted = cipher.doFinal(session.getBytes());
            System.out.println("encrypted string:" + (new String(encrypted)));
            return new String(secretKey.getEncoded());
        } catch (Exception e) {
            e.printStackTrace();
        }return bos.toString();
    }

    public void decryptToken (byte[] token) {

    }


}
