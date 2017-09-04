package com.zzkg.cases.addaddress;

import org.testng.annotations.Test;

import com.zzkg.common.ClearEnv;
import com.zzkg.common.Log;
import com.zzkg.datapro.AddAddressPro;
import com.zzkg.japi.JavaApi;

import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class AddAddress {

	// 测试添加收货地址
	@Test(enabled = true, dataProvider = "address", dataProviderClass = AddAddressPro.class, priority = 1)
	public void checkAddAddress(String jsonString, String expectValue) throws ClientProtocolException, IOException {
		String responseResult = JavaApi.addAddress(jsonString);
		Assert.assertTrue(responseResult.contains(expectValue));
	}

	@BeforeClass
	public void beforeClass() {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("AddAddress用例测试开始");
	}

	@AfterClass
	public void afterClass() throws ClientProtocolException, IOException {
		ClearEnv.deleteAddress();
		Log.endTestCase("AddAddress用例测试结束");
	}

}
