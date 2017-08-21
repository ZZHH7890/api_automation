package cases;

import org.testng.annotations.Test;

import net.sf.json.JSONObject;

import org.testng.annotations.BeforeClass;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class UserLogin {
	private static CloseableHttpClient httpClient = HttpClients.createDefault();
	private static HttpPost httppost;
	private static HttpGet httpget;
	private static HttpResponse response;

	@Test
	public void loginPass() {

		String loginURL = "http://release.thy360.com/v2/regist/code";
		// ����һ��httppost����
		httppost = new HttpPost(loginURL);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("phone", "13714672774");
		jsonParam.put("code", "1234");
		jsonParam.put("introducerCode", "");

		try {

			StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");// ���������������
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httppost.setEntity(entity);
			response = httpClient.execute(httppost);
			String strResult = EntityUtils.toString(response.getEntity());
			System.out.println("�鿴���صĽ����" + strResult);
			Assert.assertTrue(strResult.contains("��¼�ɹ�"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		httppost.releaseConnection();
	}

	@Test
	public void getCartInfo() {

		String loginURL = "http://release.thy360.com//ja/user/v3/od/get/cart";
		try {
			httpget = new HttpGet(loginURL);
			httpget.setHeader("region", "813395");
			httpget.setHeader("token", "6237598f-bd13-4301-9f4a-f16c05800130");
			response = httpClient.execute(httpget);
			System.out.println(response.getStatusLine());
			String strResult = EntityUtils.toString(response.getEntity());
			System.out.println("�鿴���صĽ����" + strResult);
			Assert.assertTrue(strResult.contains("�Ż�����С�꣨����ɽ��"));
		} catch (Exception e) {
			e.printStackTrace();

		}
		httpget.releaseConnection();
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("���Կ�ʼ����");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("���Խ�������");
	}

}
