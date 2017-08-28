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
	// ������Ʒ�ӿ�
	public static String buyGoods(String dealCount, String dealId, String limitFlag, String odLabelId, String selected,
			String specId) throws IOException {
		Log.info("+++++++++++++++++��ʼ���ù�����Ʒ�ӿ�++++++++++++++++++++++");
		// ��ȡ���config.xlsx�ĵڶ���Ԥ����������Ϣ
		JSONObject jsonConfig = GetApi.configJson(2);
		// ��ȡ���api.xlsx�ĵ����й�����Ʒ�ӿ���Ϣ
		JSONObject jsonapi = GetApi.getApiJson(11);
		// ����post�����Ĵ���Body Data
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", dealCount);
		jsonParam.put("dealId", dealId);
		jsonParam.put("limitFlag", limitFlag);
		jsonParam.put("odLabelId", odLabelId);
		jsonParam.put("selected", selected);
		jsonParam.put("specId", specId);
		try {
			// ִ�нӿ����󲢻�ȡ�ӿڷ��ص�string���
			String responseString = HttpClientMethod.postJson(jsonConfig.getString("host"), jsonapi.getString("apiurl"),
					jsonConfig.getString("region"), Login.getToken(), jsonParam);
			Log.info("+++++++++++++++++�������ù�����Ʒ�ӿ�++++++++++++++++++++++");
			return responseString;
		} catch (Exception e) {
			String failString = "������Ʒ�ӿ�ִ��ʧ�ܣ���";
			Log.info(failString);
			return failString;
		}

	}

	// �һ���Ʒ�ӿ�
	public static String exchangeGift(String dealCount, String dealId, String selected)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ���öһ���Ʒ�ӿ�++++++++++++++++++++++");
		// ��ȡ���config.xlsx�ĵڶ���Ԥ����������Ϣ
		JSONObject jsonConfig = GetApi.configJson(2);
		// ��ȡ���api.xlsx�ĵ����жһ���Ʒ�ӿ���Ϣ
		JSONObject jsonapi = GetApi.getApiJson(3);
		// ����put�����Ĵ���Body Data
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("dealCount", dealCount);
		jsonParam.put("dealId", dealId);
		jsonParam.put("selected", selected);
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
	public static String addAddress(String addressBuildingId, String addressNaviId, String building, String city1,
			String contact, String gender, String latitude, String longitude, String phone, String regionId,
			String room1, String village) throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ�������ӵ�ַ�ӿ�++++++++++++++++++++++");
		// ��ȡ���config.xlsx�ĵڶ���Ԥ����������Ϣ
		JSONObject jsonConfig = GetApi.configJson(2);
		// ��ȡ���api.xlsx�ĵ����������ջ���ַ�ӿ���Ϣ
		JSONObject jsonApi = GetApi.getApiJson(4);
		// ����post�����Ĵ���Body Data
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
			// ִ�нӿ����󲢻�ȡ�ӿڷ��ص�string���
			String responseString = HttpClientMethod.postJson(jsonConfig.getString("host"), jsonApi.getString("apiurl"),
					jsonConfig.getString("region"), Login.getToken(), jsonParam);
			Log.info("+++++++++++++++++�����������ӵ�ַ�ӿ�++++++++++++++++++++++");
			return responseString;
		} catch (Exception e) {
			String failString = "�����ջ���ַ�ӿ�ִ��ʧ�ܣ���";
			Log.info(failString);
			return failString;
		}
	}

	// ��ȡ������ӵ��ջ���ַid
	public static String getFirstAddressId() throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ���û�ȡ�ջ���ַid��Ϣ�ӿ�++++++++++++++++++++++");
		// ��ȡ���config.xlsx�ĵڶ���Ԥ����������Ϣ
		JSONObject jsonConfig = GetApi.configJson(2);
		// ��ȡ���api.xlsx�ĵ����л�ȡ����ȷ�Ͻӿ���Ϣ
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
			String failString = "��ȡ�ջ���ַid��Ϣʧ�ܣ���";
			Log.info(failString);
			return failString;
		}

	}

	// ����ȷ����Ϣ��ȡcarttoken
	public static String getCartToken() throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ���ö���ȷ����Ϣ�ӿ�++++++++++++++++++++++");
		// ��ȡ���config.xlsx�ĵڶ���Ԥ����������Ϣ
		JSONObject jsonConfig = GetApi.configJson(2);
		// ��ȡ���api.xlsx�ĵ����л�ȡ����ȷ�Ͻӿ���Ϣ
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
			String failString = "���ö���ȷ����Ϣ�ӿ�ʧ�ܣ���ȡcartTokenʧ�ܣ���";
			Log.info(failString);
			return failString;
		}

	}

	// ִ���µ��ӿڻ�ȡ�����ţ�֧�����
	public static String[] getOrderInfo(String addressId, String buyWay, String cartToken, String deliverType,
			String delivertime, String remark, String serviceReminderFlag) throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ�����µ��ӿ�++++++++++++++++++++++");
		// ��ȡ���config.xlsx�ĵڶ���Ԥ����������Ϣ
		JSONObject jsonConfig = GetApi.configJson(2);
		// ��ȡ���api.xlsx�ĵڰ����µ��ӿ���Ϣ
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
		// ��ȡ���config.xlsx�ĵڶ���Ԥ����������Ϣ
		JSONObject jsonConfig = GetApi.configJson(2);
		// ��ȡ���api.xlsx�ĵھ��л�ȡԤ֧�������ӿ���Ϣ
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
			String failString = "���û�ȡԤ֧�������ӿ�ʧ�ܣ���ȡprepayOrderIdʧ�ܣ���";
			Log.info(failString);
			return failString;
		}

	}

	// ִ�л�Ա��֧���ӿ�
	public static String balancePay(String prepayOrderId) throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ���û�Ա��֧���ӿ�++++++++++++++++++++++");
		String token = Login.getToken();
		// ��ȡ���config.xlsx�ĵ�2��Ԥ����������Ϣ
		JSONObject jsonConfig = GetApi.configJson(2);
		// ��ȡ���api.xlsx�ĵ�10�л�Ա��֧���ӿ���Ϣ
		JSONObject jsonApi = GetApi.getApiJson(10);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("expireTime", "");
		jsonParam.put("password", "111111");
		try {
			String responseString = HttpClientMethod.postJson(jsonConfig.getString("host"),
					jsonApi.getString("apiurl") + prepayOrderId, jsonConfig.getString("region"), token, jsonParam);
			Log.info("+++++++++++++++++�������û�Ա��֧���ӿ�++++++++++++++++++++++");
			return responseString;
		} catch (Exception e) {
			String failString = "���û�Ա��֧���ӿ�ʧ�ܣ�֧��ʧ�ܣ���";
			Log.info(failString);
			return failString;
		}
	}

}
