package common;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class Login {
	public static String getToken(String phone, String code, String introducerCode)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ����Login��ȡ��¼token++++++++++++++++++++++");
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// ����һ��httppost����
		String loginurl = "http://release.thy360.com/v2/regist/code";
		HttpPost httppost = new HttpPost(loginurl);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("phone", phone);
		jsonParam.put("code", code);
		jsonParam.put("introducerCode", introducerCode);
		StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");// ���������������
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		Log.info("��¼�ӿ�·����"+ loginurl);
		Log.info("��¼�û���"+ jsonParam.getString("phone"));
		httppost.setEntity(entity);
		HttpResponse httpresponse = httpClient.execute(httppost);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		JSONObject jsonresult = JSONObject.fromObject(strResult);
		String token = jsonresult.getString("token");
		httppost.releaseConnection();
		Log.info("+++++++++++++++++��������Login���ص�¼token++++++++++++++++++++++");
		return token;
	}

}
