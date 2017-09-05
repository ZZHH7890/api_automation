package test;

import org.testng.annotations.Test;

import com.zzkg.datapro.AddAddressPro;
import com.zzkg.japi.JavaApi;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class S {
	@Test(enabled = true, dataProvider = "address", dataProviderClass = AddAddressPro.class, priority = 1)
	public void checkAddAddress(String jsonString, String expectValue) throws ClientProtocolException, IOException {
		// 执行添加地址接口
		String responseResult = JavaApi.addAddress(jsonString);
		Assert.assertTrue(responseResult.contains(expectValue));
	}
  @BeforeClass
  public void beforeClass() {
	  System.out.println("START");
	  DOMConfigurator.configure("log4j.xml");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("END");
  }

}
