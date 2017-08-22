package com.zzkg.cases.cart;

import org.testng.annotations.Test;
import common.GetMethod;
import common.Log;
import common.Login;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class CheckCart {
	@Test
	public void checkCart() throws ClientProtocolException, IOException {
		Log.startTestCase("checkCart�������Կ�ʼ");
		String host = "http://release.thy360.com";
		String path = "/ja/user/v3/od/get/cart";
		String region = "813395";
		String phone = "13714672775";
		String code = "1234";
		String introducerCode = "";
		String token = Login.getToken(phone, code, introducerCode);
		String cartresult = GetMethod.getHttpResult(host, path, region, token);
		Assert.assertTrue(cartresult.contains("�Ϻ�����"));
		Log.endTestCase("checkCart�������Խ���");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("���Կ�ʼ����");
		DOMConfigurator.configure("log4j.xml");
		
	}

	@AfterClass
	public void afterClass() {
		System.out.println("���Խ���");
	}

}
