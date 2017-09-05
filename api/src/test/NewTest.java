package test;

import org.testng.annotations.Test;

import com.zzkg.datapro.AddAddressPro;
import com.zzkg.japi.JavaApi;

import net.sf.json.JSONObject;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {

	@Test()
	public void test() throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httppost;
		String loginURL = "http://release.thy360.com/v3/setting/address";
		// 创建一个httppost请求
		httppost = new HttpPost(loginURL);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("contact", "zhang");
		jsonParam.put("phone", "13714672776");
		jsonParam.put("gender", "0");
		jsonParam.put("regionId", "813395");
		jsonParam.put("latitude", "22.408965");
		jsonParam.put("longitude", "113.826119");
		jsonParam.put("room1", "11111");
		jsonParam.put("village", "东角山");
		jsonParam.put("city1", "深圳");
		jsonParam.put("addressNaviId", "18039");
		jsonParam.put("building", "自动化测试楼栋C栋（勿删）");
		jsonParam.put("addressBuildingId", "256");

		StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");// 解决中文乱码问题
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httppost.setEntity(entity);
		httppost.setHeader("region", "813395");
		httppost.setHeader("token", "0c44f0f8-79a5-4035-8add-ca9cab07e12f");
		httppost.setHeader("appversion", "wx:3.9.5");
		CloseableHttpResponse httpresponse = httpClient.execute(httppost);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		System.out.println("查看返回的结果：" + strResult);

		httpresponse.close();
		httppost.releaseConnection();
		httpClient.close();
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("START");
		DOMConfigurator.configure("log4j.xml");

	}

	@AfterClass
	public void afterClass() {
		System.out.println("END");
	}

}
