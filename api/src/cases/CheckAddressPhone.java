package cases;

import org.testng.annotations.Test;

import common.Log;
import common.Login;
import common.PostMethod;
import datapro.ConfigPro;
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
		Log.startTestCase("CheckAddressPhone用例测试开始");
		String[] configStr= ConfigPro.getConfig();
		String token = Login.getToken(configStr[3], configStr[4],configStr[5]);
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("addressBuildingId", "259");
		jsonParam.put("addressNaviId", "18039");
		jsonParam.put("building", "南区美庐园B栋");
		jsonParam.put("city1", "深圳");
		jsonParam.put("contact", name);
		jsonParam.put("gender", "0");
		jsonParam.put("latitude", "22.408965");
		jsonParam.put("longitude", "113.826119");
		jsonParam.put("phone", phone);
		jsonParam.put("regionId", "813395");
		jsonParam.put("room1", "11111A");
		jsonParam.put("village", "东角山");
		String respondresult = PostMethod.getHttpResult(configStr[0], configStr[1], configStr[2], token, jsonParam);
		Assert.assertTrue(respondresult.contains(re));
        Log.endTestCase("CheckAddressPhone用例测试结束");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("测试开始！！");
		DOMConfigurator.configure("log4j.xml");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("测试结束！！");
	}

}
