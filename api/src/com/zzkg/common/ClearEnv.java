package com.zzkg.common;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ClearEnv {
	// 清空收货地址
	public static void deleteAddress() throws ClientProtocolException, IOException {
		// 预发布环境在表格的第二行
		JSONObject jsonconfig = GetApi.configJson(Config.TEST_ENV);
		// 获取登录token
		String token = Login.getToken();
		// 获取收货地址列表接口在表格的第六行
		JSONObject jsonAddressApi = GetApi.getApiJson(6);
		try {
			// 获取收货地址列表接口返回值string类型
			String addressStr = HttpClientMethod.get(jsonconfig.getString("host"), jsonAddressApi.getString("apiurl"),
					jsonconfig.getString("region"), token);
			// 将收货地址列表接口返回值string类型转化为json数组
			JSONArray jsonAddressArrary = JSONArray.fromObject(addressStr);
			// 循环获取数组中每一个json的key(id)的值用于删除地址接口
			if (jsonAddressArrary.size() == 0) {
				Log.info("用户没有地址,不需要清空地址");
			} else {
				for (int i = 0; i < jsonAddressArrary.size(); i++) {
					Log.info("需要删除的地址个数为：" + jsonAddressArrary.size());
					JSONObject jsonObject = jsonAddressArrary.getJSONObject(i);
					String idString = jsonObject.getString("id");
					// 删除收货地址接口在表格的第五行
					JSONObject jsonDeleteAddressApi = GetApi.getApiJson(5);
					HttpClientMethod.delete(jsonconfig.getString("host"),
							jsonDeleteAddressApi.getString("apiurl") + idString, jsonconfig.getString("region"), token);
				}
			}
		} catch (Exception e) {
			String failString = "清理环境时删除地址失败！！";
			Log.info(failString);
		}

	}

	// 清空购物车
	public static void clearCart() throws IOException {
		Log.info("清空购物车");
		// 读取环境信息
		JSONObject jsonconfig = GetApi.configJson(Config.TEST_ENV);
		// 读取接口信息
		JSONObject jsonapi = GetApi.getApiJson(2);
		try {
			// 执行清空购物车请求
			String result = HttpClientMethod.delete(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
					jsonconfig.getString("region"), Login.getToken());
			Log.info("清空购物车成功!" + result);

		} catch (Exception e) {
			String failString = "增加地址清空购物车失败！";
			Log.info(failString);
		}
	}
}
