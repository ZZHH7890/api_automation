package datapro;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import common.ReadExcel;

public class ExchangeGiftPro {
	//��ȡ��񷵻ضһ���Ʒ��������Ʒ��id,��Ʒ��״̬������ֵ
	@DataProvider(name = "exchangeGift")
	public static Object[][] exchangeGiftData() throws IOException {
		return ReadExcel.getTestData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\testDataExcel\\", "ExchangeGift.xlsx", "gift");
	}
}
