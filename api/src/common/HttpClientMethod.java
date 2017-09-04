package common;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class HttpClientMethod {
	// put方法传入json body
	public static String putJson(String host, String path, String region, String token, JSONObject jsonParam)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用putJson++++++++++++++++++++++");
		HttpClient httpclient = HttpClients.createDefault();
		String apiurl = host + path;
		HttpPut httpput = new HttpPut(apiurl);
		httpput.setHeader("Content-Type", "application/json");
		httpput.setHeader("region", region);
		httpput.setHeader("token", token);
		Log.info("测试服务器：" + host);
		Log.info("测试接口：" + path);
		Log.info("测试社区：" + region);
		Log.info("用户登录token:" + token);
		Log.info("测试接口的传入json数据：" + jsonParam.toString());
		StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");// 解决中文乱码问题
		httpput.setEntity(entity);
		HttpResponse httpresponse = httpclient.execute(httpput);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		Log.info("测试接口返回:" + strResult);
		httpput.releaseConnection();
		Log.info("+++++++++++++++++结束调用putJson++++++++++++++++++++++");
		return strResult;
	}

	// get方法
	public static String get(String host, String path, String region, String token)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用get++++++++++++++++++++++");
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
		Log.info("+++++++++++++++++结束调用get++++++++++++++++++++++");
		return strResult;
	}

	// post方法传入单个json body 获取token（登录）
	public static String postJsonToken(String host, String path, String region, JSONObject jsonParam)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用postJsonToken++++++++++++++++++++++");
		HttpClient httpclient = HttpClients.createDefault();
		String apiurl = host + path;
		HttpPost httppost = new HttpPost(apiurl);
		httppost.setHeader("Content-Type", "application/json");
		httppost.setHeader("region", region);
		Log.info("测试服务器：" + host);
		Log.info("测试接口：" + path);
		Log.info("测试社区：" + region);
		Log.info("测试接口的传入json数据：" + jsonParam.toString());
		StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");// 解决中文乱码问题
		httppost.setEntity(entity);
		HttpResponse httpresponse = httpclient.execute(httppost);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		Log.info("测试接口返回:" + strResult);
		httppost.releaseConnection();
		Log.info("+++++++++++++++++结束调用postJsonToken++++++++++++++++++++++");
		return strResult;
	}

	// post方法传入单个json body（新增地址）
	public static String postJson(String host, String path, String region, String token, JSONObject jsonParam)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用postJson++++++++++++++++++++++");
		HttpClient httpclient = HttpClients.createDefault();
		String apiurl = host + path;
		HttpPost httppost = new HttpPost(apiurl);
		httppost.setHeader("Content-Type", "application/json");
		httppost.setHeader("region", region);
		httppost.setHeader("token", token);
		// 会员宝支付需要的appId
		httppost.setHeader("appId", "appidzzkg9021v754d");
		Log.info("测试服务器：" + host);
		Log.info("测试接口：" + path);
		Log.info("测试社区：" + region);
		Log.info("用户登录token:" + token);
		Log.info("测试接口的传入json数据：" + jsonParam.toString());
		StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");// 解决中文乱码问题
		httppost.setEntity(entity);
		HttpResponse httpresponse = httpclient.execute(httppost);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		Log.info("测试接口返回:" + strResult);
		httppost.releaseConnection();
		Log.info("+++++++++++++++++结束调用postJson++++++++++++++++++++++");
		return strResult;
	}

	// post方法传入jsonArray body(菜谱一键购买)
	public static String postJsonArray(String host, String path, String region, String token, JSONArray jsonArrayParam)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用postJson++++++++++++++++++++++");
		HttpClient httpclient = HttpClients.createDefault();
		String apiurl = host + path;
		HttpPost httppost = new HttpPost(apiurl);
		httppost.setHeader("Content-Type", "application/json");
		httppost.setHeader("region", region);
		httppost.setHeader("token", token);
		// 会员宝支付需要的appId
		httppost.setHeader("appId", "appidzzkg9021v754d");
		Log.info("测试服务器：" + host);
		Log.info("测试接口：" + path);
		Log.info("测试社区：" + region);
		Log.info("用户登录token:" + token);
		Log.info("测试接口的传入json数据：" + jsonArrayParam.toString());
		StringEntity entity = new StringEntity(jsonArrayParam.toString(), "utf-8");// 解决中文乱码问题
		httppost.setEntity(entity);
		HttpResponse httpresponse = httpclient.execute(httppost);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		Log.info("测试接口返回:" + strResult);
		httppost.releaseConnection();
		Log.info("+++++++++++++++++结束调用postJson++++++++++++++++++++++");
		return strResult;
	}

	// delete方法
	public static String delete(String host, String path, String region, String token)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用delete++++++++++++++++++++++");
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
		Log.info("+++++++++++++++++结束调用delete++++++++++++++++++++++");
		return strResult;
	}
}
