package org.alex.service;

import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;
import org.alex.entity.Session;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@ApplicationScoped
@Transactional
public class AuthorizationService {

    public AuthorizationService() throws UnsupportedEncodingException {
    }

    @Inject
    private PropertyLoader propertyLoader;

    @Inject
    private Bootstrap bootstrap;

    private Properties properties;
    private String key;
    private Long TIMEOUT;
    private String CODEPAGE;
    private String ALGORITHM;
    private byte[] secret;

    {
        try {
            this.properties = propertyLoader.getProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.key = properties.getProperty("token.key");
        this.TIMEOUT = Long.parseLong(properties.getProperty("token.timeout"));
        this.CODEPAGE = properties.getProperty("token.codepage");
        this.ALGORITHM = properties.getProperty("token.algorithm");
        this.secret = Arrays.copyOf(key.getBytes(CODEPAGE), 16);

    }
    /****************************************/
    /*                                      */
    /* Создание токена из переданной сессии */
    /*                                      */

    /****************************************/
    @Nullable public String createToken(@NotNull final String login) {
        @NotNull final SecretKeySpec key = new SecretKeySpec(secret, ALGORITHM);
        @NotNull final Cipher cipher;
        Session session = new Session();
        session.setUserId(login);
        try {
            cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return new String(cipher.doFinal(session.toString().getBytes(CODEPAGE)));
        } catch (GeneralSecurityException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*********************************************/
    /*                                           */
    /* Проверка на жизнь токена больше 30 минут  */
    /*                                           */

    /*********************************************/
    @Nullable
    public Session tokenCheck(@NotNull final String token) {
        try {
            if (token.isEmpty()) return null;
            final Session session = new Session();
            final SecretKeySpec secretKey = new SecretKeySpec(secret, ALGORITHM);
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            final String result = new String(cipher.doFinal(token.getBytes(CODEPAGE)));
            session.setTimestamp(Long.parseLong(result.substring(result.lastIndexOf(':'))));
            if (session.getTimestamp() < (new Date().getTime() - 1800000)) {
                session.setTimestamp(new Date().getTime());
                session.setUserId(result.substring(result.indexOf(':'), result.lastIndexOf(':')));
                System.out.println("DEBUG: " + session.toString());
                return session;
            }
            return null;
        } catch (GeneralSecurityException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

        /**********************************************/
        /*                                            */
        /* Проверка на наличие логина в списке юзеров */
        /*                                            */
        /**********************************************/
        @NotNull public Boolean loginCheck ( @NotNull final String login){
            @NotNull final List<Assignee> listHelper = bootstrap.getAssigneeService().getAllAssignee();
            for (Assignee assignee : listHelper) {
                String lgn = assignee.getLogin();
                if (login.equals(lgn)) return true;
            }
            return false;
        }

        /**********************************************/
        /*                                            */
        /* Проверка на совпадение пароля пользователя */
        /*                                            */
        /**********************************************/
        @NotNull public Boolean passwordCheck ( @NotNull final String login, int passHash){
            @NotNull Assignee user = bootstrap.getAssigneeService().getAssigneeByLogin(login);
            if (user.getPassword() == passHash) return true;
            return false;
        }


    }
