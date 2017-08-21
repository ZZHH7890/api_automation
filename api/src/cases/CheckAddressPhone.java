package cases;

import org.testng.annotations.Test;

import common.Log;
import common.Login;
import common.PostMethod;
import datapro.PhonePro;
import net.sf.json.JSONObject;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class CheckAddressPhone {

	@Test(enabled = true, dataProvider = "phone", dataProviderClass = PhonePro.class, priority = 1)
	public void addAddress(String name, String phone, String re) throws ClientProtocolException, IOException {
		Log.startTestCase("CheckAddressPhone�������Կ�ʼ");
		String host = "http://release.thy360.com";
		String path = "/v3/setting/address";
		String region = "813395";
		String tokenphone = "13714672775";
		String code = "1234";
		String introducerCode = "";
		String token = Login.getToken(tokenphone, code, introducerCode);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("addressBuildingId", "259");
		jsonParam.put("addressNaviId", "18039");
		jsonParam.put("building", "������®԰B��");
		jsonParam.put("city1", "����");
		jsonParam.put("contact", name);
		jsonParam.put("gender", "0");
		jsonParam.put("latitude", "22.408965");
		jsonParam.put("longitude", "113.826119");
		jsonParam.put("phone", phone);
		jsonParam.put("regionId", "813395");
		jsonParam.put("room1", "11111A");
		jsonParam.put("village", "����ɽ");
		String respondresult = PostMethod.getHttpResult(host, path, region, token, jsonParam);
		Assert.assertTrue(respondresult.contains(re));
        Log.endTestCase("CheckAddressPhone�������Խ���");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("���Կ�ʼ����");
		DOMConfigurator.configure("log4j.xml");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("���Խ�������");
	}

}
