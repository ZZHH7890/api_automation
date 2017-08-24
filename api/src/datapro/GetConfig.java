package datapro;

import java.io.IOException;

import common.ReadExcel;
import net.sf.json.JSONObject;

public class GetConfig {
	public static JSONObject config() throws IOException {
		String[] initdata = ReadExcel.getConfigData(
				"C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\initExcel\\", "config.xlsx", "config");
		JSONObject jsonconfig = new JSONObject();
		jsonconfig.put("host", initdata[0]);
		jsonconfig.put("region", initdata[1]);
		jsonconfig.put("phone", initdata[2]);
		jsonconfig.put("code", initdata[3]);
		jsonconfig.put("introducerCode", initdata[4]);
		return jsonconfig;
	}
}
