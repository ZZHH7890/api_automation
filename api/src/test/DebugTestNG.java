package test;

import org.testng.annotations.Test;

import com.zzkg.common.ClearEnv;
import com.zzkg.common.GetApi;
import com.zzkg.common.HttpClientMethod;
import com.zzkg.common.InitEnv;
import com.zzkg.common.Log;
import com.zzkg.common.Login;

import net.sf.json.JSONArray;
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
		Log.info("�û�cartToken:" + cartToken);
		System.out.println("�û�cartToken��" + cartToken);
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
		System.out.println("��ȡ����ID��" + orderId);
		System.out.println("��ȡ������" + payAmount);
		// ִ�л�ȡԤ֧�������ӿ�
		JSONObject jsonPrepayOrderIdApi = GetApi.getApiJson(9);
		String jsonPrepayOrderIdString = HttpClientMethod.get(jsonConfig.getString("host"),
				jsonPrepayOrderIdApi.getString("apiurl") + orderId + "//" + payAmount + "//" + token,
				jsonConfig.getString("region"), token);
		System.out.println("��ȡԤ֧�������ӿڷ��أ�" + jsonPrepayOrderIdString);
		JSONObject prepayOrderApiJson = JSONObject.fromObject(jsonPrepayOrderIdString);
		String data = prepayOrderApiJson.getString("data");
		System.out.println("Ԥ֧����������json��" + data);
		JSONObject prepayOrderJson = JSONObject.fromObject(data);
		String prepayId = prepayOrderJson.getString("prepayId");
		System.out.println("Ԥ֧��������" + prepayId);
		// ִ�л�Ա��֧���ӿ�
		JSONObject payApiJson = GetApi.getApiJson(10);
		JSONObject payParamJson = new JSONObject();
		payParamJson.put("expireTime", "");
		payParamJson.put("password", "111111");
		String psyResult = HttpClientMethod.postJson(jsonConfig.getString("host"),
				payApiJson.getString("apiurl") + prepayId, jsonConfig.getString("region"), token, payParamJson);
		System.out.println("��Ա��֧���ӿڷ��أ�" + psyResult);
		Log.endTestCase("exchangeGift�������Խ���");
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
