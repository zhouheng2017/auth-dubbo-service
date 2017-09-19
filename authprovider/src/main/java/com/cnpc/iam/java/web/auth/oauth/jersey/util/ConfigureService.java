package com.cnpc.iam.java.web.auth.oauth.jersey.util;


import com.cnpc.iam.java.web.auth.oauth.jersey.util.impl.ConfigureException;

import java.util.Properties;

public interface ConfigureService {

//
//
//
//    public Properties getProp();
//
//
//
    public String getLoginUrl(String tokenKeyAppNum, String tokenKeyRedirecturl, String appNum, String redirectUrlPar)
            throws ConfigureException;
//
//    String getPropertyVal(String propertyKey) throws ConfigureException ;
//
//    String msg(String msg) ;
//
//    String getUrlEncoderEncoding(String appNum) throws ConfigureException;
//
//    public int getAuthCodeExpMinute() throws ConfigureException;
//
//    public String getRediectUri(String appNum) throws ConfigureException ;
//
//
//    public int getAccessTokenExp() throws ConfigureException ;
//
//    public boolean checkAppPwd(String appNum, String appPwd) ;
//
//    public String getAppName(String appNum) throws ConfigureException;
//    public String getMsgNoAppAccount(String appNum) throws ConfigureException;
//    public String getWebSealAccounts() throws ConfigureException;
//    public String getAppAccountKey(String appNum) throws ConfigureException;
}
