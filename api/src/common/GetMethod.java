package common;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetMethod {
	public static String getHttpResult(String host, String path, String region, String token)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��������GetMethod++++++++++++++++++++++");
		HttpClient httpclient = HttpClients.createDefault();
		String apiurl = host + path;
		HttpGet httpget = new HttpGet(apiurl);
		httpget.setHeader("region", region);
		httpget.setHeader("token", token);
		Log.info("���Է�������" + host);
		Log.info("���Խӿڣ�" + path);
		Log.info("����������" + region);
		Log.info("�û���¼token:" + token);
		HttpResponse httpresponse = httpclient.execute(httpget);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		Log.info("���Խӿڷ���:" + strResult);
		httpget.releaseConnection();
		Log.info("+++++++++++++++++��������GetMethod++++++++++++++++++++++");
		return strResult;
	}
}
