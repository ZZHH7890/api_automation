package com.zzkg.cases.gift;

import org.testng.annotations.Test;

import common.GetApi;
import common.HttpClientMethod;
import common.InitEnv;
import common.Log;
import common.Login;
import datapro.ExchangeGiftPro;
import net.sf.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class ExchangeGift {
	@Test(enabled = true, dataProvider = "exchangeGift", dataProviderClass = ExchangeGiftPro.class, priority = 1)
	public void exchangeGift(String dealCount, String dealId, String selected, String expectValue)
			throws ClientProtocolException, IOException {
		Log.startTestCase("exchangeGift用例测试开始");
		// 读取表格config.xlsx的第二行预发布环境信息
		JSONObject jsonconfig = GetApi.configJson(2);
		// 读取表格api.xlsx的第三行兑换赠品接口信息
		JSONObject jsonapi = GetApi.getApiJson(3);
		//设置put方法的传入Body Data
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", dealCount);
		jsonParam.put("dealId", dealId);
		jsonParam.put("selected", selected);
		//执行接口请求并获取接口返回的string结果
		String respondresult = HttpClientMethod.putJson(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
				jsonconfig.getString("region"), Login.getToken(), jsonParam);
		Assert.assertTrue(respondresult.contains(expectValue));
		Log.endTestCase("exchangeGift用例测试结束");
	}

	@BeforeMethod
	public void beforeMethod() throws ClientProtocolException, IOException {
		InitEnv.clearCart();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterTest");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("测试开始！！");
		//设置打印日志的配置信息
		DOMConfigurator.configure("log4j.xml");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("测试结束！！");
	}

}
