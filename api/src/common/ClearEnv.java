package common;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import net.sf.json.JSONObject;

public class ClearEnv {
	public static void deleteAddress() throws ClientProtocolException, IOException {
		// 预发布环境在表格的第二行
		JSONObject jsonconfig = GetApi.configJson(2);
		// 清空购物车接口在表格的第三行
		JSONObject jsonapi = GetApi.getApiJson(2);
		String result = HttpClientMethod.delete(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
				jsonconfig.getString("region"), Login.getToken());
		System.out.println("清空购物车成功:" + result);
	}
}
