package com.zzkg.datapro;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.zzkg.common.ReadExcel;

public class BuyProcessPro {

	// ��ȡ����ӿ������jsonParam������ֵ
	@DataProvider(name = "buyProcess")
	public static Object[][] buyProcessData() throws IOException {
		return ReadExcel.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\ExcelForData\\",
				"testData.xlsx", "buyprocess");
	}

}
