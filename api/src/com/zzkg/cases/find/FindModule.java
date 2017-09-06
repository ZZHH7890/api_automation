package com.zzkg.cases.find;

import org.testng.annotations.Test;

import com.zzkg.common.InitEnv;
import com.zzkg.common.Log;
import com.zzkg.datapro.QuickBuyPro;
import com.zzkg.japi.JavaApi;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class FindModule {
	// 测试一键购买接口
	@Test(enabled = true, dataProvider = "quickBuy", dataProviderClass = QuickBuyPro.class, priority = 1)
	public void quickBuy(String jsonArrayString, String expectValue) throws ClientProtocolException, IOException {
		// 执行一键购买接口
		JavaApi.quickBuy(jsonArrayString);
		//检查添加到购物车中商品数量
		String respondresult = JavaApi.getCartCount();
		Assert.assertTrue(respondresult.contains(expectValue));
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		InitEnv.clearCart();
	}

	@AfterMethod
	public void afterMethod() throws IOException {
		InitEnv.clearCart();
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("FindModule用例测试开始");
	}

	@AfterClass
	public void afterClass() throws IOException {
		Log.endTestCase("FindModule用例测试结束");
	}

}
