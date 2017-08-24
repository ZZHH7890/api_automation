package datapro;

import java.io.IOException;

import common.ReadExcel;
import net.sf.json.JSONObject;

public class GetApi {
	public static JSONObject exchangeGiftApi() throws IOException {
		String[] initdata = ReadExcel.getExchangeGiftApi(
				"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\initExcel\\", "api.xlsx", "api");
		JSONObject jsonapi = new JSONObject();
		jsonapi.put("apiname", initdata[0]);
		jsonapi.put("apiurl", initdata[1]);
		return jsonapi;
	}
}
