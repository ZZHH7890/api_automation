package test;

import org.testng.annotations.Test;

import common.ClearEnv;
import common.GetApi;
import common.HttpClientMethod;
import common.InitEnv;
import common.Log;
import common.Login;
import datapro.ExchangeGiftPro;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class DebugTestNG {
	@Test(enabled = true)
	public void exchangeGift() throws ClientProtocolException, IOException {
		Log.startTestCase("exchangeGift用例测试开始");
		// 读取表格config.xlsx的第二行预发布环境信息
		JSONObject jsonConfig = GetApi.configJson(2);
		// 获取登录token
		String token = Login.getToken();
		// 兑换赠品
		JSONObject jsonExchangeGiftApi = GetApi.getApiJson(3);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", "1");
		jsonParam.put("dealId", "994141");
		jsonParam.put("selected", "true");
		HttpClientMethod.putJson(jsonConfig.getString("host"), jsonExchangeGiftApi.getString("apiurl"),
				jsonConfig.getString("region"), token, jsonParam);
		// 订单确认信息获取carttoken
		JSONObject jsonOrderConfirmApi = GetApi.getApiJson(7);
		String orderConfirmString = HttpClientMethod.get(jsonConfig.getString("host"),
				jsonOrderConfirmApi.getString("apiurl"), jsonConfig.getString("region"), token);
		JSONObject orderConfirmJson = JSONObject.fromObject(orderConfirmString);
		String cartToken = orderConfirmJson.getString("cartToken");
		Log.info("用户cartToken:" + cartToken);
		System.out.println("用户cartToken：" + cartToken);
		// 执行下单接口获取订单号，支付金额
		JSONObject jsonOrderApi = GetApi.getApiJson(8);
		JSONObject jsonOrderParam = new JSONObject();
		jsonOrderParam.put("addressId", "15830");
		jsonOrderParam.put("buyWay", "1");
		jsonOrderParam.put("cartToken", cartToken);
		jsonOrderParam.put("deliverType", "-1");
		jsonOrderParam.put("delivertime", "06:00-07:30");
		jsonOrderParam.put("remark", "");
		jsonOrderParam.put("serviceReminderFlag", "2");
		String orderJsonString = HttpClientMethod.postJson(jsonConfig.getString("host"),
				jsonOrderApi.getString("apiurl"), jsonConfig.getString("region"), token, jsonOrderParam);
		JSONObject orderJson = JSONObject.fromObject(orderJsonString);
		String orderId = orderJson.getString("id");
		String payAmount = orderJson.getString("payAmount");
		System.out.println("获取订单ID：" + orderId);
		System.out.println("获取订单金额：" + payAmount);
		// 执行获取预支付订单接口
		JSONObject jsonPrepayOrderIdApi = GetApi.getApiJson(9);
		String jsonPrepayOrderIdString = HttpClientMethod.get(jsonConfig.getString("host"),
				jsonPrepayOrderIdApi.getString("apiurl") + orderId + "//" + payAmount + "//" + token,
				jsonConfig.getString("region"), token);
		System.out.println("获取预支付订单接口返回：" + jsonPrepayOrderIdString);
		JSONObject prepayOrderApiJson = JSONObject.fromObject(jsonPrepayOrderIdString);
		String data = prepayOrderApiJson.getString("data");
		System.out.println("预支付订单所在json：" + data);
		JSONObject prepayOrderJson = JSONObject.fromObject(data);
		String prepayId = prepayOrderJson.getString("prepayId");
		System.out.println("预支付订单：" + prepayId);
		// 执行会员宝支付接口
		JSONObject payApiJson = GetApi.getApiJson(10);
		JSONObject payParamJson = new JSONObject();
		payParamJson.put("expireTime", "");
		payParamJson.put("password", "111111");
		String psyResult = HttpClientMethod.postJson(jsonConfig.getString("host"),
				payApiJson.getString("apiurl") + prepayId, jsonConfig.getString("region"), token, payParamJson);
		System.out.println("会员宝支付接口返回：" + psyResult);
		Log.endTestCase("exchangeGift用例测试结束");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("测试开始！！");
		// 设置打印日志的配置信息
		DOMConfigurator.configure("log4j.xml");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("测试结束！！");
	}

}
