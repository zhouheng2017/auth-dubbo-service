package com.cnpc.iam.java.web.auth.oauth.jersey.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerServiceTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        context.start();

        TestService testService = (TestService) context.getBean("testService");
        System.out.println(testService.getName());
        try {
            System.in.read();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
