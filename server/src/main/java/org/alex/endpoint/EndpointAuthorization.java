package org.alex.endpoint;

import org.alex.controller.Bootstrap;
import org.alex.entity.Assignee;
import org.alex.entity.Session;
import org.jetbrains.annotations.NotNull;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.List;

@WebService
public class EndpointAuthorization {

    private final byte[] secret = "3,14159".getBytes();
    private final long TIMEOUT = 1800000;
    private final String CODEPAGE = "UTF-8";
    private final String ALGORITHM = "AES";

    public EndpointAuthorization() {}

    public EndpointAuthorization(Bootstrap bootstrap) {
        Endpoint.publish("http://localhost:888/auth?wsdl", this);
        this.bootstrap = bootstrap;

    }

    Bootstrap bootstrap;

    /****************************************/
    /*                                      */
    /* Создание токена из переданной сессии */
    /*                                      */
    /****************************************/
    @WebMethod
    public String createToken(@NotNull Session session) throws GeneralSecurityException, UnsupportedEncodingException {
        if (session == null) return null;
        final SecretKeySpec key = new SecretKeySpec(secret, ALGORITHM);
        final Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return new String(cipher.doFinal(session.toString().getBytes(CODEPAGE)));
    }

    /*********************************************/
    /*                                           */
    /* Проверка на жизнь токена больше 30 минут  */
    /*      И распаковка сессии из токена        */
    /*********************************************/
    @WebMethod
    public Session tokenCheck(@NotNull final String token) throws GeneralSecurityException, UnsupportedEncodingException {
        if (token.isEmpty() || token == null) return null;
        Session session = new Session();
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
    }

    /**********************************************/
    /*                                            */
    /* Проверка на наличие логина в списке юзеров */
    /*                                            */
    /**********************************************/
    @WebMethod
    public Boolean loginCheck(@NotNull final String login) {
        if (login.isEmpty() || login == null) return false;
        final List<Assignee> listHelper = bootstrap.getAssigneeService().getAllAssignee();
        for (Assignee assignee : listHelper) {
            if (login.equals(assignee.getLogin())) return true;
        }
        return false;
    }

    /**********************************************/
    /*                                            */
    /* Проверка на совпадение пароля пользователя */
    /*                                            */
    /**********************************************/
    @WebMethod
    public Boolean passwordCheck(@NotNull String login, int passHash) {
        Assignee user = bootstrap.getAssigneeService().getAssigneeByLogin(login);
        if (user.getPassword() == passHash) return true;
        return false;
    }


}
