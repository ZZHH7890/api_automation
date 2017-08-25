package com.zzkg.cases.gift;

import org.testng.annotations.Test;

import common.GetApi;
import common.HttpClientMethod;
import common.InitEnv;
import common.Log;
import common.Login;
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
		Log.startTestCase("negativeNumber�������Կ�ʼ");
		// �����Ԥ���������ڱ��ĵڶ���
		JSONObject jsonconfig = GetApi.configJson(2);
		// ����жһ���Ʒ�ӿ��ڱ��ĵ�����
		JSONObject jsonapi = GetApi.getApiJson(3);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", "-3");
		// �Զ���������Ʒ1
		jsonParam.put("dealId", "994140");
		jsonParam.put("selected", "true");
		String respondresult = HttpClientMethod.putJson(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
				jsonconfig.getString("region"), Login.getToken(), jsonParam);
		Assert.assertTrue(respondresult.contains("������������Ϊ����"));
		Log.endTestCase("negativeNumber�������Խ���");
	}

	@Test(enabled = true)
	public void zeroNumber() throws ClientProtocolException, IOException {
		Log.startTestCase("zeroNumber�������Կ�ʼ");
		// �����Ԥ���������ڱ��ĵڶ���
		JSONObject jsonconfig = GetApi.configJson(2);
		// ����жһ���Ʒ�ӿ��ڱ��ĵ�����
		JSONObject jsonapi = GetApi.getApiJson(3);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", "0");
		// �Զ���������Ʒ1
		jsonParam.put("dealId", "994140");
		jsonParam.put("selected", "true");
		String respondresult = HttpClientMethod.putJson(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
				jsonconfig.getString("region"), Login.getToken(), jsonParam);
		Assert.assertTrue(respondresult.contains("�һ��ɹ�"));
		Log.endTestCase("zeroNumber�������Խ���");
	}
	
	@Test(enabled = true)
	public void twoNumber() throws ClientProtocolException, IOException {
		Log.startTestCase("zeroNumber�������Կ�ʼ");
		// �����Ԥ���������ڱ��ĵڶ���
		JSONObject jsonconfig = GetApi.configJson(2);
		// ����жһ���Ʒ�ӿ��ڱ��ĵ�����
		JSONObject jsonapi = GetApi.getApiJson(3);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", "2");
		// �Զ���������Ʒ1
		jsonParam.put("dealId", "994140");
		jsonParam.put("selected", "true");
		String respondresult = HttpClientMethod.putJson(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
				jsonconfig.getString("region"), Login.getToken(), jsonParam);
		Assert.assertTrue(respondresult.contains("�һ��ɹ�"));
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
