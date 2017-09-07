package com.zzkg.datapro;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.zzkg.common.ReadExcel;

public class ApiTestDataPro {

	// 获取增加地址接口所需的jsonParam和期望值
	@DataProvider(name = "address")
	public static Object[][] addAddressData() throws IOException {
		return ReadExcel.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\ExcelForData\\",
				"testData.xlsx", "address");
	}

	// 获取购买接口所需的jsonParam和期望值
	@DataProvider(name = "buyProcess")
	public static Object[][] buyProcessData() throws IOException {
		return ReadExcel.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\ExcelForData\\",
				"testData.xlsx", "buyprocess");
	}

	// 读取表格返回兑换赠品数量，赠品的id,赠品的状态，期望值
	@DataProvider(name = "exchangeGift")
	public static Object[][] exchangeGiftData() throws IOException {
		return ReadExcel.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\ExcelForData\\",
				"testData.xlsx", "gift");
	}

	// 读取表格返回一键购买jsonArrayParam和期望值
	@DataProvider(name = "quickBuy")
	public static Object[][] quickBuyData() throws IOException {
		return ReadExcel.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\ExcelForData\\",
				"testData.xlsx", "quickbuy");
	}

}
