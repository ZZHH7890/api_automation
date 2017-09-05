package com.zzkg.datapro;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.zzkg.common.ReadExcel;

public class ExchangeGiftPro {
	//读取表格返回兑换赠品数量，赠品的id,赠品的状态，期望值
	@DataProvider(name = "exchangeGift")
	public static Object[][] exchangeGiftData() throws IOException {
		return ReadExcel.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\ExcelForData\\", "testData.xlsx", "testgift");
	}
}
