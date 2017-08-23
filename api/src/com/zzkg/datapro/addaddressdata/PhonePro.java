package com.zzkg.datapro.addaddressdata;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import common.ReadExcel;

public class PhonePro {
	@DataProvider(name = "phone")
	public static Object[][] addAddressPhoneData() throws IOException {
		return ReadExcel.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\testDataExcel\\", "testphoneone.xlsx", "phone");
	}
}
