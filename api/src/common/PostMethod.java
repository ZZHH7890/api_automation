package common;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class PostMethod {
	public static String getHttpResult(String host, String path, String region, String token, JSONObject jsonParam)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用PostMethod++++++++++++++++++++++");
		HttpClient httpclient = HttpClients.createDefault();
		String apiurl = host + path;
		HttpPost httppost = new HttpPost(apiurl);
		httppost.setHeader("Content-Type", "application/json");
		httppost.setHeader("region", region);
		httppost.setHeader("token", token);
		Log.info("测试服务器：" + host);
		Log.info("测试接口：" + path);
		Log.info("测试社区：" + region);
		Log.info("用户登录token:" + token);
		Log.info("测试接口的传入json数据："+jsonParam.toString());
		StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");// 解决中文乱码问题
		httppost.setEntity(entity);
		HttpResponse httpresponse = httpclient.execute(httppost);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		Log.info("测试接口返回:" + strResult);
		httppost.releaseConnection();
		Log.info("+++++++++++++++++结束调用PostMethod++++++++++++++++++++++");
		return strResult;
		
	}
}
