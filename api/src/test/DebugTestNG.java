package test;

import org.testng.annotations.Test;

import common.ClearEnv;
import common.GetApi;
import common.HttpClientMethod;
import common.InitEnv;
import common.Log;
import common.Login;
import datapro.ExchangeGiftPro;
import net.sf.json.JSONObject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class DebugTestNG {
	@Test(enabled = true)
	public void exchangeGift() throws ClientProtocolException, IOException {
		Log.startTestCase("exchangeGift�������Կ�ʼ");
		// ��ȡ���config.xlsx�ĵڶ���Ԥ����������Ϣ
		JSONObject jsonConfig = GetApi.configJson(2);
		// ��ȡ��¼token
		String token = Login.getToken();
		// �һ���Ʒ
		JSONObject jsonExchangeGiftApi = GetApi.getApiJson(3);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", "1");
		jsonParam.put("dealId", "994141");
		jsonParam.put("selected", "true");
		HttpClientMethod.putJson(jsonConfig.getString("host"), jsonExchangeGiftApi.getString("apiurl"),
				jsonConfig.getString("region"), token, jsonParam);
		// ����ȷ����Ϣ��ȡcarttoken
		JSONObject jsonOrderConfirmApi = GetApi.getApiJson(7);
		String orderConfirmString = HttpClientMethod.get(jsonConfig.getString("host"),
				jsonOrderConfirmApi.getString("apiurl"), jsonConfig.getString("region"), token);
		JSONObject orderConfirmJson = JSONObject.fromObject(orderConfirmString);
		String cartToken = orderConfirmJson.getString("cartToken");
		// ִ���µ��ӿڻ�ȡ�����ţ�֧�����
		JSONObject jsonOrderApi = GetApi.getApiJson(8);
		JSONObject jsonOrderParam = new JSONObject();
		jsonOrderParam.put("addressId", "15830");
		jsonOrderParam.put("buyWay", "1");
		jsonOrderParam.put("cartToken", cartToken);
		jsonOrderParam.put("deliverType", "-1");
		jsonOrderParam.put("delivertime", "06:00-07:30");
		jsonOrderParam.put("remark", "");
		jsonOrderParam.put("serviceReminderFlag", "2");
		String orderJsonString = HttpClientMethod.postJson(jsonConfig.getString("host"),
				jsonOrderApi.getString("apiurl"), jsonConfig.getString("region"), token, jsonOrderParam);
		JSONObject orderJson = JSONObject.fromObject(orderJsonString);
		String orderId = orderJson.getString("id");
		String payAmount = orderJson.getString("payAmount");
		// ִ�л�ȡԤ֧�������ӿ�
		JSONObject jsonPrepayOrderIdApi = GetApi.getApiJson(9);
		String jsonPrepayOrderIdString = HttpClientMethod.get(jsonConfig.getString("host"),
				jsonPrepayOrderIdApi.getString("apiurl") + orderId + "//" + payAmount + "//" + token,
				jsonConfig.getString("region"), token);
		JSONObject preorderJson = JSONObject.fromObject(jsonPrepayOrderIdString);
		String preorderId = preorderJson.getString("prepayId");
		System.out.println("Ԥ֧��������" + preorderId);

		Log.endTestCase("exchangeGift�������Խ���");
	}

	@BeforeMethod
	public void beforeMethod() throws ClientProtocolException, IOException {
		InitEnv.clearCart();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("���Կ�ʼ����");
		// ���ô�ӡ��־��������Ϣ
		DOMConfigurator.configure("log4j.xml");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("���Խ�������");
	}

}
