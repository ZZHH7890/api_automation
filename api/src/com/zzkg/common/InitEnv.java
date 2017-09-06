package com.zzkg.common;

import java.io.FileWriter;
import java.io.IOException;

import com.zzkg.japi.JavaApi;

import net.sf.json.JSONObject;

public class InitEnv {
	// 清空购物车
	public static void clearCart() throws IOException {
		Log.info("清空购物车");
		// 读取表格config.xlsx的第二行预发布环境信息
		JSONObject jsonconfig = GetApi.configJson(Config.TEST_ENV);
		// 读取表格api.xlsx的第二行清空购物车接口信息
		JSONObject jsonapi = GetApi.getApiJson(2);
		try {
			// 执行清空购物车请求
			String result = HttpClientMethod.delete(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
					jsonconfig.getString("region"), Login.getToken());
			Log.info("清空购物车成功!" + result);

		} catch (Exception e) {
			String failString = "增加地址失败！";
			Log.info(failString);
		}
	}

	// 增加收货地址
	public static void addAddress() {
		try {
			JavaApi.addAddress(Config.INIT_ADDRESS);
		} catch (Exception e) {
			String failString = "初始化增加地址失败！";
			Log.info(failString);
		}
	}

	// 清空日志
	public static void clearLog() {
		try {
			FileWriter fw = new FileWriter(
					"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\log\\logfile.log", false);
			fw.write("");
			fw.flush();
			fw.close();
			String successString = "清空日志成功！";
			Log.info(successString);
		} catch (Exception e) {
			String failString = "清空日志失败！";
			Log.info(failString);
		}
	}

}
