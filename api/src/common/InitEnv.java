package common;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import datapro.GetExcelData;

public class InitEnv {	
	public static void clearCart() throws ClientProtocolException, IOException {
		String result = HttpClientMethod.delete(GetExcelData.getHost(), GetExcelData.getApi(), GetExcelData.getRegion(), Login.getToken(GetExcelData.getPhone(), GetExcelData.getCode(), GetExcelData.getIntroducerCode()));
		System.out.println("清空购物车成功:"+ result);
	}
	

}
