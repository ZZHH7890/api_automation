package com.zzkg.datapro.addaddressdata;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import common.ExcelData;

public class PhonePro {

	/*
	 * @DataProvider(name = "phone") public Object[][] addAddressPhoneData() {
	 * return new Object[][] { { "大爷134", "13414672776","成功" }, { "大爷135",
	 * "13514672776","成功" }, { "大爷136", "13614672776","成功"}, { "大爷137",
	 * "13714672776","成功" }, }; }
	 */

	@DataProvider(name = "phone")
	public Object[][] addAddressPhoneData() throws IOException {
		return ExcelData.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\testDataExcel\\", "testphoneone.xlsx", "phone");
	}
}
