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
	public static String getToken(String phone, String code, String introducerCode)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用Login获取登录token++++++++++++++++++++++");
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建一个httppost请求
		String loginurl = "http://release.thy360.com/v2/regist/code";
		HttpPost httppost = new HttpPost(loginurl);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("phone", phone);
		jsonParam.put("code", code);
		jsonParam.put("introducerCode", introducerCode);
		StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");// 解决中文乱码问题
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		Log.info("登录接口路径："+ loginurl);
		Log.info("登录用户："+ jsonParam.getString("phone"));
		httppost.setEntity(entity);
		HttpResponse httpresponse = httpClient.execute(httppost);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		JSONObject jsonresult = JSONObject.fromObject(strResult);
		String token = jsonresult.getString("token");
		httppost.releaseConnection();
		Log.info("+++++++++++++++++结束调用Login返回登录token++++++++++++++++++++++");
		return token;
	}

}
