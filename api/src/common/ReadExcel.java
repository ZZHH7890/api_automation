package common;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	// 获取二维数组数据提供给测试数据提供类pro
	public static Object[][] getTestData(String filepath, String filename, String sheetname) throws IOException {
		Log.info("=========================表格测试数据读取开始=========================");
		File file = new File(filepath + "\\" + filename);
		Log.info("测试数据表格：" + file.toString());
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
		List<Object[]> records = new ArrayList<Object[]>();
		// 获取表格表头信息
		Row headerrow = sheet.getRow(0);
		String headerrowfields[] = new String[headerrow.getLastCellNum()];
		for (int k = 0; k < headerrow.getLastCellNum(); k++) {
			headerrowfields[k] = headerrow.getCell(k).getStringCellValue();
		}
		// 获取表格数据信息
		for (int i = 1; i < rowcount; i++) {
			Row row = sheet.getRow(i);
			String fields[] = new String[row.getLastCellNum()];
			for (int j = 0; j < row.getLastCellNum(); j++) {
				if (row.getCell(j) != null) {
					fields[j] = row.getCell(j).getStringCellValue();
					Log.info(headerrowfields[j] + "：" + fields[j]);
				}
			}
			records.add(fields);
		}
		Object[][] results = new Object[records.size()][];
		for (int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);
		}
		workbook.close();
		Log.info("=========================表格测试数据读取结束=========================");
		return results;

	}
	//获取服务器、社区、用户、验证码、推荐码
	public static String[] getConfigData(String filepath, String filename, String sheetname, int configrow) throws IOException {
		Log.info("=========================测试环境数据读取开始=========================");
		File file = new File(filepath + "\\" + filename);
		Log.info("配置文件表格：" + file.toString());
		Log.info("读取sheet: "+ sheetname);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		// 获取表格表头信息
		Row headerrow = sheet.getRow(configrow-1);
		String headerrowfields[] = new String[headerrow.getLastCellNum()];
		for (int k = 0; k < headerrow.getLastCellNum(); k++) {
			headerrowfields[k] = headerrow.getCell(k).getStringCellValue();
		}
		// 获取服务器、社区、用户、验证码、推荐码信息
		Row row = sheet.getRow(1);
		String fields[] = new String[row.getLastCellNum()];
		for (int j = 0; j < row.getLastCellNum(); j++) {
			if (row.getCell(j) != null) {
				fields[j] = row.getCell(j).getStringCellValue();
				Log.info(headerrowfields[j] + "：" + fields[j]);
			}
		}
		workbook.close();
		Log.info("=========================测试环境数据读取结束=========================");
		return fields;
	}
	// 获取接口信息
	public static String[] getApi(String filepath, String filename, String sheetname, int apirow) throws IOException {
		Log.info("=========================接口信息读取开始=========================");
		File file = new File(filepath + "\\" + filename);
		Log.info("配置文件表格：" + file.toString());
		Log.info("读取sheet: "+ sheetname);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		// 获取第apirow行接口信息
		Row row = sheet.getRow(apirow-1);
		String fields[] = new String[row.getLastCellNum()];
		for (int j = 0; j < row.getLastCellNum(); j++) {
			if (row.getCell(j) != null) {
				fields[j] = row.getCell(j).getStringCellValue();
			}
		}
		Log.info(fields[0] + ": " + fields[1] + "在表格的第" + apirow + "行");
		workbook.close();
		Log.info("=========================接口信息读取结束=========================");
		return fields;
	}
}
