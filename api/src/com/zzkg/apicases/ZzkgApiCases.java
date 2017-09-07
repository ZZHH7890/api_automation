package com.zzkg.apicases;

import org.testng.annotations.Test;

import com.zzkg.common.ClearEnv;
import com.zzkg.common.InitEnv;
import com.zzkg.datapro.ApiTestDataPro;
import com.zzkg.japi.JavaApi;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ZzkgApiCases {
	// 测试添加收货地址
	@Test(enabled = false, dataProvider = "address", dataProviderClass = ApiTestDataPro.class, groups = {"P1"})
	public void checkAddAddress(String jsonString, String expectValue) throws ClientProtocolException, IOException {
		// 执行添加地址接口
		String responseResult = JavaApi.addAddress(jsonString);
		Assert.assertTrue(responseResult.contains(expectValue));
	}

	// 测试添加商品到购物车接口
	@Test(enabled = true, dataProvider = "buyProcess", dataProviderClass = ApiTestDataPro.class,groups = {"P1"})
	public void addGoodsToCart(String jsonString, String expectValue) throws ClientProtocolException, IOException {
		DOMConfigurator.configure("log4j.xml");
		// 添加商品：自动化测试商品1
		String responseResult = JavaApi.buyGoods(jsonString);
		Assert.assertTrue(responseResult.contains(expectValue));
	}

	// 测试一键购买接口
	@Test(enabled = false, dataProvider = "quickBuy", dataProviderClass = ApiTestDataPro.class, groups = {"P1"})
	public void quickBuy(String jsonArrayString, String expectValue) throws ClientProtocolException, IOException {
		// 执行一键购买接口
		JavaApi.quickBuy(jsonArrayString);
		// 检查添加到购物车中商品数量
		String respondresult = JavaApi.getCartCount();
		Assert.assertTrue(respondresult.contains(expectValue));
	}

	// 测试兑换赠品接口
	@Test(enabled = false, dataProvider = "exchangeGift", dataProviderClass = ApiTestDataPro.class, groups = {"P2"})
	public void exchangeGift(String jsonString, String expectValue) throws ClientProtocolException, IOException {
		// 执行兑换赠品接口
		String respondresult = JavaApi.exchangeGift(jsonString);
		Assert.assertTrue(respondresult.contains(expectValue));
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
		try {
			InitEnv.clearCart();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
		try {
			InitEnv.clearCart();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
		DOMConfigurator.configure("log4j.xml");
		try {
			InitEnv.clearCart();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
		try {
			ClearEnv.deleteAddress();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
