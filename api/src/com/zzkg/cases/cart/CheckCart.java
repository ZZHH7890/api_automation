package com.zzkg.cases.cart;

import org.testng.annotations.Test;

import common.GetMethod;
import common.Log;
import common.Login;
import datapro.CartPro;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@Guice
public class CheckCart {
	@Test(enabled = true, dataProvider = "cart", dataProviderClass = CartPro.class, priority = 2)
	public void checkCart(String phone) throws ClientProtocolException, IOException {
		Log.startTestCase("checkCart用例测试开始");
		String host = "http://release.thy360.com";
		String path = "/ja/user/v3/od/get/cart";
		String region = "813395";
//		String phone = "13714672775";
		String code = "1234";
		String introducerCode = "";
		String token = Login.getToken(phone, code, introducerCode);
		String cartresult = GetMethod.getHttpResult(host, path, region, token);
		Assert.assertTrue(cartresult.contains("上海青仔"));
		Log.endTestCase("checkCart用例测试结束");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("测试开始！！");
		DOMConfigurator.configure("log4j.xml");
		
	}

	@AfterClass
	public void afterClass() {
		System.out.println("测试结束");
	}

}
