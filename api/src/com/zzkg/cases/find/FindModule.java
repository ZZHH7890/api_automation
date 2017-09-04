package com.zzkg.cases.find;

import org.testng.annotations.Test;

import com.zzkg.datapro.QuickBuyPro;
import com.zzkg.japi.JavaApi;

import common.Log;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class FindModule {
	// 测试一键购买
	@Test(enabled = true, dataProvider = "quickBuy", dataProviderClass = QuickBuyPro.class, priority = 1)
	public void quickBuy(String jsonArrayString, String expectValue) throws ClientProtocolException, IOException {
		// 执行一键购买接口，获取返回值
		String respondresult = JavaApi.quickBuy(jsonArrayString);
		Assert.assertTrue(respondresult.contains(expectValue));

	}

	@BeforeClass
	public void beforeClass() {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("FindModule用例测试开始");
	}

	@AfterClass
	public void afterClass() {
		Log.endTestCase("FindModule用例测试结束");
	}

}
