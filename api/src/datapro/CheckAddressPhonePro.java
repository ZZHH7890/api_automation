package datapro;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import common.ReadExcel;

public class CheckAddressPhonePro {
	//��ȡ��񷵻��ջ����������ջ��˵绰���룬����ֵ
	@DataProvider(name = "phone")
	public static Object[][] addAddressPhoneData() throws IOException {
		return ReadExcel.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\testDataExcel\\", "CheckAddressPhone.xlsx", "phone");
	}
}
