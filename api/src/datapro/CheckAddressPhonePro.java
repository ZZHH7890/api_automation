package datapro;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import common.ReadExcel;

public class CheckAddressPhonePro {
	//读取表格返回收货人姓名，收货人电话号码，期望值
	@DataProvider(name = "phone")
	public static Object[][] addAddressPhoneData() throws IOException {
		return ReadExcel.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\ExcelForData\\", "testData.xlsx", "phone");
	}
}
