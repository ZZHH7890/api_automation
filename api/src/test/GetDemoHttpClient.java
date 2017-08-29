package test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.xml.DOMConfigurator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetDemoHttpClient {
	private static HttpClient httpClient = HttpClients.createDefault();
	private static HttpGet httpget;
	private static HttpResponse response;

	public static void main(String[] args) {
		DOMConfigurator.configure("log4j.xml");
		String loginURL = "http://release.thy360.com/v2/address";
		try {
			httpget = new HttpGet(loginURL);
			httpget.setHeader("region", "813395");
			httpget.setHeader("token", "78241a07-8ecf-49b5-909a-6ec8eecebad3");
			response = httpClient.execute(httpget);
			System.out.println(response.getStatusLine());
			String strResult = EntityUtils.toString(response.getEntity());
			System.out.println("查看返回的结果：" + strResult);
			JSONArray jsonArray = JSONArray.fromObject(strResult);
			System.out.println(jsonArray.size());
			JSONObject jsonone = jsonArray.getJSONObject(0);
			System.out.println(jsonone.getString("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		httpget.releaseConnection();
	}

}