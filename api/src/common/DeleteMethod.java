package common;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DeleteMethod {
	public static String runDeleteApi(String host, String path, String region, String token)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用runDeleteApi++++++++++++++++++++++");
		HttpClient httpclient = HttpClients.createDefault();
		String apiurl = host + path;
		HttpDelete httpdelete = new HttpDelete(apiurl);
		httpdelete.setHeader("region", region);
		httpdelete.setHeader("token", token);
		Log.info("测试服务器：" + host);
		Log.info("测试接口：" + path);
		Log.info("测试社区：" + region);
		Log.info("用户登录token:" + token);
		HttpResponse httpresponse = httpclient.execute(httpdelete);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		Log.info("测试接口返回:" + strResult);
		httpdelete.releaseConnection();
		Log.info("+++++++++++++++++结束调用runDeleteApi++++++++++++++++++++++");
		return strResult;
	}
}
