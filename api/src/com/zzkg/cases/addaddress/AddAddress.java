package com.zzkg.cases.addaddress;

import org.testng.annotations.Test;

import com.zzkg.japi.JavaApi;

import common.ClearEnv;
import common.Log;
import datapro.AddAddressPro;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class AddAddress {

	// ��������ջ���ַ
	@Test(enabled = true, dataProvider = "address", dataProviderClass = AddAddressPro.class, priority = 1)
	public void checkAddAddress(String addressBuildingId, String addressNaviId, String building, String city1,
			String contact, String gender, String latitude, String longitude, String phone, String regionId,
			String room1, String village, String expectValue) throws ClientProtocolException, IOException {

		String responseResult = JavaApi.addAddress(addressBuildingId, addressNaviId, building, city1, contact, gender,
				latitude, longitude, phone, regionId, room1, village);
		Assert.assertTrue(responseResult.contains(expectValue));
	}

	// �����ֻ������
	@Test(enabled = false, dataProvider = "phone", dataProviderClass = AddAddressPro.class, priority = 1)
	public void checkAddressPhone(String name, String phone, String expectValue)
			throws ClientProtocolException, IOException {
		String responseResult = JavaApi.addAddress("259", "18039", "�Զ�������¥������ɾ��", "����", name, "0", "22.408965",
				"113.826119", phone, "813395", "11111Aa", "����ɽ");
		Assert.assertTrue(responseResult.contains(expectValue));
	}

	@BeforeClass
	public void beforeClass() {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("AddAddress�������Կ�ʼ");
	}

	@AfterClass
	public void afterClass() throws ClientProtocolException, IOException {
		 ClearEnv.deleteAddress();
		Log.endTestCase("AddAddress�������Խ���");
	}

}
