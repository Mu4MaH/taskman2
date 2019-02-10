package org.alex;

import org.alex.controller.Bootstrap;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class App {

    public static void main(String[] args) throws Exception {
//        @NotNull final SeContainerInitializer initializer = SeContainerInitializer.newInstance();
//        @NotNull final SeContainer seContainer = initializer.initialize();
//        @NotNull final Bootstrap bootstrap = seContainer.select(Bootstrap.class).get();
        Weld weld = new Weld();

        WeldContainer container = weld.addPackages(App.class).initialize();

        Bootstrap bootstrap = container.select(Bootstrap.class).get();
        bootstrap.init();

    }
}
