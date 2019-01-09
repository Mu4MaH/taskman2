package org.alex.service;

import org.alex.api.service.IAccessControlService;
import org.alex.exception.IdAlreadyInListException;
import org.alex.exception.IdNotFoundException;
import org.alex.exception.IllegalStringException;
import org.alex.repository.AccessControlList;

public class AccessControlService implements IAccessControlService {

    AccessControlList acl = new AccessControlList();

    public boolean hasAccess(final String uidWhere, final String uidWho) throws IllegalStringException {
        if (uidWhere != null && uidWho != null) {
            final String accessList = acl.getObjectACL(uidWhere);
            return accessList.contains(uidWho);
        } else throw new IllegalStringException();
    }

    public void addToACL(final String uidWhere, final String uidWho) throws IdAlreadyInListException, IllegalStringException {
        if (uidWhere != null && uidWho != null) {
            final String accessList = acl.getObjectACL(uidWhere);
            if (!accessList.contains(uidWho)) {
                acl.setObjectACL(uidWhere, accessList + ";" + uidWho);
            } else throw new IdAlreadyInListException();
        } else throw new IllegalStringException();
    }

    public void removeFromACL(final String uidWhere, final String uidWho) throws IllegalStringException, IdNotFoundException {
        final StringBuffer accessList = new StringBuffer(acl.getObjectACL(uidWhere));
        if (uidWhere != null && uidWho != null) {
            final int i = accessList.indexOf(uidWho);
            if (i > -1) {
                accessList.delete(i, uidWho.length());
                acl.setObjectACL(uidWhere, accessList.toString());
                vacuumACL(uidWhere);
            } else throw new IdNotFoundException("Этого человека нет в списке доступа.");
        } else throw new IllegalStringException();
    }

    public void mergeACL(final String uidWhere, final String uidWho) throws IllegalStringException {
        if (uidWhere != null && uidWho != null) {
            final String accessList = acl.getObjectACL(uidWhere);
            acl.setObjectACL(uidWhere, accessList + ";" + uidWho);
            vacuumACL(uidWhere);
        } else throw new IllegalStringException();
    }

    private boolean vacuumACL(final String uidWhere) {
        //TODO: метод для удаления дублей из списка контроля доступа и неодинарных ; остающихся после удаления учёток из списка.
        return true;
    }

}
