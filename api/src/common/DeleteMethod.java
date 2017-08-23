package common;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DeleteMethod {
	public static String runDeleteApi(String host, String path, String region, String token)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ����runDeleteApi++++++++++++++++++++++");
		HttpClient httpclient = HttpClients.createDefault();
		String apiurl = host + path;
		HttpDelete httpdelete = new HttpDelete(apiurl);
		httpdelete.setHeader("region", region);
		httpdelete.setHeader("token", token);
		Log.info("���Է�������" + host);
		Log.info("���Խӿڣ�" + path);
		Log.info("����������" + region);
		Log.info("�û���¼token:" + token);
		HttpResponse httpresponse = httpclient.execute(httpdelete);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		Log.info("���Խӿڷ���:" + strResult);
		httpdelete.releaseConnection();
		Log.info("+++++++++++++++++��������runDeleteApi++++++++++++++++++++++");
		return strResult;
	}
}
