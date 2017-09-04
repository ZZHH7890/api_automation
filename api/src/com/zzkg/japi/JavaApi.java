package com.zzkg.japi;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import common.GetApi;
import common.HttpClientMethod;
import common.Log;
import common.Login;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JavaApi {
	// 购买商品接口
	public static String buyGoods(String dealCount, String dealId, String limitFlag, String odLabelId, String selected,
			String specId) throws IOException {
		Log.info("+++++++++++++++++开始调用购买商品接口++++++++++++++++++++++");
		// 读取表格testData.xlsx的config第二行预发布环境信息
		JSONObject jsonConfig = GetApi.configJson(2);
		// 读取表格testData.xlsx的api第三行购买商品接口信息
		JSONObject jsonapi = GetApi.getApiJson(11);
		// 设置post方法的传入Body Data
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", dealCount);
		jsonParam.put("dealId", dealId);
		jsonParam.put("limitFlag", limitFlag);
		jsonParam.put("odLabelId", odLabelId);
		jsonParam.put("selected", selected);
		jsonParam.put("specId", specId);
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
	public static String exchangeGift(String dealCount, String dealId, String selected)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用兑换赠品接口++++++++++++++++++++++");
		// 读取表格config.xlsx的第二行预发布环境信息
		JSONObject jsonConfig = GetApi.configJson(2);
		// 读取表格api.xlsx的第三行兑换赠品接口信息
		JSONObject jsonapi = GetApi.getApiJson(3);
		// 设置put方法的传入Body Data
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", dealCount);
		jsonParam.put("dealId", dealId);
		jsonParam.put("selected", selected);
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
	public static String addAddress(String addressBuildingId, String addressNaviId, String building, String city1,
			String contact, String gender, String latitude, String longitude, String phone, String regionId,
			String room1, String village) throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用增加地址接口++++++++++++++++++++++");
		// 读取表格config.xlsx的第二行预发布环境信息
		JSONObject jsonConfig = GetApi.configJson(2);
		// 读取表格api.xlsx的第四行增加收货地址接口信息
		JSONObject jsonApi = GetApi.getApiJson(4);
		// 设置post方法的传入Body Data
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("addressBuildingId", addressBuildingId);
		jsonParam.put("addressNaviId", addressNaviId);
		jsonParam.put("building", building);
		jsonParam.put("city1", "city1");
		jsonParam.put("contact", contact);
		jsonParam.put("gender", gender);
		jsonParam.put("latitude", latitude);
		jsonParam.put("longitude", longitude);
		jsonParam.put("phone", phone);
		jsonParam.put("regionId", regionId);
		jsonParam.put("room1", room1);
		jsonParam.put("village", village);
		try {
			// 执行接口请求并获取接口返回的string结果
			String responseString = HttpClientMethod.postJson(jsonConfig.getString("host"), jsonApi.getString("apiurl"),
					jsonConfig.getString("region"), Login.getToken(), jsonParam);
			Log.info("+++++++++++++++++结束调用增加地址接口++++++++++++++++++++++");
			return responseString;
		} catch (Exception e) {
			String failString = "接口执行失败，增加收货地址失败！！";
			Log.info(failString);
			return failString;
		}
	}

	// 获取最新添加的收货地址id
	public static String getFirstAddressId() throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用获取收货地址id信息接口++++++++++++++++++++++");
		// 读取表格config.xlsx的第二行预发布环境信息
		JSONObject jsonConfig = GetApi.configJson(2);
		// 读取表格api.xlsx的第七行获取订单确认接口信息
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
		// 读取表格config.xlsx的第二行预发布环境信息
		JSONObject jsonConfig = GetApi.configJson(2);
		// 读取表格api.xlsx的第七行获取订单确认接口信息
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
	public static String[] getOrderInfo(String addressId, String buyWay, String cartToken, String deliverType,
			String delivertime, String remark, String serviceReminderFlag) throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用下单接口++++++++++++++++++++++");
		// 读取表格config.xlsx的第二行预发布环境信息
		JSONObject jsonConfig = GetApi.configJson(2);
		// 读取表格api.xlsx的第八行下单接口信息
		JSONObject jsonApi = GetApi.getApiJson(8);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("addressId", addressId);
		jsonParam.put("buyWay", buyWay);
		jsonParam.put("cartToken", cartToken);
		jsonParam.put("deliverType", deliverType);
		jsonParam.put("delivertime", delivertime);
		jsonParam.put("remark", remark);
		jsonParam.put("serviceReminderFlag", serviceReminderFlag);
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
		// 读取表格config.xlsx的第二行预发布环境信息
		JSONObject jsonConfig = GetApi.configJson(2);
		// 读取表格api.xlsx的第九行获取预支付订单接口信息
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
	public static String balancePay(String prepayOrderId) throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++开始调用会员宝支付接口++++++++++++++++++++++");
		String token = Login.getToken();
		// 读取表格config.xlsx的第2行预发布环境信息
		JSONObject jsonConfig = GetApi.configJson(2);
		// 读取表格api.xlsx的第10行会员宝支付接口信息
		JSONObject jsonApi = GetApi.getApiJson(10);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("expireTime", "");
		jsonParam.put("password", "111111");
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
		// 读取表格testData.xlsx的config第三行21环境信息
		JSONObject jsonConfig = GetApi.configJson(3);
		// 读取表格testData.xlsx的api第12行菜谱一键购买接口信息
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
