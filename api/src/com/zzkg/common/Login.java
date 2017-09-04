package com.zzkg.common;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;

import net.sf.json.JSONObject;

public class Login {
	public static String getToken() throws IOException {
		Log.info("+++++++++++++++++��ʼ����Login��ȡtoken++++++++++++++++++++++");
		// ��ȡ���config.xlsx�ĵڶ���Ԥ����������Ϣ
		JSONObject jsonconfig = GetApi.configJson(Config.TEST_ENV);
		// ��ȡ���api.xlsx�ĵ�һ�е�¼�ӿ���Ϣ
		JSONObject jsonapi = GetApi.getApiJson(1);
		// ����post�����Ĵ���Body Data
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("phone", jsonconfig.getString("phone"));
		jsonParam.put("code", jsonconfig.getString("code"));
		jsonParam.put("introducerCode", jsonconfig.getString("introducerCode"));
		try {
			// ִ�е�¼����
			String loginResultString = HttpClientMethod.postJsonToken(jsonconfig.getString("host"),
					jsonapi.getString("apiurl"), jsonconfig.getString("region"), jsonParam);
			// ����¼���󷵻ص�string ת��Ϊjson��ʽ
			JSONObject loginResultJson = JSONObject.fromObject(loginResultString);
			// ��ת����json��ȡ��¼token
			String token = loginResultJson.getString("token");
			Log.info("+++++++++++++++++��������Login++++++++++++++++++++++");
			return token;
		} catch (Exception e) {
			String failString = "��¼�ӿ�ִ��ʧ�ܣ���";
			Log.info(failString);
			return failString;
		}

	}

}
