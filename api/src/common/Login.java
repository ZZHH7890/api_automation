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
	public static String getToken()
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ����Login��ȡtoken++++++++++++++++++++++");
		// ��ȡ���config.xlsx�ĵڶ���Ԥ����������Ϣ
		JSONObject jsonconfig = GetApi.configJson(2);
		// ��ȡ���api.xlsx�ĵ�һ�е�¼�ӿ���Ϣ
		JSONObject jsonapi = GetApi.getApiJson(1);
		//����post�����Ĵ���Body Data
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("phone", jsonconfig.getString("phone"));
		jsonParam.put("code", jsonconfig.getString("code"));
		jsonParam.put("introducerCode", jsonconfig.getString("introducerCode"));
		//ִ�е�¼����
		String loginResultString = HttpClientMethod.postJsonToken(jsonconfig.getString("host"), jsonapi.getString("apiurl"), jsonconfig.getString("region"), jsonParam);
		//����¼���󷵻ص�string ת��Ϊjson��ʽ
		JSONObject loginResultJson = JSONObject.fromObject(loginResultString);
		//��ת����json��ȡ��¼token
		String token = loginResultJson.getString("token");
		Log.info("+++++++++++++++++��������Login++++++++++++++++++++++");
		return token;
	}

}
