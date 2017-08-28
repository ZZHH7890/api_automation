package common;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ClearEnv {
	public static void deleteAddress() throws ClientProtocolException, IOException {
		// Ԥ���������ڱ��ĵڶ���
		JSONObject jsonconfig = GetApi.configJson(2);
		// ��ȡ��¼token
		String token = Login.getToken();
		// ��ȡ�ջ���ַ�б�ӿ��ڱ��ĵ�����
		JSONObject jsonAddressApi = GetApi.getApiJson(6);
		try {
			// ��ȡ�ջ���ַ�б�ӿڷ���ֵstring����
			String addressStr = HttpClientMethod.get(jsonconfig.getString("host"), jsonAddressApi.getString("apiurl"),
					jsonconfig.getString("region"), token);
			// ���ջ���ַ�б�ӿڷ���ֵstring����ת��Ϊjson����
			JSONArray jsonAddressArrary = JSONArray.fromObject(addressStr);
			// ѭ����ȡ������ÿһ��json��key(id)��ֵ����ɾ����ַ�ӿ�
			if (jsonAddressArrary.size() == 0) {
				System.out.println("�û�û�е�ַ");
			} else {
				for (int i = 0; i < jsonAddressArrary.size(); i++) {
					Log.info("��Ҫɾ���ĵ�ַ����Ϊ��" + jsonAddressArrary.size());
					JSONObject jsonObject = jsonAddressArrary.getJSONObject(i);
					String idString = jsonObject.getString("id");
					// ɾ���ջ���ַ�ӿ��ڱ��ĵ�����
					JSONObject jsonDeleteAddressApi = GetApi.getApiJson(5);
					String deleteAddressString = HttpClientMethod.delete(jsonconfig.getString("host"),
							jsonDeleteAddressApi.getString("apiurl") + idString, jsonconfig.getString("region"), token);
				}
			}
		} catch (Exception e) {
			String failString = "������ʱɾ����ַʧ�ܣ���";
			Log.info(failString);
		}

	}
}
