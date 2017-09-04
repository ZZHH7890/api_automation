package test;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.xml.DOMConfigurator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PostArrayDemoHttpClient {

	
	private static CloseableHttpClient httpClient = HttpClients.createDefault();
	private static HttpPost httppost;
	private static HttpResponse httpresponse;

	
	public static void main(String[] args) {
		
		DOMConfigurator.configure("log4j.xml");
		String loginURL = "http://172.16.0.21/ja/user/v4/discovery/cae/quick/buy/false";
		// 创建一个httppost请求
		httppost = new HttpPost(loginURL);
		JSONObject jsonParamA = new JSONObject();
		jsonParamA.put("dealCount", "1");
		jsonParamA.put("dealId", "951142");
		
		JSONObject jsonParamB = new JSONObject();
		jsonParamB.put("dealCount", "1");
		jsonParamB.put("dealId", "947124");
		
		JSONObject jsonParamC = new JSONObject();
		jsonParamC.put("dealCount", "1");
		jsonParamC.put("dealId", "947128");
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(jsonParamA);
		jsonArray.add(jsonParamB);
		jsonArray.add(jsonParamC);
		
		try {
			
			StringEntity entity = new StringEntity(jsonArray.toString(), "utf-8");// 解决中文乱码问题
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httppost.setEntity(entity);
			httppost.setHeader("region", "121");
			httppost.setHeader("token", "4a926ec8-692a-4c4c-afd1-87e645dc32fb");
			httppost.setHeader("appversion", "wx:3.9.5");
			httpresponse = httpClient.execute(httppost);
			String strResult = EntityUtils.toString(httpresponse.getEntity());
			System.out.println("查看返回的结果：" + strResult);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		httppost.releaseConnection();
	}

	}


