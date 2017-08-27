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

	//��������һ����Ʒ
	@Test
	public void oneGoodsInOrder() throws ClientProtocolException, IOException {
		// ������Ʒ���Զ���������Ʒ1
		JavaApi.buyGoods("1", "991824", "false", "198", "false", "924116");
		// ��ȡ��¼token
		String cartToken = JavaApi.getCartToken();
		// ��ȡ�ջ���ַ�б�������ӵĵ�ַ
		String addressId = JavaApi.getFirstAddressId();
		// ִ���µ��ӿڻ�ȡ����id,�������
		String[] orderInfo = JavaApi.getOrderInfo(addressId, "1", cartToken, "-1", "06:00-07:30", "", "2");
		// ִ�л�ȡԤ֧�������ӿڻ�ȡԤ֧������
		String prePayorderId = JavaApi.getPrepayOrderId(orderInfo[0], orderInfo[1]);
		// ִ�л�Ա��֧���ӿ�
		String responseString = JavaApi.balancePay(prePayorderId);
		Assert.assertTrue(responseString.contains("֧���ɹ�"));
	}

	//����������ͬ����Ʒ
	@Test
	public void twoDifferentGoodsInOrder() throws ClientProtocolException, IOException {
		// ������Ʒ���Զ���������Ʒ1
		JavaApi.buyGoods("1", "991824", "false", "-1", "false", "924116");
		// ������Ʒ���Զ���������Ʒ2
		JavaApi.buyGoods("1", "991858", "false", "-1", "false", "924150");
		// ��ȡ��¼token
		String cartToken = JavaApi.getCartToken();
		// ��ȡ�ջ���ַ�б�������ӵĵ�ַ
		String addressId = JavaApi.getFirstAddressId();
		// ִ���µ��ӿڻ�ȡ����id,�������
		String[] orderInfo = JavaApi.getOrderInfo(addressId, "1", cartToken, "-1", "06:00-07:30", "", "2");
		// ִ�л�ȡԤ֧�������ӿڻ�ȡԤ֧������
		String prePayorderId = JavaApi.getPrepayOrderId(orderInfo[0], orderInfo[1]);
		// ִ�л�Ա��֧���ӿ�
		String responseString = JavaApi.balancePay(prePayorderId);
		Assert.assertTrue(responseString.contains("֧���ɹ�"));
	}

	//�����һ�һ����Ʒ
	@Test
	public void oneGiftInOrder() throws ClientProtocolException, IOException {
		// �һ���Ʒ���Զ���������Ʒ2
		JavaApi.exchangeGift("1", "994141", "true");
		// ��ȡ��¼token
		String cartToken = JavaApi.getCartToken();
		// ��ȡ�ջ���ַ�б�������ӵĵ�ַ
		String addressId = JavaApi.getFirstAddressId();
		// ִ���µ��ӿڻ�ȡ����id,�������
		String[] orderInfo = JavaApi.getOrderInfo(addressId, "1", cartToken, "-1", "06:00-07:30", "", "2");
		// ִ�л�ȡԤ֧�������ӿڻ�ȡԤ֧������
		String prePayorderId = JavaApi.getPrepayOrderId(orderInfo[0], orderInfo[1]);
		// ִ�л�Ա��֧���ӿ�
		String responseString = JavaApi.balancePay(prePayorderId);
		Assert.assertTrue(responseString.contains("֧���ɹ�"));
	}

	//�һ�������ͬ����Ʒ
	@Test
	public void twoDifferentGiftsInOrder() throws ClientProtocolException, IOException {
		// �һ���Ʒ���Զ���������Ʒ2
		JavaApi.exchangeGift("1", "994141", "true");
		JavaApi.exchangeGift("1", "994140", "true");
		// ��ȡ��¼token
		String cartToken = JavaApi.getCartToken();
		// ��ȡ�ջ���ַ�б�������ӵĵ�ַ
		String addressId = JavaApi.getFirstAddressId();
		// ִ���µ��ӿڻ�ȡ����id,�������
		String[] orderInfo = JavaApi.getOrderInfo(addressId, "1", cartToken, "-1", "06:00-07:30", "", "2");
		// ִ�л�ȡԤ֧�������ӿڻ�ȡԤ֧������
		String prePayorderId = JavaApi.getPrepayOrderId(orderInfo[0], orderInfo[1]);
		// ִ�л�Ա��֧���ӿ�
		String responseString = JavaApi.balancePay(prePayorderId);
		Assert.assertTrue(responseString.contains("֧���ɹ�"));
	}

	@BeforeClass
	public void beforeClass() throws ClientProtocolException, IOException {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("BuyProcess�������Կ�ʼ");
		InitEnv.addAddress();

	}

	@AfterClass
	public void afterClass() throws ClientProtocolException, IOException {
		ClearEnv.deleteAddress();
		Log.endTestCase("BuyProcess�������Խ���");
	}

}
