package com.zzkg.datapro.addaddressdata;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import common.ExcelData;

public class PhonePro {

	/*
	 * @DataProvider(name = "phone") public Object[][] addAddressPhoneData() {
	 * return new Object[][] { { "��ү134", "13414672776","�ɹ�" }, { "��ү135",
	 * "13514672776","�ɹ�" }, { "��ү136", "13614672776","�ɹ�"}, { "��ү137",
	 * "13714672776","�ɹ�" }, }; }
	 */

	@DataProvider(name = "phone")
	public Object[][] addAddressPhoneData() throws IOException {
		return ExcelData.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\testDataExcel\\", "testphoneone.xlsx", "phone");
	}
}
