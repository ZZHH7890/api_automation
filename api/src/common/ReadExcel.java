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
	// ��ȡ��ά���������ṩ�����������ṩ��pro
	public static Object[][] getTestData(String filepath, String filename, String sheetname) throws IOException {
		Log.info("=========================���������ݶ�ȡ��ʼ=========================");
		File file = new File(filepath + "\\" + filename);
		Log.info("�������ݱ��" + file.toString());
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
		List<Object[]> records = new ArrayList<Object[]>();
		// ��ȡ����ͷ��Ϣ
		Row headerrow = sheet.getRow(0);
		String headerrowfields[] = new String[headerrow.getLastCellNum()];
		for (int k = 0; k < headerrow.getLastCellNum(); k++) {
			headerrowfields[k] = headerrow.getCell(k).getStringCellValue();
		}
		// ��ȡ���������Ϣ
		for (int i = 1; i < rowcount; i++) {
			Row row = sheet.getRow(i);
			String fields[] = new String[row.getLastCellNum()];
			for (int j = 0; j < row.getLastCellNum(); j++) {
				if (row.getCell(j) != null) {
					fields[j] = row.getCell(j).getStringCellValue();
					Log.info(headerrowfields[j] + "��" + fields[j]);
				}
			}
			records.add(fields);
		}
		Object[][] results = new Object[records.size()][];
		for (int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);
		}
		workbook.close();
		Log.info("=========================���������ݶ�ȡ����=========================");
		return results;

	}
	//��ȡ���������������û�����֤�롢�Ƽ���
	public static String[] getConfigData(String filepath, String filename, String sheetname, int configrow) throws IOException {
		Log.info("=========================���Ի������ݶ�ȡ��ʼ=========================");
		File file = new File(filepath + "\\" + filename);
		Log.info("�����ļ����" + file.toString());
		Log.info("��ȡsheet: "+ sheetname);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		// ��ȡ����ͷ��Ϣ
		Row headerrow = sheet.getRow(0);
		String headerrowfields[] = new String[headerrow.getLastCellNum()];
		for (int k = 0; k < headerrow.getLastCellNum(); k++) {
			headerrowfields[k] = headerrow.getCell(k).getStringCellValue();
		}
		// ��ȡ���������������û�����֤�롢�Ƽ�����Ϣ
		Row row = sheet.getRow(configrow-1);
		String fields[] = new String[row.getLastCellNum()];
		for (int j = 0; j < row.getLastCellNum(); j++) {
			if (row.getCell(j) != null) {
				fields[j] = row.getCell(j).getStringCellValue();
				Log.info(headerrowfields[j] + "��" + fields[j]);
			}
		}
		workbook.close();
		Log.info("=========================���Ի������ݶ�ȡ����=========================");
		return fields;
	}
	// ��ȡ�ӿ���Ϣ
	public static String[] getApi(String filepath, String filename, String sheetname, int apirow) throws IOException {
		Log.info("=========================�ӿ���Ϣ��ȡ��ʼ=========================");
		File file = new File(filepath + "\\" + filename);
		Log.info("�����ļ����" + file.toString());
		Log.info("��ȡsheet: "+ sheetname);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		// ��ȡ��apirow�нӿ���Ϣ
		Row row = sheet.getRow(apirow-1);
		String fields[] = new String[row.getLastCellNum()];
		for (int j = 0; j < row.getLastCellNum(); j++) {
			if (row.getCell(j) != null) {
				fields[j] = row.getCell(j).getStringCellValue();
			}
		}
		Log.info(fields[0] + ": " + fields[1] + "���ڱ��ĵ�" + apirow + "��");
		workbook.close();
		Log.info("=========================�ӿ���Ϣ��ȡ����=========================");
		return fields;
	}
}
