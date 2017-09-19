package com.cnpc.iam.java.web.auth.oauth.jersey.util;

import com.cnpc.iam.java.web.auth.oauth.jersey.util.impl.ConfigureException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;

public class IConfigureServiceConsumer {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"IConsumerService.xml"});
        context.start();


        IConfigureService Configure = (IConfigureService) context.getBean("getPropertiesFile");

        Configure.IConfigureServiceImpl("oauth_loginUrl0.properties");



        String tokenKeyAppNum = "appNum";
        String tokenKeyRedirecturl = "redirecturl";
        String appNum = "123456";
        String redirectUrlPar = "http://www.baidu.com";
        String exLoginUrl = "https://trainws.iam.cnpc/iamOAuth/authCode?appNum=123456&redirecturl"
                + "=http%3A%2F%2Fwww.baidu.com";
        try {
            String avLoginUrl = Configure.getLoginUrl(tokenKeyAppNum, tokenKeyRedirecturl, appNum, redirectUrlPar);
            // 判断获取的loginUrl
            Assert.assertEquals(avLoginUrl, exLoginUrl, "ConfigureTest.getLoginUrl0 loginUrl与期望值不符");
        } catch (ConfigureException e) {
            e.printStackTrace();
            Assert.assertEquals(true, false, "ConfigureTest.getLoginUrl0 出现了未知错误");
        }

        System.out.println("Configure消费者");


    }

}
