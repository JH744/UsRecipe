package com.example.FP.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Properties;

@Configuration
public class SpringConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        System.out.println("passwordEncoder 동작함.");
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public JavaMailSenderImpl javaMailSender(){
        JavaMailSenderImpl jms = new JavaMailSenderImpl();
        jms.setHost("smtp.gmail.com");
        jms.setPort(587);
        jms.setUsername("tjfkqm1@gmail.com");
        jms.setPassword("rfhq dgdy atic kqmz");
        jms.setDefaultEncoding("UTF-8");

        Properties prop = new Properties();
        prop.put("mail.smtp.starttls.enable", true);
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.ssl.checkserveridentity", true);
        prop.put("mail.smtp.ssl.trust", "*");
        prop.put("mail.smtp.ssl.protocols","TLSv1.2");
        jms.setJavaMailProperties(prop);

        return jms;
    }
}