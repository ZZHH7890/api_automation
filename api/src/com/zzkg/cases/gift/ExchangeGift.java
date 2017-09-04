package com.zzkg.cases.gift;

import org.testng.annotations.Test;

import com.zzkg.common.GetApi;
import com.zzkg.common.HttpClientMethod;
import com.zzkg.common.InitEnv;
import com.zzkg.common.Log;
import com.zzkg.common.Login;
import com.zzkg.datapro.ExchangeGiftPro;
import com.zzkg.japi.JavaApi;

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
		// 执行兑换赠品接口
		String respondresult = JavaApi.exchangeGift(dealCount, dealId, selected);
		Assert.assertTrue(respondresult.contains(expectValue));
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
