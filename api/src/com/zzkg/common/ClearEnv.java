package com.zzkg.common;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ClearEnv {
	// ����ջ���ַ
	public static void deleteAddress() throws ClientProtocolException, IOException {
		// Ԥ���������ڱ��ĵڶ���
		JSONObject jsonconfig = GetApi.configJson(Config.TEST_ENV);
		// ��ȡ��¼token
		String token = Login.getToken();
		// ��ȡ�ջ���ַ�б�ӿ��ڱ��ĵ�����
		JSONObject jsonAddressApi = GetApi.getApiJson(6);
		try {
			// ��ȡ�ջ���ַ�б�ӿڷ���ֵstring����
			String addressStr = HttpClientMethod.get(jsonconfig.getString("host"), jsonAddressApi.getString("apiurl"),
					jsonconfig.getString("region"), token);
			// ���ջ���ַ�б�ӿڷ���ֵstring����ת��Ϊjson����
			JSONArray jsonAddressArrary = JSONArray.fromObject(addressStr);
			// ѭ����ȡ������ÿһ��json��key(id)��ֵ����ɾ����ַ�ӿ�
			if (jsonAddressArrary.size() == 0) {
				Log.info("�û�û�е�ַ,����Ҫ��յ�ַ");
			} else {
				for (int i = 0; i < jsonAddressArrary.size(); i++) {
					Log.info("��Ҫɾ���ĵ�ַ����Ϊ��" + jsonAddressArrary.size());
					JSONObject jsonObject = jsonAddressArrary.getJSONObject(i);
					String idString = jsonObject.getString("id");
					// ɾ���ջ���ַ�ӿ��ڱ��ĵ�����
					JSONObject jsonDeleteAddressApi = GetApi.getApiJson(5);
					HttpClientMethod.delete(jsonconfig.getString("host"),
							jsonDeleteAddressApi.getString("apiurl") + idString, jsonconfig.getString("region"), token);
				}
			}
		} catch (Exception e) {
			String failString = "������ʱɾ����ַʧ�ܣ���";
			Log.info(failString);
		}

	}

	// ��չ��ﳵ
	public static void clearCart() throws IOException {
		Log.info("��չ��ﳵ");
		// ��ȡ������Ϣ
		JSONObject jsonconfig = GetApi.configJson(Config.TEST_ENV);
		// ��ȡ�ӿ���Ϣ
		JSONObject jsonapi = GetApi.getApiJson(2);
		try {
			// ִ����չ��ﳵ����
			String result = HttpClientMethod.delete(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
					jsonconfig.getString("region"), Login.getToken());
			Log.info("��չ��ﳵ�ɹ�!" + result);

		} catch (Exception e) {
			String failString = "���ӵ�ַ��չ��ﳵʧ�ܣ�";
			Log.info(failString);
		}
	}
}
