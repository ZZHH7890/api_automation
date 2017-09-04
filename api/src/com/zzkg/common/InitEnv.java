package com.zzkg.common;

import java.io.FileWriter;
import java.io.IOException;

import com.zzkg.japi.JavaApi;

import net.sf.json.JSONObject;

public class InitEnv {
	// ��չ��ﳵ
	public static void clearCart() throws IOException {
		Log.info("��չ��ﳵ");
		// ��ȡ���config.xlsx�ĵڶ���Ԥ����������Ϣ
		JSONObject jsonconfig = GetApi.configJson(Config.TEST_ENV);
		// ��ȡ���api.xlsx�ĵڶ�����չ��ﳵ�ӿ���Ϣ
		JSONObject jsonapi = GetApi.getApiJson(2);
		try {
			// ִ����չ��ﳵ����
			String result = HttpClientMethod.delete(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
					jsonconfig.getString("region"), Login.getToken());
			Log.info("��չ��ﳵ�ɹ�!" + result);

		} catch (Exception e) {
			String failString = "���ӵ�ַʧ�ܣ�";
			Log.info(failString);
		}

	}

	// �����ջ���ַ
	public static void addAddress() {
//		try {
//			JavaApi.addAddress("259", "18039", "�Զ�������¥������ɾ��", "����", "�Ŵ�ү", "0", "22.408965", "113.826119",
//					"13714672776", "813395", "11111Aa", "����ɽ");
//		} catch (Exception e) {
//			String failString = "���ӵ�ַʧ�ܣ�";
//			Log.info(failString);
//		}
	}

	// �����־
	public static void clearLog() {
		try {
			FileWriter fw = new FileWriter(
					"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\log\\logfile.log", false);
			fw.write("");
			fw.flush();
			fw.close();
			String successString = "�����־�ɹ���";
			Log.info(successString);
		} catch (Exception e) {
			String failString = "�����־ʧ�ܣ�";
			Log.info(failString);
		}
	}

}
