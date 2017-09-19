package com.cnpc.iam.java.web.auth.oauth.jersey.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class TestIConfigureServiceTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"GetPropertiesFile.xml"});

        context.start();
        System.out.println("提供者服务已经注册成功");

        try {
            System.in.read();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
