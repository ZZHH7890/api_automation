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
	// ������Ʒ�ӿ�
	public static String buyGoods(String jsonString) throws IOException {
		Log.info("+++++++++++++++++��ʼ���ù�����Ʒ�ӿ�++++++++++++++++++++++");
		// ��ȡ������Ϣ
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// ��ȡ�ӿ���Ϣ
		JSONObject jsonapi = GetApi.getApiJson(11);
		// ����post�����Ĵ���Body Data
		JSONObject jsonParam = JSONObject.fromObject(jsonString);
		try {
			// ִ�нӿ����󲢻�ȡ�ӿڷ��ص�string���
			String responseString = HttpClientMethod.postJson(jsonConfig.getString("host"), jsonapi.getString("apiurl"),
					jsonConfig.getString("region"), Login.getToken(), jsonParam);
			Log.info("+++++++++++++++++�������ù�����Ʒ�ӿ�++++++++++++++++++++++");
			return responseString;
		} catch (Exception e) {
			String failString = "�ӿ�ִ��ʧ�ܣ������Ʒʧ�ܣ���";
			Log.info(failString);
			return failString;
		}
	}

	// �һ���Ʒ�ӿ�
	public static String exchangeGift(String jsonString) throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ���öһ���Ʒ�ӿ�++++++++++++++++++++++");
		// ��ȡ������Ϣ
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// ��ȡ�ӿ���Ϣ
		JSONObject jsonapi = GetApi.getApiJson(3);
		// ����put�����Ĵ���Body Data
		JSONObject jsonParam = JSONObject.fromObject(jsonString);
		try {
			// ִ�нӿ����󲢻�ȡ�ӿڷ��ص�string���
			String responseString = HttpClientMethod.putJson(jsonConfig.getString("host"), jsonapi.getString("apiurl"),
					jsonConfig.getString("region"), Login.getToken(), jsonParam);
			Log.info("+++++++++++++++++�������öһ���Ʒ�ӿ�++++++++++++++++++++++");
			return responseString;
		} catch (Exception e) {
			String failString = "�һ���Ʒ�ӿ�ִ��ʧ�ܣ���";
			Log.info(failString);
			return failString;
		}
	}

	// �����ջ���ַ�ӿ�
	public static String addAddress(String jsonString) throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ�������ӵ�ַ�ӿ�++++++++++++++++++++++");
		// ��ȡ������Ϣ
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// ��ȡ�ӿ���Ϣ
		JSONObject jsonapi = GetApi.getApiJson(4);
		// ����post�����Ĵ���Body Data
		JSONObject jsonParam = JSONObject.fromObject(jsonString);
		try {
			// ִ�нӿ����󲢻�ȡ�ӿڷ��ص�string���
			String responseString = HttpClientMethod.postJson(jsonConfig.getString("host"), jsonapi.getString("apiurl"),
					jsonConfig.getString("region"), Login.getToken(), jsonParam);
			Log.info("+++++++++++++++++�����������ӵ�ַ�ӿ�++++++++++++++++++++++");
			return responseString;
		} catch (Exception e) {
			String failString = "�ӿ�ִ��ʧ�ܣ����ӵ�ַʧ�ܣ���";
			Log.info(failString);
			return failString;
		}
	}

	// ��ȡ������ӵ��ջ���ַid
	public static String getFirstAddressId() throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ���û�ȡ�ջ���ַid��Ϣ�ӿ�++++++++++++++++++++++");
		// ��ȡ������Ϣ
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// ��ȡ�ӿ���Ϣ
		JSONObject jsonApi = GetApi.getApiJson(6);
		try {
			// ��ȡ�ջ���ַ�б�ӿڷ���ֵstring����
			String responseString = HttpClientMethod.get(jsonConfig.getString("host"), jsonApi.getString("apiurl"),
					jsonConfig.getString("region"), Login.getToken());
			// ���ջ���ַ�б�ӿڷ���ֵstring����ת��Ϊjson����
			JSONArray jsonAddressArrary = JSONArray.fromObject(responseString);
			JSONObject jsonObject = jsonAddressArrary.getJSONObject(0);
			String addressId = jsonObject.getString("id");
			Log.info("+++++++++++++++++�������û�ȡ�ջ���ַid��Ϣ�ӿ�++++++++++++++++++++++");
			return addressId;
		} catch (Exception e) {
			String failString = "�ӿ�ִ��ʧ�ܣ���ȡ�ջ���ַid��Ϣʧ�ܣ���";
			Log.info(failString);
			return failString;
		}

	}

	// ����ȷ����Ϣ��ȡcarttoken
	public static String getCartToken() throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ���ö���ȷ����Ϣ�ӿ�++++++++++++++++++++++");
		// ��ȡ������Ϣ
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// ��ȡ�ӿ���Ϣ
		JSONObject jsonApi = GetApi.getApiJson(7);
		try {
			String responseString = HttpClientMethod.get(jsonConfig.getString("host"), jsonApi.getString("apiurl"),
					jsonConfig.getString("region"), Login.getToken());
			JSONObject orderConfirmJson = JSONObject.fromObject(responseString);
			String cartToken = orderConfirmJson.getString("cartToken");
			Log.info("����cartToken: " + cartToken);
			Log.info("+++++++++++++++++�������ö���ȷ����Ϣ�ӿ�++++++++++++++++++++++");
			return cartToken;
		} catch (Exception e) {
			String failString = "�ӿ�ִ��ʧ�ܣ���ȡcartTokenʧ�ܣ���";
			Log.info(failString);
			return failString;
		}

	}

	// ִ���µ��ӿڻ�ȡ�����ţ�֧�����
	public static String[] getOrderInfo(String jsonString) throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ�����µ��ӿ�++++++++++++++++++++++");
		// ��ȡ������Ϣ
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// ��ȡ�ӿ���Ϣ
		JSONObject jsonApi = GetApi.getApiJson(8);
		JSONObject jsonParam = JSONObject.fromObject(jsonString);
		try {
			String responseString = HttpClientMethod.postJson(jsonConfig.getString("host"), jsonApi.getString("apiurl"),
					jsonConfig.getString("region"), Login.getToken(), jsonParam);
			JSONObject orderJson = JSONObject.fromObject(responseString);
			String[] orderInfo = new String[2];
			orderInfo[0] = orderJson.getString("id");
			orderInfo[1] = orderJson.getString("payAmount");
			Log.info("����id: " + orderInfo[0]);
			Log.info("�����������payAmount: " + orderInfo[0]);
			Log.info("+++++++++++++++++���������µ��ӿ�++++++++++++++++++++++");
			return orderInfo;

		} catch (Exception e) {
			String[] orderInfo = new String[2];
			orderInfo[0] = "�ӿ�ִ��ʧ�ܣ��޷���ȡ����id";
			orderInfo[1] = "�ӿ�ִ��ʧ�ܣ��޷���ȡ�������payAmount";
			Log.info(orderInfo[0]);
			Log.info(orderInfo[1]);
			return orderInfo;
		}
	}

	// ִ�л�ȡԤ֧�������ӿ�
	public static String getPrepayOrderId(String orderId, String payAmount)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ���û�ȡԤ֧�������ӿ�++++++++++++++++++++++");
		String token = Login.getToken();
		// ��ȡ������Ϣ
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// ��ȡ�ӿ���Ϣ
		JSONObject jsonApi = GetApi.getApiJson(9);
		try {
			String responseString = HttpClientMethod.get(jsonConfig.getString("host"),
					jsonApi.getString("apiurl") + orderId + "//" + payAmount + "//" + token,
					jsonConfig.getString("region"), token);
			JSONObject prepayOrderApiJson = JSONObject.fromObject(responseString);
			String data = prepayOrderApiJson.getString("data");
			JSONObject prepayOrderJson = JSONObject.fromObject(data);
			String prepayOrderId = prepayOrderJson.getString("prepayId");
			Log.info("Ԥ֧������prepayOrderId: " + prepayOrderId);
			Log.info("+++++++++++++++++�������û�ȡԤ֧�������ӿ�++++++++++++++++++++++");
			return prepayOrderId;
		} catch (Exception e) {
			String failString = "�ӿ�ִ��ʧ�ܣ���ȡprepayOrderIdʧ�ܣ���";
			Log.info(failString);
			return failString;
		}
	}

	// ִ�л�Ա��֧���ӿ�
	public static String balancePay(String prepayOrderId, String jsonString)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ���û�Ա��֧���ӿ�++++++++++++++++++++++");
		String token = Login.getToken();
		// ��ȡ������Ϣ
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// ��ȡ�ӿ���Ϣ
		JSONObject jsonApi = GetApi.getApiJson(10);
		JSONObject jsonParam = JSONObject.fromObject(jsonString);
		try {
			String responseString = HttpClientMethod.postJson(jsonConfig.getString("host"),
					jsonApi.getString("apiurl") + prepayOrderId, jsonConfig.getString("region"), token, jsonParam);
			Log.info("+++++++++++++++++�������û�Ա��֧���ӿ�++++++++++++++++++++++");
			return responseString;
		} catch (Exception e) {
			String failString = "�ӿ�ִ��ʧ�ܣ�֧��ʧ�ܣ���";
			Log.info(failString);
			return failString;
		}
	}

	// ִ�в���һ������ӿ�
	public static String quickBuy(String jsonArrayString) throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ���ò���һ������ӿ�++++++++++++++++++++++");
		String token = Login.getToken();
		// ��ȡ������Ϣ
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// ��ȡ�ӿ���Ϣ
		JSONObject jsonApi = GetApi.getApiJson(12);
		JSONArray jsonArray = JSONArray.fromObject(jsonArrayString);
		try {
			String responseString = HttpClientMethod.postJsonArray(jsonConfig.getString("host"),
					jsonApi.getString("apiurl"), jsonConfig.getString("region"), token, jsonArray);
			Log.info("+++++++++++++++++�������ò���һ������ӿ�++++++++++++++++++++++");
			return responseString;
		} catch (Exception e) {
			String failString = "�ӿ�ִ��ʧ�ܣ�����һ������ʧ�ܣ���";
			Log.info(failString);
			return failString;
		}
	}

	// ��ȡ���ﳵ��Ʒ����
	public static String getCartCount() throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ���û�ȡ���ﳵ��Ʒ�����ӿ�++++++++++++++++++++++");
		// ��ȡ������Ϣ
		JSONObject jsonConfig = GetApi.configJson(Config.TEST_ENV);
		// ��ȡ�ӿ���Ϣ
		JSONObject jsonApi = GetApi.getApiJson(13);
		try {
			String responseString = HttpClientMethod.get(jsonConfig.getString("host"), jsonApi.getString("apiurl"),
					jsonConfig.getString("region"), Login.getToken());
			Log.info("+++++++++++++++++�������û�ȡ���ﳵ��Ʒ�����ӿ�++++++++++++++++++++++");
			return responseString;
		} catch (Exception e) {
			String failString = "�ӿ�ִ��ʧ�ܣ���ȡ���ﳵ����Ʒ����dataʧ�ܣ���";
			Log.info(failString);
			return failString;
		}

	}

}
