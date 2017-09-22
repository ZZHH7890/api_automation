package com.zzkg.common;

import java.io.IOException;

import net.sf.json.JSONObject;

public class GetApi {
	//����ʼ������ת��Ϊjson����
	public static JSONObject configJson(int configrow) throws IOException {
		String[] initdata = ReadExcel.getConfigData(
				"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\ExcelForData\\", "testData.xlsx", "config", configrow);
		JSONObject jsonconfig = new JSONObject();
		jsonconfig.put("host", initdata[0]);
		jsonconfig.put("region", initdata[1]);
		jsonconfig.put("phone", initdata[2]);
		jsonconfig.put("code", initdata[3]);
		jsonconfig.put("introducerCode", initdata[4]);
		return jsonconfig;
	}
	
	//�����Խӿ�·��ת��Ϊjson����
	public static JSONObject getApiJson(int apirow) throws IOException {
		String[] initdata = ReadExcel.getApi(
				"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\ExcelForData\\", "testData.xlsx", "api",
				apirow);
		JSONObject jsonapi = new JSONObject();
		jsonapi.put("apiname", initdata[0]);
		jsonapi.put("apiurl", initdata[1]);
		return jsonapi;
	}
}
