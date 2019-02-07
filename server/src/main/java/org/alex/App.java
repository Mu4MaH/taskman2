package org.alex;

import org.alex.controller.Bootstrap;
import org.jetbrains.annotations.NotNull;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class App {

    public static void main(String[] args) throws Exception {
        @NotNull final SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        @NotNull final SeContainer seContainer = initializer.initialize();
        @NotNull final Bootstrap bootstrap = seContainer.select(Bootstrap.class).get();
        bootstrap.init();

    }
}
