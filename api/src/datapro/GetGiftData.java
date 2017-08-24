package datapro;

import java.io.IOException;

import common.ReadExcel;

public class GetGiftData {
	
	public static String getHost() throws IOException {
		String[] initdata = ReadExcel.getExchangeGiftData(
				"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\initExcel\\", "init.xlsx", "init");
		String host = initdata[0];
		return host;
	}

	public static String getApi() throws IOException {
		String[] initdata = ReadExcel.getExchangeGiftData(
				"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\initExcel\\", "init.xlsx", "init");
		String api = initdata[1];
		return api;
	}

	public static String getRegion() throws IOException {
		String[] initdata = ReadExcel.getExchangeGiftData(
				"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\initExcel\\", "init.xlsx", "init");
		String region = initdata[2];
		return region;
	}

	public static String getPhone() throws IOException {
		String[] initdata = ReadExcel.getExchangeGiftData(
				"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\initExcel\\", "init.xlsx", "init");
		String phone = initdata[3];
		return phone;
	}

	public static String getCode() throws IOException {
		String[] initdata = ReadExcel.getExchangeGiftData(
				"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\initExcel\\", "init.xlsx", "init");
		String code = initdata[4];
		return code;
	}

	public static String getIntroducerCode() throws IOException {
		String[] initdata = ReadExcel.getExchangeGiftData(
				"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\initExcel\\", "init.xlsx", "init");
		String introducerCode = initdata[5];
		return introducerCode;
	}

}
