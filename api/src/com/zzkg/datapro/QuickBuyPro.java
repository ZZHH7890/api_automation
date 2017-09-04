package com.zzkg.datapro;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import common.ReadExcel;

public class QuickBuyPro {
	//读取表格返回一键购买jsonArrayParam和期望值
	@DataProvider(name = "quickBuy")
	public static Object[][] quickBuyData() throws IOException {
		return ReadExcel.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\ExcelForData\\", "testData.xlsx", "quickbuy");
	}
}
