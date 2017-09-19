package com.cnpc.iam.java.web.auth.oauth.jersey.util;

import com.cnpc.iam.java.web.auth.oauth.jersey.util.impl.ConfigureException;

import java.io.InputStream;
import java.util.Properties;

public interface IConfigureService {
    void getPropertiesFile(InputStream inStream);

    Properties getProp();

    String getPropertyVal(String propertyKey) throws ConfigureException;
    public String getLoginUrl(String tokenKeyAppNum, String tokenKeyRedirecturl, String appNum, String redirectUrlPar)
            throws ConfigureException;

    public void IConfigureServiceImpl(String propName);

//    String msg(String msg) ;

    String getUrlEncoderEncoding(String appNum) throws ConfigureException;

    int getAuthCodeExpMinute() throws ConfigureException;

    String getRediectUri(String appNum) throws ConfigureException ;


    int getAccessTokenExp() throws ConfigureException ;

    boolean checkAppPwd(String appNum, String appPwd) ;

    String getAppName(String appNum) throws ConfigureException;
    String getMsgNoAppAccount(String appNum) throws ConfigureException;
    String getWebSealAccounts() throws ConfigureException;
    String getAppAccountKey(String appNum) throws ConfigureException;
}
