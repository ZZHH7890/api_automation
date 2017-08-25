package common;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import net.sf.json.JSONObject;

public class InitEnv {
	public static void clearCart() throws ClientProtocolException, IOException {
		// 读取表格config.xlsx的第二行预发布环境信息
		JSONObject jsonconfig = GetApi.configJson(2);
		// 读取表格api.xlsx的第二行清空购物车接口信息
		JSONObject jsonapi = GetApi.getApiJson(2);
		//执行清空购物车请求
		String result = HttpClientMethod.delete(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
				jsonconfig.getString("region"), Login.getToken());
		System.out.println("清空购物车成功:" + result);
	}

}
