package common;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import net.sf.json.JSONObject;

public class InitEnv {
	public static void clearCart() throws ClientProtocolException, IOException {
		Log.info("��չ��ﳵ");
		// ��ȡ���config.xlsx�ĵڶ���Ԥ����������Ϣ
		JSONObject jsonconfig = GetApi.configJson(2);
		// ��ȡ���api.xlsx�ĵڶ�����չ��ﳵ�ӿ���Ϣ
		JSONObject jsonapi = GetApi.getApiJson(2);
		//ִ����չ��ﳵ����
		String result = HttpClientMethod.delete(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
				jsonconfig.getString("region"), Login.getToken());
		System.out.println("��չ��ﳵ�ɹ�:" + result);
	}
}
