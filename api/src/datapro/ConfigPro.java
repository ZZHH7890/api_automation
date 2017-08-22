package datapro;

import java.io.IOException;


import common.ExcelData;
import common.Login;

public class ConfigPro {
	public static String getHost() throws IOException {
		String[] initdata = ExcelData.getConfigData(
				"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\testConfigExcel\\", "config.xlsx",
				"config");
		String host = initdata[0];
		return host;
	}

	public static String getApi() throws IOException {
		String[] initdata = ExcelData.getConfigData(
				"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\testConfigExcel\\", "config.xlsx",
				"config");
		String api = initdata[1];
		return api;
	}

	public static String getRegion() throws IOException {
		String[] initdata = ExcelData.getConfigData(
				"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\testConfigExcel\\", "config.xlsx",
				"config");
		String region = initdata[2];
		return region;
	}

	public static String getPhone() throws IOException {
		String[] initdata = ExcelData.getConfigData(
				"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\testConfigExcel\\", "config.xlsx",
				"config");
		String phone = initdata[3];
		return phone;
	}

	public static String getCode() throws IOException {
		String[] initdata = ExcelData.getConfigData(
				"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\testConfigExcel\\", "config.xlsx",
				"config");
		String code = initdata[4];
		return code;
	}

	public static String getIntroducerCode() throws IOException {
		String[] initdata = ExcelData.getConfigData(
				"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\testConfigExcel\\", "config.xlsx",
				"config");
		String introducerCode = initdata[5];
		return introducerCode;
	}

}
