package com.zzkg.cases.addaddress;

import org.testng.annotations.Test;

import common.ClearEnv;
import common.GetApi;
import common.HttpClientMethod;
import common.Log;
import common.Login;
import datapro.CheckAddressPhonePro;
import net.sf.json.JSONObject;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class CheckAddressPhone {
	@Test(enabled = true, dataProvider = "phone", dataProviderClass = CheckAddressPhonePro.class, priority = 1)
	public void addAddress(String name, String phone, String re) throws ClientProtocolException, IOException {
		Log.startTestCase("CheckAddressPhone用例测试开始");
		// 读取表格config.xlsx的第二行预发布环境信息
		JSONObject jsonconfig = GetApi.configJson(2);
		// 读取表格api.xlsx的第四行增加收货地址接口信息
		JSONObject jsonapi = GetApi.getApiJson(4);
		//设置post方法的传入Body Data
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("addressBuildingId", "350");
		jsonParam.put("addressNaviId", "18039");
		jsonParam.put("building", "自动化测试楼栋（勿删）");
		jsonParam.put("city1", "深圳");
		jsonParam.put("contact", name);
		jsonParam.put("gender", "0");
		jsonParam.put("latitude", "22.408965");
		jsonParam.put("longitude", "113.826119");
		jsonParam.put("phone", phone);
		jsonParam.put("regionId", "813395");
		jsonParam.put("room1", "11111A");
		jsonParam.put("village", "东角山");
		//执行接口请求并获取接口返回的string结果
		String respondresult = HttpClientMethod.postJson(jsonconfig.getString("host"), jsonapi.getString("apiurl"),
				jsonconfig.getString("region"), Login.getToken(), jsonParam);
		Assert.assertTrue(respondresult.contains(re));
		Log.endTestCase("CheckAddressPhone用例测试结束");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("测试开始！！");
		//设置打印日志的配置信息
		DOMConfigurator.configure("log4j.xml");
	}

	@AfterClass
	public void afterClass() throws ClientProtocolException, IOException {
		ClearEnv.deleteAddress();
		System.out.println("测试结束！！");
	}

}
