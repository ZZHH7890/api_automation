package common;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetMethod {
	public static String getHttpResult(String host, String path, String region, String token)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用GetMethod++++++++++++++++++++++");
		HttpClient httpclient = HttpClients.createDefault();
		String apiurl = host + path;
		HttpGet httpget = new HttpGet(apiurl);
		httpget.setHeader("region", region);
		httpget.setHeader("token", token);
		Log.info("测试服务器：" + host);
		Log.info("测试接口：" + path);
		Log.info("测试社区：" + region);
		Log.info("用户登录token:" + token);
		HttpResponse httpresponse = httpclient.execute(httpget);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		Log.info("测试接口返回:" + strResult);
		httpget.releaseConnection();
		Log.info("+++++++++++++++++结束调用GetMethod++++++++++++++++++++++");
		return strResult;
	}
}
