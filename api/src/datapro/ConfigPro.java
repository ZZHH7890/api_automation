package datapro;

import java.io.IOException;

import common.ExcelData;

public class ConfigPro {
public static String[] getConfig() throws IOException {
	return ExcelData.getConfigData("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\testConfigExcel\\", "config.xlsx", "config");
}
}
