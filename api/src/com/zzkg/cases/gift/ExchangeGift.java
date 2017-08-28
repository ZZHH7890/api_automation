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
	//测试兑换赠品接口
	@Test(enabled = true, dataProvider = "exchangeGift", dataProviderClass = ExchangeGiftPro.class, priority = 1)
	public void exchangeGift(String dealCount, String dealId, String selected, String expectValue)
			throws ClientProtocolException, IOException {
		Log.startTestCase("exchangeGift用例测试开始");
		// 执行兑换赠品接口
		String respondresult = JavaApi.exchangeGift(dealCount, dealId, selected);
		Assert.assertTrue(respondresult.contains(expectValue));
		Log.endTestCase("exchangeGift用例测试结束");
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
		Log.startTestCase("ExchangeGift用例测试开始");
	}

	@AfterClass
	public void afterClass() {
		Log.endTestCase("ExchangeGift用例测试结束");
	}

	

}
