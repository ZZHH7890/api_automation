package test;

import org.testng.annotations.Test;

import common.DeleteMethod;
import common.GetMethod;
import common.Log;
import common.Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	@Test
	public void newTest() throws ClientProtocolException, IOException {
		Log.startTestCase("NewTest用例测试开始");
		String host = "http://release.thy360.com";
		String path = "/ja/user/v3/od/clear/cart";
		String region = "813395";
		String phone = "13714672775";
		String code = "1234";
		String introducerCode = "";
		String token = Login.getToken(phone, code, introducerCode);
		String resultStr = DeleteMethod.runDeleteApi(host, path, region, token);
		Assert.assertTrue(resultStr.contains("\"statusCode\":0"));
		Log.endTestCase("NewTest用例测试结束");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("测试开始");
		DOMConfigurator.configure("log4j.xml");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("测试结束");
	}

}
