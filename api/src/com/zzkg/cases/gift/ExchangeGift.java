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
		Log.startTestCase("negativeNumber�������Կ�ʼ");
		JSONObject jsonconfig = GetConfig.config();
		JSONObject jsoncapi = GetApi.exchangeGiftApi();
		
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", "-3");
		//�Զ���������Ʒ1
		jsonParam.put("dealId", "994140");
		jsonParam.put("selected", "true");
		String respondresult = HttpClientMethod.putJson(jsonconfig.getString("host"), jsoncapi.getString("apiurl"), jsonconfig.getString("region"), Login.getToken(jsonconfig.getString("phone"), jsonconfig.getString("code"),jsonconfig.getString("introducerCode"))
, jsonParam);
		Assert.assertTrue(respondresult.contains("������������Ϊ����"));
        Log.endTestCase("negativeNumber�������Խ���");
	}
	
	@Test
	public void zeroNumber() throws ClientProtocolException, IOException {
		Log.startTestCase("zeroNumber�������Կ�ʼ");
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", "0");
		//�Զ���������Ʒ1
		jsonParam.put("dealId", "994140");
		jsonParam.put("selected", "true");
		String respondresult = HttpClientMethod.putJson(GetGiftData.getHost(), GetGiftData.getApi(), GetGiftData.getRegion(), Login.getToken(GetGiftData.getPhone(), GetGiftData.getCode(),GetGiftData.getIntroducerCode())
, jsonParam);
		Assert.assertTrue(respondresult.contains("������������Ϊ0"));
        Log.endTestCase("zeroNumber�������Խ���");
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
		System.out.println("���Կ�ʼ����");
		DOMConfigurator.configure("log4j.xml");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("���Խ�������");
	}

}
