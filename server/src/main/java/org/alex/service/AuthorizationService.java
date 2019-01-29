package org.alex.service;

import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;
import org.alex.entity.Session;
import org.jetbrains.annotations.NotNull;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.List;

public class AuthorizationService {

    private final byte[] secret = "3,14159".getBytes();

    private final long TIMEOUT = 1800000;
    private final String CODEPAGE = "UTF-8";
    private final String ALGORITHM = "AES";

    public AuthorizationService(@NotNull final Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    Bootstrap bootstrap;

    /****************************************/
    /*                                      */
    /* Создание токена из переданной сессии */
    /*                                      */
    /****************************************/
    public String createToken(@NotNull final Session session) throws GeneralSecurityException, UnsupportedEncodingException {
        final SecretKeySpec key = new SecretKeySpec(secret, ALGORITHM);
        final Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return new String(cipher.doFinal(session.toString().getBytes(CODEPAGE)));
    }

    /*********************************************/
    /*                                           */
    /* Проверка на жизнь токена больше 30 минут  */
    /*                                           */
    /*********************************************/
    public Boolean tokenCheck(@NotNull final String token) throws GeneralSecurityException, UnsupportedEncodingException {
        final SecretKeySpec secretKey = new SecretKeySpec(secret, ALGORITHM);
        final Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        final String result = new String(cipher.doFinal(token.getBytes(CODEPAGE)));
        long tokenTime = Long.parseLong(result.substring(result.lastIndexOf(':')));
        if (tokenTime < (new Date().getTime() - 1800000)) return true;
        return false;
    }

    /**********************************************/
    /*                                            */
    /* Проверка на наличие логина в списке юзеров */
    /*                                            */
    /**********************************************/
    public Boolean loginCheck(@NotNull final String login) {
        final List<Assignee> listHelper = bootstrap.getAssigneeService().getAllAssignee();
        for (Assignee assignee : listHelper) {
            String lgn = assignee.getLogin();
            if (login.equals(assignee.getLogin())) return true;
        }
        return false;
    }

    /**********************************************/
    /*                                            */
    /* Проверка на совпадение пароля пользователя */
    /*                                            */
    /**********************************************/
    public Boolean passwordCheck(@NotNull final String login, int passHash) {
        Assignee user = bootstrap.getAssigneeService().getAssigneeByLogin(login);
        if (user.getPassword() == passHash) return true;
        return false;
    }


}
