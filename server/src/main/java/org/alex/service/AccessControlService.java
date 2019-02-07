package org.alex.service;

import org.alex.api.service.IAccessControlService;
import org.alex.controller.Bootstrap;
import org.alex.exception.IdAlreadyInListException;
import org.alex.exception.IdNotFoundException;
import org.alex.exception.IllegalStringException;
import org.alex.repository.AccessControlList;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.security.NoSuchAlgorithmException;

@ApplicationScoped
@Transactional
public class AccessControlService implements IAccessControlService {

    @Inject
    private AccessControlList acl;

    @Inject
    Bootstrap bootstrap;

    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final Cipher encryptCipher = Cipher.getInstance("AES");
    private final CipherOutputStream cos = new CipherOutputStream(bos, encryptCipher);

    private SecretKey secretKey;

    public AccessControlService() throws NoSuchPaddingException, NoSuchAlgorithmException {}

    public boolean hasAccess(@NotNull final String uidWhere, @NotNull final String uidWho) {
            final String accessList = acl.getObjectACL(uidWhere);
            return accessList.contains(uidWho);


    }

    public void addToACL(@NotNull final String uidWhere, @NotNull final String uidWho) throws IdAlreadyInListException, IllegalStringException {
            final String accessList = acl.getObjectACL(uidWhere);
            if (!accessList.contains(uidWho)) {
                acl.setObjectACL(uidWhere, accessList + ";" + uidWho);
            } else throw new IdAlreadyInListException();

    }

    public void removeFromACL(@NotNull final String uidWhere, @NotNull final String uidWho) throws IllegalStringException, IdNotFoundException {
        final StringBuffer accessList = new StringBuffer(acl.getObjectACL(uidWhere)); //SB т.к. требуется безгеморройное удаление из середины строки
        if (uidWhere.isEmpty() || uidWho.isEmpty()) {
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

    public void mergeACL(@NotNull final String uidWhere, @NotNull final String uidWho) throws IllegalStringException {
            final String accessList = acl.getObjectACL(uidWhere);
            acl.setObjectACL(uidWhere, accessList + ";" + uidWho);
            vacuumACL(uidWhere);
    }

    private void vacuumACL(@NotNull final String uidWhere) {
        //TODO: метод для удаления дублей из списка контроля доступа и неодинарных ';' остающихся после удаления учёток из списка.
    }

}
