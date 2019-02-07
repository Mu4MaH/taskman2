package org.alex.repository;

import org.jetbrains.annotations.NotNull;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

/*************************************/
/* Контроль доступа строится на карте, в которой ключ = юник айди объекта,
/* а список пользователей с доступом - значение, представляюще собой
/* csv строку юник айдишников.
/* Работа с правами доступа ведётся через метожды работы со строками
/*************************************/

@ApplicationScoped
public class AccessControlList {

    public  AccessControlList() {}

    private final Map<String, String> acl = new HashMap<>();

    public String getObjectACL(@NotNull String uidWhere) {
        return acl.get(uidWhere);
    }

    public void setObjectACL(@NotNull String uidWhere, @NotNull String uidWho) {
        acl.put(uidWhere, uidWho);
    }

}

