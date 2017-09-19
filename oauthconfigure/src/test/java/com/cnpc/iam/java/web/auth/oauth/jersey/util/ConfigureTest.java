package com.cnpc.iam.java.web.auth.oauth.jersey.util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigureTest {

	@Test
	public void Configure() {
		Configure conf = new Configure();
	}

	@Test
	public void ConfigureString() {
		String exMsg = "系统没有加载到名为oauth1.properties的配置文件！";
		String avMsg = null;
		try {
			Configure conf = new Configure("oauth1.properties");
		} catch (ConfigureRuntimeException e) {
			avMsg = e.getMessage();
		}
		Assert.assertEquals(avMsg, exMsg, "ConfigureTest.ConfigureString 没有抛出预期的异常");
	}

	//
	@Test
	public void getLoginUrl0() {
		Configure conf = new Configure("oauth_loginUrl0.properties");
		String tokenKeyAppNum = "appNum";
		String tokenKeyRedirecturl = "redirecturl";
		String appNum = "123456";
		String redirectUrlPar = "http://www.baidu.com";
		String exLoginUrl = "https://trainws.iam.cnpc/iamOAuth/authCode?appNum=123456&redirecturl"
				+ "=http%3A%2F%2Fwww.baidu.com";
		try {
			String avLoginUrl = conf.getLoginUrl(tokenKeyAppNum, tokenKeyRedirecturl, appNum, redirectUrlPar);
			// 判断获取的loginUrl
			Assert.assertEquals(avLoginUrl, exLoginUrl, "ConfigureTest.getLoginUrl0 loginUrl与期望值不符");
		} catch (ConfigureException e) {
			e.printStackTrace();
			Assert.assertEquals(true, false, "ConfigureTest.getLoginUrl0 出现了未知错误");
		}
	}

	@Test
	public void getLoginUrl1() {
		Configure conf = new Configure("oauth_loginUrl1.properties");
		String tokenKeyAppNum = "appNum";
		String tokenKeyRedirecturl = "redirecturl";
		String appNum = "123456";
		String redirectUrlPar = "http://www.baidu.com";
		boolean avBoolean = false;
		try {
			String avLoginUrl = conf.getLoginUrl(tokenKeyAppNum, tokenKeyRedirecturl, appNum, redirectUrlPar);
		} catch (ConfigureException e) {
			e.printStackTrace();
			avBoolean = true;
		}
		// 没有获取loginUrl
		Assert.assertEquals(avBoolean, true, "ConfigureTest.getLoginUrl1 没有出现预期的异常");
	}

	@Test
	public void getUrlEncoderEncoding0() {
		Configure conf = new Configure("oauth_urlEncoding0.properties");
		String appNum = "123456";
		boolean avBoolean = false;
		try {
			conf.getUrlEncoderEncoding(appNum);
		} catch (ConfigureException e) {
			e.printStackTrace();
			avBoolean = true;
		}
		Assert.assertEquals(avBoolean, true, "ConfigureTest.getUrlEncoderEncoding0 没有出现预期的异常");
	}

	@Test
	public void getUrlEncoderEncoding1() {
		Configure conf = new Configure("oauth_urlEncoding1.properties");
		String appNum = "123456";
		String exUrlEncoding = "UTF-8";
		try {
			String avUrlEncoding = conf.getUrlEncoderEncoding(appNum);
			Assert.assertEquals(avUrlEncoding, exUrlEncoding, "ConfigureTest.getUrlEncoderEncoding 没有获取到预期的值");
		} catch (ConfigureException e) {
			e.printStackTrace();
			Assert.assertEquals(true, false, "ConfigureTest.getUrlEncoderEncoding1 出现了未知错误");
		}
	}

	@Test
	public void getAuthCodeExpMinute0() {
		Configure conf = new Configure("oauth_authCodeExpMinute0.properties");
		int exAuthCodeExp = 100;
		try {
			int avAuthCodeExp = conf.getAuthCodeExpMinute();
			Assert.assertEquals(avAuthCodeExp, exAuthCodeExp, "ConfigureTest.getAuthCodeExpMinute 没有获取到预期的值");
		} catch (ConfigureException e) {
			e.printStackTrace();
			Assert.assertEquals(true, false, "ConfigureTest.getAuthCodeExpMinute 出现了未知错误");
		}
	}

	@Test
	public void getAuthCodeExpMinute1() {
		Configure conf = new Configure("oauth_authCodeExpMinute1.properties");
		boolean avBoolean = false;
		try {
			int avAuthCodeExp = conf.getAuthCodeExpMinute();
		} catch (ConfigureException e) {
			e.printStackTrace();
			avBoolean = true;
		}
		Assert.assertEquals(avBoolean, true, "ConfigureTest.getAuthCodeExpMinute1 没有出现预期的异常");
	}

	@Test
	public void getAccessTokenExp0() {
		Configure conf = new Configure("oauth_accessTokenExp0.properties");
		int exAuthCodeExp = 10;
		try {
			int avAuthCodeExp = conf.getAccessTokenExp();
			Assert.assertEquals(avAuthCodeExp, exAuthCodeExp, "ConfigureTest.getAccessTokenExp0 没有获取到预期的值");
		} catch (ConfigureException e) {
			e.printStackTrace();
			Assert.assertEquals(true, false, "ConfigureTest.getAccessTokenExp0 出现了未知错误");
		}
	}

	@Test
	public void getAccessTokenExp1() {
		Configure conf = new Configure("oauth_accessTokenExp1.properties");
		boolean avBoolean = false;
		try {
			int avAccessTokenExp = conf.getAccessTokenExp();
		} catch (ConfigureException e) {
			e.printStackTrace();
			avBoolean = true;
		}
		Assert.assertEquals(avBoolean, true, "ConfigureTest.getAccessTokenExp1 没有出现预期的异常");
	}

	@Test
	public void getRediectUri0() {
		Configure conf = new Configure("oauth_rediectUri0.properties");
		String appNum = "123456";
		String exRediectUri = "none";
		try {
			String avRediectUri = conf.getRediectUri(appNum);
			Assert.assertEquals(avRediectUri, exRediectUri, "ConfigureTest.getRediectUri0 没有获取到预期的值");
		} catch (ConfigureException e) {
			e.printStackTrace();
			Assert.assertEquals(true, false, "ConfigureTest.getRediectUri0 出现了未知错误");
		}
	}

	@Test
	public void getRediectUri1() {
		Configure conf = new Configure("oauth_rediectUri1.properties");
		String appNum = "123456";
		boolean avBoolean = false;
		try {
			conf.getRediectUri(appNum);
		} catch (ConfigureException e) {
			e.printStackTrace();
			avBoolean = true;
		}
		Assert.assertEquals(avBoolean, true, "ConfigureTest.getRediectUri1 没有出现预期的异常");
	}

	@Test
	public void checkAppPwd() {
		Configure conf = new Configure("oauth_appPwd0.properties");
		String appNum = "123456";
		String appPwd = "12345678";
		boolean exAppPwd = true;
		boolean avAppPwd = conf.checkAppPwd(appNum, appPwd);
		Assert.assertEquals(avAppPwd, exAppPwd, "ConfigureTest.checkAppPwd0 没有获取到预期的值");
	}

	@Test
	public void checkAppPwd1() {
		Configure conf = new Configure("oauth_appPwd1.properties");
		String appNum = "123456";
		String appPwd = "12345678";
		boolean exAppPwd = false;
		boolean avAppPwd = conf.checkAppPwd(appNum, appPwd);
		Assert.assertEquals(avAppPwd, exAppPwd, "ConfigureTest.checkAppPwd0 没有获取到预期的值");
	}

	@Test
	public void checkAppPwd2() {
		Configure conf = new Configure("oauth_appPwd0.properties");
		String appNum = "123456";
		String appPwd = "1234567";
		boolean exAppPwd = false;
		boolean avAppPwd = conf.checkAppPwd(appNum, appPwd);
		Assert.assertEquals(avAppPwd, exAppPwd, "ConfigureTest.checkAppPwd0 没有获取到预期的值");
	}

	@Test
	public void getAppName0() {
		Configure conf = new Configure("oauth_appName0.properties");
		String appNum = "123456";
		String exAppName = "云管平台";
		try {
			String avAppName = conf.getAppName(appNum);
			Assert.assertEquals(avAppName, exAppName, "ConfigureTest.getAppName0 没有获取到预期的值");
		} catch (ConfigureException e) {
			e.printStackTrace();
			Assert.assertEquals(true, false, "ConfigureTest.getAppName0 出现了未知错误");
		}
	}

	@Test
	public void getAppName1() {
		Configure conf = new Configure("oauth_appName1.properties");
		String appNum = "123456";
		boolean avBoolean = false;
		try {
			conf.getAppName(appNum);
		} catch (ConfigureException e) {
			e.printStackTrace();
			avBoolean = true;
		}
		Assert.assertEquals(avBoolean, true, "ConfigureTest.getAppName1 没有出现预期的异常");
	}

	@Test
	public void getWebSealAccounts0() {
		Configure conf = new Configure("oauth_webSealAccounts0.properties");
		String exWebSealAccounts = "account";
		try {
			String avWebSealAccounts = conf.getWebSealAccounts();
			Assert.assertEquals(avWebSealAccounts, exWebSealAccounts, "ConfigureTest.getWebSealAccounts0 没有获取到预期的值");
		} catch (ConfigureException e) {
			e.printStackTrace();
			Assert.assertEquals(true, false, "ConfigureTest.getWebSealAccounts0 出现了未知错误");
		}
	}

	@Test
	public void getWebSealAccounts1() {
		Configure conf = new Configure("oauth_webSealAccounts1.properties");
		boolean avBoolean = false;
		try {
			conf.getWebSealAccounts();
		} catch (ConfigureException e) {
			e.printStackTrace();
			avBoolean = true;
		}
		Assert.assertEquals(avBoolean, true, "ConfigureTest.getWebSealAccounts1 没有出现预期的异常");
	}

	@Test
	public void getAppAccountKey0() {
		Configure conf = new Configure("oauth_appAccountKey0.properties");
		String appNum = "123456";
		String exAppAccountKey = "account";
		try {
			String avAppAccountKey = conf.getAppAccountKey(appNum);
			Assert.assertEquals(avAppAccountKey, exAppAccountKey, "ConfigureTest.getAppAccountKey0 没有获取到预期的值");
		} catch (ConfigureException e) {
			e.printStackTrace();
			Assert.assertEquals(true, false, "ConfigureTest.getAppAccountKey0 出现了未知错误");
		}
	}

	@Test
	public void getAppAccountKey1() {
		Configure conf = new Configure("oauth_appAccountKey1.properties");
		boolean avBoolean = false;
		try {
			conf.getWebSealAccounts();
		} catch (ConfigureException e) {
			e.printStackTrace();
			avBoolean = true;
		}
		Assert.assertEquals(avBoolean, true, "ConfigureTest.getAppAccountKey1 没有出现预期的异常");
	}
}
