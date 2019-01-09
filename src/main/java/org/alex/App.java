package org.alex;

import org.alex.controller.AuthorizationController;
import org.alex.controller.Bootstrap;

public class App {

    public static void main(String[] args) throws Exception {
        final Bootstrap bootstrap = new Bootstrap();
        final AuthorizationController authorizationController = new AuthorizationController();
        authorizationController.login(bootstrap);
    }

}
