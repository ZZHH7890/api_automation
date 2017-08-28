package com.zzkg.cases.buy;

import org.testng.annotations.Test;

import com.zzkg.japi.JavaApi;

import common.ClearEnv;
import common.InitEnv;
import common.Log;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class BuyProcess {
	//单独购买一个商品
	@Test
	public void oneGoodsInOrder() throws ClientProtocolException, IOException {
		// 购买商品：自动化测试商品1
		JavaApi.buyGoods("1", "991824", "false", "198", "false", "924116");
		// 获取登录token
		String cartToken = JavaApi.getCartToken();
		// 获取收货地址列表最新添加的地址
		String addressId = JavaApi.getFirstAddressId();
		// 执行下单接口获取订单id,订单金额
		String[] orderInfo = JavaApi.getOrderInfo(addressId, "1", cartToken, "-1", "06:00-07:30", "", "2");
		// 执行获取预支付订单接口获取预支付订单
		String prePayorderId = JavaApi.getPrepayOrderId(orderInfo[0], orderInfo[1]);
		// 执行会员宝支付接口
		String responseString = JavaApi.balancePay(prePayorderId);
		Assert.assertTrue(responseString.contains("支付成功"));
	}

	//购买两个不同的商品
	@Test
	public void twoDifferentGoodsInOrder() throws ClientProtocolException, IOException {
		// 购买商品：自动化测试商品1
		JavaApi.buyGoods("1", "991824", "false", "-1", "false", "924116");
		// 购买商品：自动化测试商品2
		JavaApi.buyGoods("1", "991858", "false", "-1", "false", "924150");
		// 获取登录token
		String cartToken = JavaApi.getCartToken();
		// 获取收货地址列表最新添加的地址
		String addressId = JavaApi.getFirstAddressId();
		// 执行下单接口获取订单id,订单金额
		String[] orderInfo = JavaApi.getOrderInfo(addressId, "1", cartToken, "-1", "06:00-07:30", "", "2");
		// 执行获取预支付订单接口获取预支付订单
		String prePayorderId = JavaApi.getPrepayOrderId(orderInfo[0], orderInfo[1]);
		// 执行会员宝支付接口
		String responseString = JavaApi.balancePay(prePayorderId);
		Assert.assertTrue(responseString.contains("支付成功"));
	}

	//单独兑换一个赠品
	@Test
	public void oneGiftInOrder() throws ClientProtocolException, IOException {
		// 兑换赠品：自动化测试赠品2
		JavaApi.exchangeGift("1", "994141", "true");
		// 获取登录token
		String cartToken = JavaApi.getCartToken();
		// 获取收货地址列表最新添加的地址
		String addressId = JavaApi.getFirstAddressId();
		// 执行下单接口获取订单id,订单金额
		String[] orderInfo = JavaApi.getOrderInfo(addressId, "1", cartToken, "-1", "06:00-07:30", "", "2");
		// 执行获取预支付订单接口获取预支付订单
		String prePayorderId = JavaApi.getPrepayOrderId(orderInfo[0], orderInfo[1]);
		// 执行会员宝支付接口
		String responseString = JavaApi.balancePay(prePayorderId);
		Assert.assertTrue(responseString.contains("支付成功"));
	}

	//兑换两个不同的赠品
	@Test
	public void twoDifferentGiftsInOrder() throws ClientProtocolException, IOException {
		// 兑换赠品：自动化测试赠品2
		JavaApi.exchangeGift("1", "994141", "true");
		JavaApi.exchangeGift("1", "994140", "true");
		// 获取登录token
		String cartToken = JavaApi.getCartToken();
		// 获取收货地址列表最新添加的地址
		String addressId = JavaApi.getFirstAddressId();
		// 执行下单接口获取订单id,订单金额
		String[] orderInfo = JavaApi.getOrderInfo(addressId, "1", cartToken, "-1", "06:00-07:30", "", "2");
		// 执行获取预支付订单接口获取预支付订单
		String prePayorderId = JavaApi.getPrepayOrderId(orderInfo[0], orderInfo[1]);
		// 执行会员宝支付接口
		String responseString = JavaApi.balancePay(prePayorderId);
		Assert.assertTrue(responseString.contains("支付成功"));
	}

	@BeforeClass
	public void beforeClass() throws ClientProtocolException, IOException {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("BuyProcess用例测试开始");
		InitEnv.addAddress();

	}

	@AfterClass
	public void afterClass() throws ClientProtocolException, IOException {
		ClearEnv.deleteAddress();
		Log.endTestCase("BuyProcess用例测试结束");
	}

}
