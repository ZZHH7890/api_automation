package common;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import net.sf.json.JSONObject;

public class ClearEnv {
	public static void deleteAddress() throws ClientProtocolException, IOException {
		// Ԥ���������ڱ��ĵڶ���
		JSONObject jsonconfig = GetApi.configJson(2);
		// ��չ��ﳵ�ӿ��ڱ��ĵ�����
		JSONObject jsonapi = GetApi.getApiJson(2);
		String result = HttpClientMethod.delete(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
				jsonconfig.getString("region"), Login.getToken());
		System.out.println("��չ��ﳵ�ɹ�:" + result);
	}
}
