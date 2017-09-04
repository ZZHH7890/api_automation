package common;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;

import net.sf.json.JSONObject;

public class Login {
	public static String getToken() throws IOException {
		Log.info("+++++++++++++++++开始调用Login获取token++++++++++++++++++++++");
		// 读取表格config.xlsx的第二行预发布环境信息
		JSONObject jsonconfig = GetApi.configJson(3);
		// 读取表格api.xlsx的第一行登录接口信息
		JSONObject jsonapi = GetApi.getApiJson(1);
		// 设置post方法的传入Body Data
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("phone", jsonconfig.getString("phone"));
		jsonParam.put("code", jsonconfig.getString("code"));
		jsonParam.put("introducerCode", jsonconfig.getString("introducerCode"));
		try {
			// 执行登录请求
			String loginResultString = HttpClientMethod.postJsonToken(jsonconfig.getString("host"),
					jsonapi.getString("apiurl"), jsonconfig.getString("region"), jsonParam);
			// 将登录请求返回的string 转化为json格式
			JSONObject loginResultJson = JSONObject.fromObject(loginResultString);
			// 从转化的json获取登录token
			String token = loginResultJson.getString("token");
			Log.info("+++++++++++++++++结束调用Login++++++++++++++++++++++");
			return token;
		} catch (Exception e) {
			String failString = "登录接口执行失败！！";
			Log.info(failString);
			return failString;
		}

	}

}
