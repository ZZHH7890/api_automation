package common;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ClearEnv {
	public static void deleteAddress() throws ClientProtocolException, IOException {
		// 预发布环境在表格的第二行
		JSONObject jsonconfig = GetApi.configJson(2);
		// 获取登录token
		String token = Login.getToken();
		// 获取收货地址列表接口在表格的第六行
		JSONObject jsonAddressApi = GetApi.getApiJson(6);
		// 获取收货地址列表接口返回值string类型
		String addressStr = HttpClientMethod.get(jsonconfig.getString("host"), jsonAddressApi.getString("apiurl"),
				jsonconfig.getString("region"), token);
		// 将收货地址列表接口返回值string类型转化为json数组
		JSONArray jsonAddressArrary = JSONArray.fromObject(addressStr);
		// 循环获取数组中每一个json的key(id)的值用于删除地址接口
		if(jsonAddressArrary.size() == 0) {
			System.out.println("用户没有地址");
		}
		else {for (int i = 0; i < jsonAddressArrary.size(); i++) {
			System.out.println(jsonAddressArrary.size());
			JSONObject jsonObject = jsonAddressArrary.getJSONObject(i);
			String idString = jsonObject.getString("id");
			// 删除收货地址接口在表格的第五行
			JSONObject jsonDeleteAddressApi = GetApi.getApiJson(5);
			String deleteAddressString = HttpClientMethod.delete(jsonconfig.getString("host"),
					jsonDeleteAddressApi.getString("apiurl") + idString, jsonconfig.getString("region"), token);
			System.out.println("删除收货地址：" + deleteAddressString);}
		
	}
	}
}
