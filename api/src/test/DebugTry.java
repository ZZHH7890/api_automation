package test;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;

import common.ClearEnv;
import common.Log;

public class DebugTry {

	public static void main(String[] args){
		try {
			FileWriter fw = new FileWriter("C:\\Users\\Administrator\\eclipse-workspace\\api_automation\\api\\log\\logfile.log", false);
			fw.write("");
			fw.flush();
			fw.close();
			String successString ="�����־�ɹ���";
			Log.info(successString);
		} catch (Exception e) {
			String failString = "�����־ʧ�ܣ�";
			Log.info(failString);
		}
		
	}

}
