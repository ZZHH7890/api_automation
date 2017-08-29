package test;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;

import common.GetApi;
import common.HttpClientMethod;
import common.Login;
import net.sf.json.JSONObject;

public class GetDemoHttpDelete {

	public static void main(String[] args) throws IOException {
		DOMConfigurator.configure("log4j.xml");
		String token = Login.getToken();
		// �����Ԥ���������ڱ��ĵڶ���
		JSONObject jsonconfig = GetApi.configJson(2);
		// �����ɾ����ַ�ӿ��ڱ��ĵ�����
		JSONObject jsonGetAddressApi = GetApi.getApiJson(6);
		String reslut = HttpClientMethod.get(jsonconfig.getString("host"), jsonGetAddressApi.getString("apiurl"),
				jsonconfig.getString("region"), token);
		System.out.println("��ȡ�ջ���ַ�б�" + reslut);
		// �����ɾ����ַ�ӿ��ڱ��ĵ�����
		/*
		 * JSONObject jsonDeleteAddressApi = GetApi.getApiJson(5);
		 * HttpClientMethod.delete(jsonconfig.getString("host"),
		 * jsonDeleteAddressApi.getString("apiurl") + "//" + "15692",
		 * jsonconfig.getString("region"), token);
		 */

	}

}
