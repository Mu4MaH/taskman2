package org.alex.api.service;

import org.alex.exception.IdAlreadyInListException;
import org.alex.exception.IdNotFoundException;
import org.alex.exception.IllegalStringException;

public interface IAccessControlService {

    boolean hasAccess(String uidEntity, String uidUser) throws IllegalStringException;

    void addToACL(String uidEntity, String uidUser) throws IdAlreadyInListException, IllegalStringException;

    void removeFromACL(String uidEntity, String uidUser) throws IllegalStringException, IdNotFoundException;

    void mergeACL(String uidEntity, String uidAccessList) throws IllegalStringException;

}
