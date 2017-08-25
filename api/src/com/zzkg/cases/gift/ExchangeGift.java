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
		Log.startTestCase("exchangeGift�������Կ�ʼ");
		// ��ȡ���config.xlsx�ĵڶ���Ԥ����������Ϣ
		JSONObject jsonconfig = GetApi.configJson(2);
		// ��ȡ���api.xlsx�ĵ����жһ���Ʒ�ӿ���Ϣ
		JSONObject jsonapi = GetApi.getApiJson(3);
		//����put�����Ĵ���Body Data
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", dealCount);
		jsonParam.put("dealId", dealId);
		jsonParam.put("selected", selected);
		//ִ�нӿ����󲢻�ȡ�ӿڷ��ص�string���
		String respondresult = HttpClientMethod.putJson(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
				jsonconfig.getString("region"), Login.getToken(), jsonParam);
		Assert.assertTrue(respondresult.contains(expectValue));
		Log.endTestCase("exchangeGift�������Խ���");
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
		//���ô�ӡ��־��������Ϣ
		DOMConfigurator.configure("log4j.xml");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("���Խ�������");
	}

}
