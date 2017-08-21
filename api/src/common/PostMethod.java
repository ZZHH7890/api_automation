package common;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class PostMethod {
	public static String getHttpResult(String host, String path, String region, String token, JSONObject jsonParam)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ����PostMethod++++++++++++++++++++++");
		HttpClient httpclient = HttpClients.createDefault();
		String apiurl = host + path;
		HttpPost httppost = new HttpPost(apiurl);
		httppost.setHeader("Content-Type", "application/json");
		httppost.setHeader("region", region);
		httppost.setHeader("token", token);
		Log.info("���Է�������" + host);
		Log.info("���Խӿڣ�" + path);
		Log.info("����������" + region);
		Log.info("�û���¼token:" + token);
		Log.info("���ԽӿڵĴ���json���ݣ�"+jsonParam.toString());
		StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");// ���������������
		httppost.setEntity(entity);
		HttpResponse httpresponse = httpclient.execute(httppost);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		Log.info("���Խӿڷ���:" + strResult);
		httppost.releaseConnection();
		Log.info("+++++++++++++++++��������PostMethod++++++++++++++++++++++");
		return strResult;
		
	}
}
