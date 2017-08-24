package common;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import datapro.GetApi;
import net.sf.json.JSONObject;

public class InitEnv {
	public static void clearCart() throws ClientProtocolException, IOException {
		// Ԥ���������ڱ��ĵڶ���
		JSONObject jsonconfig = GetApi.configJson(2);
		// ��չ��ﳵ�ӿ��ڱ��ĵ�����
		JSONObject jsonapi = GetApi.getJsonApi(2);
		String result = HttpClientMethod.delete(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
				jsonconfig.getString("region"), Login.getToken());
		System.out.println("��չ��ﳵ�ɹ�:" + result);
	}

}
