package com.zzkg.cases.gift;

import org.testng.annotations.Test;

import common.HttpClientMethod;
import common.InitEnv;
import common.Log;
import common.Login;
import datapro.GetApi;
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
	@Test(enabled = true)
	public void negativeNumber() throws ClientProtocolException, IOException {
		Log.startTestCase("negativeNumber用例测试开始");
		// 表格中预发布环境在表格的第二行
		JSONObject jsonconfig = GetApi.configJson(2);
		// 表格中兑换赠品接口在表格的第三行
		JSONObject jsonapi = GetApi.getJsonApi(3);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", "-3");
		// 自动化测试赠品1
		jsonParam.put("dealId", "994140");
		jsonParam.put("selected", "true");
		String respondresult = HttpClientMethod.putJson(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
				jsonconfig.getString("region"), Login.getToken(), jsonParam);
		Assert.assertTrue(respondresult.contains("购买数量不能为负数"));
		Log.endTestCase("negativeNumber用例测试结束");
	}

	@Test(enabled = true)
	public void zeroNumber() throws ClientProtocolException, IOException {
		Log.startTestCase("zeroNumber用例测试开始");
		// 表格中预发布环境在表格的第二行
		JSONObject jsonconfig = GetApi.configJson(2);
		// 表格中兑换赠品接口在表格的第三行
		JSONObject jsonapi = GetApi.getJsonApi(3);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", "0");
		// 自动化测试赠品1
		jsonParam.put("dealId", "994140");
		jsonParam.put("selected", "true");
		String respondresult = HttpClientMethod.putJson(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
				jsonconfig.getString("region"), Login.getToken(), jsonParam);
		Assert.assertTrue(respondresult.contains("兑换成功"));
		Log.endTestCase("zeroNumber用例测试结束");
	}

	@BeforeMethod
	public void beforeMethod() throws ClientProtocolException, IOException {
		System.out.println("beforeTest");
		InitEnv.clearCart();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterTest");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("测试开始！！");
		DOMConfigurator.configure("log4j.xml");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("测试结束！！");
	}

}
