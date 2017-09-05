package com.zzkg.cases.gift;

import org.testng.annotations.Test;
import com.zzkg.common.InitEnv;
import com.zzkg.common.Log;
import com.zzkg.datapro.ExchangeGiftPro;
import com.zzkg.japi.JavaApi;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class ExchangeGift {
	// ���Զһ���Ʒ�ӿ�
	@Test(enabled = true, dataProvider = "exchangeGift", dataProviderClass = ExchangeGiftPro.class, priority = 1)
	public void exchangeGift(String jsonString, String expectValue) throws ClientProtocolException, IOException {
		// ִ�жһ���Ʒ�ӿ�
		String respondresult = JavaApi.exchangeGift(jsonString);
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
		Log.startTestCase("ExchangeGift�������Կ�ʼ");
	}

	@AfterClass
	public void afterClass() {
		Log.endTestCase("ExchangeGift�������Խ���");
	}

}
