package test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetDemoHttpClient {
	private static HttpClient httpClient = HttpClients.createDefault();
	private static HttpGet httpget;
	private static HttpResponse response;

	public static void main(String[] args) {
		String loginURL = "http://release.thy360.com/ja/user/v3/od/get/cart";
		try {
			httpget = new HttpGet(loginURL);
			httpget.setHeader("region", "813395");
			httpget.setHeader("token", "6237598f-bd13-4301-9f4a-f16c05800130");
			response = httpClient.execute(httpget);
			System.out.println(response.getStatusLine());
			String strResult = EntityUtils.toString(response.getEntity());
			System.out.println("查看返回的结果：" + strResult);
		} catch (Exception e) {
			e.printStackTrace();

		}
		httpget.releaseConnection();
	}

}