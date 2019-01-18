package org.alex;

import org.alex.controller.Bootstrap;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Arrays;



public class App {

    public static void main(String[] args) throws Exception {
        final Bootstrap bootstrap = new Bootstrap();
        bootstrap.authorize();
    }
}
