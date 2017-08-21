package test;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;



public class PostDemoHttpClient {

	private static CloseableHttpClient httpClient = HttpClients.createDefault();
	private static HttpPost httppost;
	private static HttpResponse httpresponse;


	public static void main(String[] args) {

		String loginURL = "http://release.thy360.com/v2/regist/code";
		// ����һ��httppost����
		httppost = new HttpPost(loginURL);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("phone", "13714672774");
		jsonParam.put("code", "1234");
		jsonParam.put("introducerCode", "");
		System.out.println(jsonParam.get("phone"));

		try {
			
			StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");// ���������������
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httppost.setEntity(entity);
			httpresponse = httpClient.execute(httppost);
			String strResult = EntityUtils.toString(httpresponse.getEntity());
			System.out.println("�鿴���صĽ����" + strResult);
			JSONObject jsonresult = JSONObject.fromObject(strResult);
			System.out.println(jsonresult.getString("token"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		httppost.releaseConnection();
	}

}
