package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.example.config.WebConfig;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

public class Main {
    public static void main(String[] args) throws LifecycleException {

        // boiler plate
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);

        tomcat.getConnector();

        String contetPath = "";
        String baseDoc = new File("src/main/webapp").getAbsolutePath();

        Context context = tomcat.addContext(contetPath, baseDoc);

        // IOC Container up
        AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
        springContext.register(WebConfig.class);

        // Dispatch servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(springContext);

        Tomcat.addServlet(context, "dispatcherServlet", dispatcherServlet);

        context.addServletMappingDecoded("/", "dispatcherServlet");

        tomcat.start();

        System.out.println("Tomcat started on port 8080");

        // to keep tomcat running
        tomcat.getServer().await();

    }
}
