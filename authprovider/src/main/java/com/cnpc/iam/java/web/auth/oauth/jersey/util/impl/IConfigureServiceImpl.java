package com.cnpc.iam.java.web.auth.oauth.jersey.util.impl;


import com.cnpc.iam.java.web.auth.oauth.jersey.util.IConfigureService;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;


public class IConfigureServiceImpl implements IConfigureService{



    private Properties props = new Properties();
    private static String propertieName = "oauth.properties";



    public void IConfigureServiceImpl(String propName) {
        InputStream inStream = Configure.class.getClassLoader().getResourceAsStream(propName);
        if (inStream == null) {
            throw new ConfigureRuntimeException("系统没有加载到名为" + propName + "的配置文件！");
        }
        propertieName = propName;
        getPropertiesFile(inStream);
    }

    public void getPropertiesFile(InputStream inStream) {

        try {
            props.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ConfigureRuntimeException("解析propertie配置文件出错！");
        }


    }

    public Properties getProp() {
        return props;
    }

    public String getPropertyVal(String propertyKey) throws ConfigureException {
        String propertyVal = this.props.getProperty(propertyKey);
        if (propertyVal == null || "".equals(propertyVal)) {
            throw new ConfigureException(this.msg("缺少名称为" + propertyKey + "的配置项！"));
        }
        return propertyVal;
    }

    public String getLoginUrl(String tokenKeyAppNum, String tokenKeyRedirecturl, String appNum, String redirectUrlPar)
            throws ConfigureException {
        String encodeUrl = null;
        try {
            encodeUrl = URLEncoder.encode(redirectUrlPar, getUrlEncoderEncoding(appNum));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new ConfigureException("编码redirectUrl时出错！");
        }
        String loginUrl = this.getPropertyVal(ConfigureKeys.LOGINURL);

        String returnStr = loginUrl + "?" + tokenKeyAppNum + "=" + appNum + "&" + tokenKeyRedirecturl + "=" + encodeUrl;
        return returnStr;
    }

    /**
     * 拼凑msg
     *
     * @param msg
     * @return
     */
    private String msg(String msg) {
        return "在配置文件" + propertieName + "中，" + msg;
    }

    /**
     * 获取编码URL使用的Encoder值
     *
     * @param appNum
     * @return
     * @throws ConfigureException
     */
    public String getUrlEncoderEncoding(String appNum) throws ConfigureException {
        String proKey = this.getPropertyVal(appNum + "_" + ConfigureKeys.URLENCODING);
        return proKey;
    }

    /**
     * AuthCode有效的时间
     *
     * @return
     * @throws ConfigureException
     */
    public int getAuthCodeExpMinute() throws ConfigureException {
        String authCodeExpMinute = this.getPropertyVal(ConfigureKeys.AUTHCODEEXPMINUTE);
        int authCodeExp = Integer.parseInt(authCodeExpMinute);
        return authCodeExp;
    }

    /**
     * 获取应用的RediectUri信息
     *
     * @param appNum
     * @return
     * @throws ConfigureException
     */
    public String getRediectUri(String appNum) throws ConfigureException {
        String rediectUri = this.getPropertyVal(appNum + "_" + ConfigureKeys.REDIECTURI);
        return rediectUri;
    }

    /**
     * 获取accessToken过期的分钟数
     *
     * @return
     * @throws ConfigureException
     */
    public int getAccessTokenExp() throws ConfigureException {
        String accessTokenExpMinute = this.getPropertyVal(ConfigureKeys.ACCESSTOKENEXP);
        int accessTokenExp = Integer.parseInt(accessTokenExpMinute);
        return accessTokenExp;
    }

    /**
     * 检查appNum和appPwd是否正确
     *
     * @param appNum
     * @param appPwd
     * @return
     * @throws ConfigureException
     */
    public boolean checkAppPwd(String appNum, String appPwd) {
        if (appPwd == null || "".equals(appPwd)) {
            return false;
        }
        String configureAppPwd = "none";
        try {
            configureAppPwd = this.getPropertyVal(appNum + "_" + ConfigureKeys.APPPWD);
        } catch (ConfigureException e) {
            e.printStackTrace();
            // System.out.println("no configureAppPwd");
            return false;
        }
        // System.out.println("*********pwd start**********");
        // System.out.println("appPwd:" + appPwd);
        // System.out.println("configureAppPwd:" + configureAppPwd);
        // System.out.println("*********pwd end**********");
        return configureAppPwd.equals(appPwd);
    }

    /**
     * 获取应用系统名称
     *
     * @param appNum
     * @return
     * @throws ConfigureException
     */
    public String getAppName(String appNum) throws ConfigureException {
        String appName = this.getPropertyVal(appNum + "_" + ConfigureKeys.APPNAME);
        return appName;
    }

    /**
     * 获取帐号提示信息
     *
     * @param appNum
     * @return
     * @throws ConfigureException
     */
    public String getMsgNoAppAccount(String appNum) throws ConfigureException {
        String appName = this.getAppName(appNum);
        return "该用户没有[" + appName + "]的帐号！";
    }

    /**
     * 获取能够从webSeal中帐号信息
     *
     * @return
     * @throws ConfigureException
     */
    public String getWebSealAccounts() throws ConfigureException {
        String webSealAccounts = this.getPropertyVal(ConfigureKeys.WEBSEALACCOUNTS);
        return webSealAccounts;
    }

    /**
     * 得到这个应用需要的属性
     *
     * @param appNum
     * @return
     * @throws ConfigureException
     */
    public String getAppAccountKey(String appNum) throws ConfigureException {
        String appAccountKey = this.getPropertyVal(appNum + "_" + ConfigureKeys.APPACCOUNTKEY);
        return appAccountKey;
    }
}
