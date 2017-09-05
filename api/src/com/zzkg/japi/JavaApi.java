package com.zzkg.japi;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.zzkg.common.Config;
import com.zzkg.common.GetApi;
import com.zzkg.common.HttpClientMethod;
import com.zzkg.common.Log;
import com.zzkg.common.Login;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JavaApi {
	// 购买商品接口
	public static String buyGoods(String jsonString) throws IOException {
		Log.info("+++++++++++++++++开始调用购买商品接口++++++++++++++++++++++");
		// 读取环境信息
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// 读取接口信息
		JSONObject jsonapi = GetApi.getApiJson(11);
		// 设置post方法的传入Body Data
		JSONObject jsonParam = JSONObject.fromObject(jsonString);
		try {
			// 执行接口请求并获取接口返回的string结果
			String responseString = HttpClientMethod.postJson(jsonConfig.getString("host"), jsonapi.getString("apiurl"),
					jsonConfig.getString("region"), Login.getToken(), jsonParam);
			Log.info("+++++++++++++++++结束调用购买商品接口++++++++++++++++++++++");
			return responseString;
		} catch (Exception e) {
			String failString = "接口执行失败，添加商品失败！！";
			Log.info(failString);
			return failString;
		}
	}

	// 兑换赠品接口
	public static String exchangeGift(String jsonString) throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用兑换赠品接口++++++++++++++++++++++");
		// 读取环境信息
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// 读取接口信息
		JSONObject jsonapi = GetApi.getApiJson(3);
		// 设置put方法的传入Body Data
		JSONObject jsonParam = JSONObject.fromObject(jsonString);
		try {
			// 执行接口请求并获取接口返回的string结果
			String responseString = HttpClientMethod.putJson(jsonConfig.getString("host"), jsonapi.getString("apiurl"),
					jsonConfig.getString("region"), Login.getToken(), jsonParam);
			Log.info("+++++++++++++++++结束调用兑换赠品接口++++++++++++++++++++++");
			return responseString;
		} catch (Exception e) {
			String failString = "兑换赠品接口执行失败！！";
			Log.info(failString);
			return failString;
		}
	}

	// 增加收货地址接口
	public static String addAddress(String jsonString) throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用增加地址接口++++++++++++++++++++++");
		// 读取环境信息
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// 读取接口信息
		JSONObject jsonapi = GetApi.getApiJson(4);
		// 设置post方法的传入Body Data
		JSONObject jsonParam = JSONObject.fromObject(jsonString);
		try {
			// 执行接口请求并获取接口返回的string结果
			String responseString = HttpClientMethod.postJson(jsonConfig.getString("host"), jsonapi.getString("apiurl"),
					jsonConfig.getString("region"), Login.getToken(), jsonParam);
			Log.info("+++++++++++++++++结束调用增加地址接口++++++++++++++++++++++");
			return responseString;
		} catch (Exception e) {
			String failString = "接口执行失败，增加地址失败！！";
			Log.info(failString);
			return failString;
		}
	}

	// 获取最新添加的收货地址id
	public static String getFirstAddressId() throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用获取收货地址id信息接口++++++++++++++++++++++");
		// 读取环境信息
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// 读取接口信息
		JSONObject jsonApi = GetApi.getApiJson(6);
		try {
			// 获取收货地址列表接口返回值string类型
			String responseString = HttpClientMethod.get(jsonConfig.getString("host"), jsonApi.getString("apiurl"),
					jsonConfig.getString("region"), Login.getToken());
			// 将收货地址列表接口返回值string类型转化为json数组
			JSONArray jsonAddressArrary = JSONArray.fromObject(responseString);
			JSONObject jsonObject = jsonAddressArrary.getJSONObject(0);
			String addressId = jsonObject.getString("id");
			Log.info("+++++++++++++++++结束调用获取收货地址id信息接口++++++++++++++++++++++");
			return addressId;
		} catch (Exception e) {
			String failString = "接口执行失败，获取收货地址id信息失败！！";
			Log.info(failString);
			return failString;
		}

	}

	// 订单确认信息获取carttoken
	public static String getCartToken() throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用订单确认信息接口++++++++++++++++++++++");
		// 读取环境信息
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// 读取接口信息
		JSONObject jsonApi = GetApi.getApiJson(7);
		try {
			String responseString = HttpClientMethod.get(jsonConfig.getString("host"), jsonApi.getString("apiurl"),
					jsonConfig.getString("region"), Login.getToken());
			JSONObject orderConfirmJson = JSONObject.fromObject(responseString);
			String cartToken = orderConfirmJson.getString("cartToken");
			Log.info("订单cartToken: " + cartToken);
			Log.info("+++++++++++++++++结束调用订单确认信息接口++++++++++++++++++++++");
			return cartToken;
		} catch (Exception e) {
			String failString = "接口执行失败，获取cartToken失败！！";
			Log.info(failString);
			return failString;
		}

	}

	// 执行下单接口获取订单号，支付金额
	public static String[] getOrderInfo(String jsonString) throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用下单接口++++++++++++++++++++++");
		// 读取环境信息
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// 读取接口信息
		JSONObject jsonApi = GetApi.getApiJson(8);
		JSONObject jsonParam = JSONObject.fromObject(jsonString);
		try {
			String responseString = HttpClientMethod.postJson(jsonConfig.getString("host"), jsonApi.getString("apiurl"),
					jsonConfig.getString("region"), Login.getToken(), jsonParam);
			JSONObject orderJson = JSONObject.fromObject(responseString);
			String[] orderInfo = new String[2];
			orderInfo[0] = orderJson.getString("id");
			orderInfo[1] = orderJson.getString("payAmount");
			Log.info("订单id: " + orderInfo[0]);
			Log.info("订单订单金额payAmount: " + orderInfo[0]);
			Log.info("+++++++++++++++++结束调用下单接口++++++++++++++++++++++");
			return orderInfo;

		} catch (Exception e) {
			String[] orderInfo = new String[2];
			orderInfo[0] = "接口执行失败，无法获取订单id";
			orderInfo[1] = "接口执行失败，无法获取订单金额payAmount";
			Log.info(orderInfo[0]);
			Log.info(orderInfo[1]);
			return orderInfo;
		}
	}

	// 执行获取预支付订单接口
	public static String getPrepayOrderId(String orderId, String payAmount)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用获取预支付订单接口++++++++++++++++++++++");
		String token = Login.getToken();
		// 读取环境信息
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// 读取接口信息
		JSONObject jsonApi = GetApi.getApiJson(9);
		try {
			String responseString = HttpClientMethod.get(jsonConfig.getString("host"),
					jsonApi.getString("apiurl") + orderId + "//" + payAmount + "//" + token,
					jsonConfig.getString("region"), token);
			JSONObject prepayOrderApiJson = JSONObject.fromObject(responseString);
			String data = prepayOrderApiJson.getString("data");
			JSONObject prepayOrderJson = JSONObject.fromObject(data);
			String prepayOrderId = prepayOrderJson.getString("prepayId");
			Log.info("预支付订单prepayOrderId: " + prepayOrderId);
			Log.info("+++++++++++++++++结束调用获取预支付订单接口++++++++++++++++++++++");
			return prepayOrderId;
		} catch (Exception e) {
			String failString = "接口执行失败，获取prepayOrderId失败！！";
			Log.info(failString);
			return failString;
		}
	}

	// 执行会员宝支付接口
	public static String balancePay(String prepayOrderId, String jsonString)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用会员宝支付接口++++++++++++++++++++++");
		String token = Login.getToken();
		// 读取环境信息
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// 读取接口信息
		JSONObject jsonApi = GetApi.getApiJson(10);
		JSONObject jsonParam = JSONObject.fromObject(jsonString);
		try {
			String responseString = HttpClientMethod.postJson(jsonConfig.getString("host"),
					jsonApi.getString("apiurl") + prepayOrderId, jsonConfig.getString("region"), token, jsonParam);
			Log.info("+++++++++++++++++结束调用会员宝支付接口++++++++++++++++++++++");
			return responseString;
		} catch (Exception e) {
			String failString = "接口执行失败，支付失败！！";
			Log.info(failString);
			return failString;
		}
	}

	// 执行菜谱一键购买接口
	public static String quickBuy(String jsonArrayString) throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用菜谱一键购买接口++++++++++++++++++++++");
		String token = Login.getToken();
		// 读取环境信息
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// 读取接口信息
		JSONObject jsonApi = GetApi.getApiJson(12);
		JSONArray jsonArray = JSONArray.fromObject(jsonArrayString);
		try {
			String responseString = HttpClientMethod.postJsonArray(jsonConfig.getString("host"),
					jsonApi.getString("apiurl"), jsonConfig.getString("region"), token, jsonArray);
			Log.info("+++++++++++++++++结束调用菜谱一键购买接口++++++++++++++++++++++");
			return responseString;
		} catch (Exception e) {
			String failString = "接口执行失败，菜谱一键购买失败！！";
			Log.info(failString);
			return failString;
		}
	}
}
