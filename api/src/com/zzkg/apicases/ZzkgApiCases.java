package com.zzkg.apicases;

import org.testng.annotations.Test;

import com.zzkg.common.ClearEnv;
import com.zzkg.common.InitEnv;
import com.zzkg.datapro.ApiTestDataPro;
import com.zzkg.japi.JavaApi;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ZzkgApiCases {
	// ��������ջ���ַ
	@Test(enabled = true, dataProvider = "address", dataProviderClass = ApiTestDataPro.class, groups = { "P2" })
	public void checkAddAddress(String jsonString, String expectValue) throws ClientProtocolException, IOException {
		// ִ����ӵ�ַ�ӿ�
		String responseResult = JavaApi.addAddress(jsonString);
		Assert.assertTrue(responseResult.contains(expectValue));
	}

	// ���������Ʒ�����ﳵ�ӿ�
	@Test(enabled = true, dataProvider = "buyProcess", dataProviderClass = ApiTestDataPro.class, groups = { "P1" })
	public void addGoodsToCart(String jsonString, String expectValue) throws ClientProtocolException, IOException {
		// �����Ʒ���Զ���������Ʒ1
		String responseResult = JavaApi.buyGoods(jsonString);
		Assert.assertTrue(responseResult.contains(expectValue));
	}

	// ����һ������ӿ�
	@Test(enabled = true, dataProvider = "quickBuy", dataProviderClass = ApiTestDataPro.class, groups = { "P2" })
	public void quickBuy(String jsonArrayString, String expectValue) throws ClientProtocolException, IOException {
		// ִ��һ������ӿ�
		JavaApi.quickBuy(jsonArrayString);
		// �����ӵ����ﳵ����Ʒ����
		String respondresult = JavaApi.getCartCount();
		Assert.assertTrue(respondresult.contains(expectValue));
	}

	// ���Զһ���Ʒ�ӿ�
	@Test(enabled = true, dataProvider = "exchangeGift", dataProviderClass = ApiTestDataPro.class, groups = { "P2" })
	public void exchangeGift(String jsonString, String expectValue) throws ClientProtocolException, IOException {
		// ִ�жһ���Ʒ�ӿ�
		String respondresult = JavaApi.exchangeGift(jsonString);
		Assert.assertTrue(respondresult.contains(expectValue));
	}

	@BeforeMethod(groups = { "init.env" })
	public void beforeMethod() {
		try {
			InitEnv.clearCart();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod(groups = { "clear.env" })
	public void afterMethod() {
		try {
			ClearEnv.clearCart();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeClass(groups = { "init.env" })
	public void beforeClass() {
		DOMConfigurator.configure("log4j.xml");
		try {
			InitEnv.clearCart();
			InitEnv.clearLog();
			InitEnv.addAddress();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass(groups = { "clear.env" })
	public void afterClass() {
		try {
			ClearEnv.deleteAddress();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
