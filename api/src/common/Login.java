package common;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class Login {
	public static String getToken()
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用Login获取token++++++++++++++++++++++");
		// 预发布环境在表格的第二行
		JSONObject jsonconfig = GetApi.configJson(2);
		//登录接口在表格的第一行
		JSONObject jsonapi = GetApi.getApiJson(1);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("phone", jsonconfig.getString("phone"));
		jsonParam.put("code", jsonconfig.getString("code"));
		jsonParam.put("introducerCode", jsonconfig.getString("introducerCode"));
		String loginResultString = HttpClientMethod.postJsonToken(jsonconfig.getString("host"), jsonapi.getString("apiurl"), jsonconfig.getString("region"), jsonParam);
		JSONObject loginResultJson = JSONObject.fromObject(loginResultString);
		String token = loginResultJson.getString("token");
		Log.info("+++++++++++++++++结束调用Login++++++++++++++++++++++");
		return token;
	}

}
