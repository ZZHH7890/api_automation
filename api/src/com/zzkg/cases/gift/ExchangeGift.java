package com.zzkg.cases.gift;

import org.testng.annotations.Test;

import com.zzkg.japi.JavaApi;

import common.GetApi;
import common.HttpClientMethod;
import common.InitEnv;
import common.Log;
import common.Login;
import datapro.ExchangeGiftPro;
import net.sf.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class ExchangeGift {
	//���Զһ���Ʒ�ӿ�
	@Test(enabled = true, dataProvider = "exchangeGift", dataProviderClass = ExchangeGiftPro.class, priority = 1)
	public void exchangeGift(String dealCount, String dealId, String selected, String expectValue)
			throws ClientProtocolException, IOException {
		Log.startTestCase("exchangeGift�������Կ�ʼ");
		// ִ�жһ���Ʒ�ӿ�
		String respondresult = JavaApi.exchangeGift(dealCount, dealId, selected);
		Assert.assertTrue(respondresult.contains(expectValue));
		Log.endTestCase("exchangeGift�������Խ���");
	}

	@BeforeMethod
	public void beforeMethod() throws ClientProtocolException, IOException {
		InitEnv.clearCart();
	}

	@AfterMethod
	public void afterMethod() throws ClientProtocolException, IOException {
		InitEnv.clearCart();
	}

	@BeforeClass
	public void beforeClass() {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("ExchangeGift�������Կ�ʼ");
		

	}

	@AfterClass
	public void afterClass() {
		Log.endTestCase("ExchangeGift�������Խ���");
	}

	

}
