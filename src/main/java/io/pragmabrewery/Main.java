package io.pragmabrewery;

import io.pragmabrewery.controller.BeerContainerController;
import io.pragmabrewery.service.BeerContainerMonitor;
import io.pragmabrewery.service.TemperatureSensor;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.Timer;

public class Main {
    public static void main(String[] args) throws Exception {
        new Timer().schedule(new BeerContainerMonitor(new TemperatureSensor()), 0, 10000);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8080);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", BeerContainerController.class.getCanonicalName());

        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }
}
