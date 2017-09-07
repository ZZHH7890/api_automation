package test;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;

import com.zzkg.common.ClearEnv;
import com.zzkg.common.Log;
import com.zzkg.japi.JavaApi;

public class DebugTry {

	public static void main(String[] args) throws ClientProtocolException, IOException{
		DOMConfigurator.configure("log4j.xml");
		String reponseString = JavaApi.searchcookbookArticle("ÖÐÎÄ");
		System.out.println(reponseString);
	}

}
