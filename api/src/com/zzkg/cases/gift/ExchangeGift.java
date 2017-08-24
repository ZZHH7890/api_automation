package com.zzkg.cases.gift;

import org.testng.annotations.Test;

import common.HttpClientMethod;
import common.InitEnv;
import common.Log;
import common.Login;
import datapro.GetApi;
import datapro.GetConfig;
import datapro.GetGiftData;
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
	@Test
	public void negativeNumber() throws ClientProtocolException, IOException {
		Log.startTestCase("negativeNumber用例测试开始");
		JSONObject jsonconfig = GetConfig.config();
		JSONObject jsoncapi = GetApi.exchangeGiftApi();
		
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", "-3");
		//自动化测试赠品1
		jsonParam.put("dealId", "994140");
		jsonParam.put("selected", "true");
		String respondresult = HttpClientMethod.putJson(jsonconfig.getString("host"), jsoncapi.getString("apiurl"), jsonconfig.getString("region"), Login.getToken(jsonconfig.getString("phone"), jsonconfig.getString("code"),jsonconfig.getString("introducerCode"))
, jsonParam);
		Assert.assertTrue(respondresult.contains("购买数量不能为负数"));
        Log.endTestCase("negativeNumber用例测试结束");
	}
	
	@Test
	public void zeroNumber() throws ClientProtocolException, IOException {
		Log.startTestCase("zeroNumber用例测试开始");
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", "0");
		//自动化测试赠品1
		jsonParam.put("dealId", "994140");
		jsonParam.put("selected", "true");
		String respondresult = HttpClientMethod.putJson(GetGiftData.getHost(), GetGiftData.getApi(), GetGiftData.getRegion(), Login.getToken(GetGiftData.getPhone(), GetGiftData.getCode(),GetGiftData.getIntroducerCode())
, jsonParam);
		Assert.assertTrue(respondresult.contains("购买数量不能为0"));
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
