package org.alex;

import org.alex.controller.Bootstrap;

public class App {


    private String token = null;

    public static void main(String[] args) throws Exception {
        final Bootstrap bootstrap = new Bootstrap();
            bootstrap.authorize();
    }
}
