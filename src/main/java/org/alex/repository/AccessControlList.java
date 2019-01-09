package org.alex.repository;

import java.util.HashMap;
import java.util.Map;

public class AccessControlList {

    private final Map<String, String> acl = new HashMap<>();

    public String getObjectACL(String uidWhere) {
        return acl.get(uidWhere);
    }

    public void setObjectACL(String uidWhere, String uidWho) {
        acl.put(uidWhere, uidWho);
    }

}

