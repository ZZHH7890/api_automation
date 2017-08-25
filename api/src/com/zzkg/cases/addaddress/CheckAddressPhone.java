package com.zzkg.cases.addaddress;

import org.testng.annotations.Test;

import common.ClearEnv;
import common.GetApi;
import common.HttpClientMethod;
import common.Log;
import common.Login;
import datapro.CheckAddressPhonePro;
import net.sf.json.JSONObject;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class CheckAddressPhone {
	@Test(enabled = true, dataProvider = "phone", dataProviderClass = CheckAddressPhonePro.class, priority = 1)
	public void addAddress(String name, String phone, String re) throws ClientProtocolException, IOException {
		Log.startTestCase("CheckAddressPhone�������Կ�ʼ");
		// ��ȡ���config.xlsx�ĵڶ���Ԥ����������Ϣ
		JSONObject jsonconfig = GetApi.configJson(2);
		// ��ȡ���api.xlsx�ĵ����������ջ���ַ�ӿ���Ϣ
		JSONObject jsonapi = GetApi.getApiJson(4);
		//����post�����Ĵ���Body Data
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("addressBuildingId", "350");
		jsonParam.put("addressNaviId", "18039");
		jsonParam.put("building", "�Զ�������¥������ɾ��");
		jsonParam.put("city1", "����");
		jsonParam.put("contact", name);
		jsonParam.put("gender", "0");
		jsonParam.put("latitude", "22.408965");
		jsonParam.put("longitude", "113.826119");
		jsonParam.put("phone", phone);
		jsonParam.put("regionId", "813395");
		jsonParam.put("room1", "11111A");
		jsonParam.put("village", "����ɽ");
		//ִ�нӿ����󲢻�ȡ�ӿڷ��ص�string���
		String respondresult = HttpClientMethod.postJson(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
				jsonconfig.getString("region"), Login.getToken(), jsonParam);
		Assert.assertTrue(respondresult.contains(re));
		Log.endTestCase("CheckAddressPhone�������Խ���");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("���Կ�ʼ����");
		//���ô�ӡ��־��������Ϣ
		DOMConfigurator.configure("log4j.xml");
	}

	@AfterClass
	public void afterClass() throws ClientProtocolException, IOException {
		ClearEnv.deleteAddress();
		System.out.println("���Խ�������");
	}

}
