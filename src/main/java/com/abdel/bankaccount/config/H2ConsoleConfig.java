package com.abdel.bankaccount.config;

import jakarta.servlet.Servlet;
import org.h2.server.web.JakartaWebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2ConsoleConfig {

    @Bean
    public ServletRegistrationBean<? extends Servlet> h2ConsoleServlet() {
        JakartaWebServlet servlet = new JakartaWebServlet();
        ServletRegistrationBean<JakartaWebServlet> registration =
                new ServletRegistrationBean<>(servlet, "/h2-console/*");
        registration.addInitParameter("webAllowOthers", "false");
        registration.setLoadOnStartup(1);
        return registration;
    }
}