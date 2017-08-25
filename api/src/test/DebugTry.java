package test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.xml.DOMConfigurator;

import common.ClearEnv;

public class DebugTry {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		DOMConfigurator.configure("log4j.xml");
		ClearEnv.deleteAddress();
	}

}
