package com.zzkg.datapro.addaddressdata;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import common.ExcelData;

public class PhonePro {
	@DataProvider(name = "phone")
	public static Object[][] addAddressPhoneData() throws IOException {
		return ExcelData.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\testDataExcel\\", "testphoneone.xlsx", "phone");
	}
}
