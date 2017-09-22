package com.zzkg.datapro;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.zzkg.common.ReadExcel;

public class ApiTestDataPro {

	// ��ȡ���ӵ�ַ�ӿ������jsonParam������ֵ
	@DataProvider(name = "address")
	public static Object[][] addAddressData() throws IOException {
		return ReadExcel.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\ExcelForData\\",
				"testData.xlsx", "address");
	}

	// ��ȡ����ӿ������jsonParam������ֵ
	@DataProvider(name = "buyProcess")
	public static Object[][] buyProcessData() throws IOException {
		return ReadExcel.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\ExcelForData\\",
				"testData.xlsx", "buyprocess");
	}

	// ��ȡ��񷵻ضһ���Ʒ��������Ʒ��id,��Ʒ��״̬������ֵ
	@DataProvider(name = "exchangeGift")
	public static Object[][] exchangeGiftData() throws IOException {
		return ReadExcel.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\ExcelForData\\",
				"testData.xlsx", "gift");
	}

	// ��ȡ��񷵻�һ������jsonArrayParam������ֵ
	@DataProvider(name = "quickBuy")
	public static Object[][] quickBuyData() throws IOException {
		return ReadExcel.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\ExcelForData\\",
				"testData.xlsx", "quickbuy");
	}

}
