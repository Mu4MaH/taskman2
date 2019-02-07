package org.alex.endpoint;

import org.alex.controller.Bootstrap;
import org.alex.entity.Session;
import org.jetbrains.annotations.NotNull;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class EndpointAuthorization {

    public EndpointAuthorization() {
        Endpoint.publish("http://localhost:888/auth", this);
    }

    public EndpointAuthorization(Bootstrap bootstrap) {
        Endpoint.publish("http://localhost:888/auth?wsdl", this);
        this.bootstrap = bootstrap;
    }

    private Bootstrap bootstrap;

    /****************************************/
    /*                                      */
    /* Создание токена из переданной сессии */
    /*                                      */

    /****************************************/
    @WebMethod
    public String createToken(@NotNull String login) {
        return bootstrap.getAuthorizationService().createToken(login);
    }

    /*********************************************/
    /*                                           */
    /* Проверка на жизнь токена больше 30 минут  */
    /*      И распаковка сессии из токена        */

    /*********************************************/
    @WebMethod
    public Session tokenCheck(@NotNull final String token) {
        return bootstrap.getAuthorizationService().tokenCheck(token);
    }

    /**********************************************/
    /*                                            */
    /* Проверка на наличие логина в списке юзеров */
    /*                                            */

    /**********************************************/
    @WebMethod
    @NotNull
    public Boolean loginCheck(@NotNull final String login) {
        return bootstrap.getAuthorizationService().loginCheck(login);
    }

    /**********************************************/
    /*                                            */
    /* Проверка на совпадение пароля пользователя */
    /*                                            */

    /**********************************************/
    @WebMethod
    @NotNull
    public Boolean passwordCheck(@NotNull String login, int passHash) {
        return bootstrap.getAuthorizationService().passwordCheck(login, passHash);
    }


}
