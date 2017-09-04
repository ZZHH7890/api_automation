package com.zzkg.common;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class HttpClientMethod {
	// put��������json body
	public static String putJson(String host, String path, String region, String token, JSONObject jsonParam)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ����putJson++++++++++++++++++++++");
		HttpClient httpclient = HttpClients.createDefault();
		String apiurl = host + path;
		HttpPut httpput = new HttpPut(apiurl);
		httpput.setHeader("Content-Type", "application/json");
		httpput.setHeader("region", region);
		httpput.setHeader("token", token);
		Log.info("���Է�������" + host);
		Log.info("���Խӿڣ�" + path);
		Log.info("����������" + region);
		Log.info("�û���¼token:" + token);
		Log.info("���ԽӿڵĴ���json���ݣ�" + jsonParam.toString());
		StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");// ���������������
		httpput.setEntity(entity);
		HttpResponse httpresponse = httpclient.execute(httpput);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		Log.info("���Խӿڷ���:" + strResult);
		httpput.releaseConnection();
		Log.info("+++++++++++++++++��������putJson++++++++++++++++++++++");
		return strResult;
	}

	// get����
	public static String get(String host, String path, String region, String token)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ����get++++++++++++++++++++++");
		HttpClient httpclient = HttpClients.createDefault();
		String apiurl = host + path;
		HttpGet httpget = new HttpGet(apiurl);
		httpget.setHeader("region", region);
		httpget.setHeader("token", token);
		Log.info("���Է�������" + host);
		Log.info("���Խӿڣ�" + path);
		Log.info("����������" + region);
		Log.info("�û���¼token:" + token);
		HttpResponse httpresponse = httpclient.execute(httpget);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		Log.info("���Խӿڷ���:" + strResult);
		httpget.releaseConnection();
		Log.info("+++++++++++++++++��������get++++++++++++++++++++++");
		return strResult;
	}

	// post�������뵥��json body ��ȡtoken����¼��
	public static String postJsonToken(String host, String path, String region, JSONObject jsonParam)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ����postJsonToken++++++++++++++++++++++");
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String apiurl = host + path;
		HttpPost httppost = new HttpPost(apiurl);
		httppost.setHeader("Content-Type", "application/json");
		httppost.setHeader("region", region);
		Log.info("���Է�������" + host);
		Log.info("���Խӿڣ�" + path);
		Log.info("����������" + region);
		Log.info("���ԽӿڵĴ���json���ݣ�" + jsonParam.toString());
		StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");// ���������������
		httppost.setEntity(entity);
		CloseableHttpResponse httpresponse = httpclient.execute(httppost);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		Log.info("���Խӿڷ���:" + strResult);
		httpresponse.close();
		httppost.releaseConnection();
		httpclient.close();
		Log.info("+++++++++++++++++��������postJsonToken++++++++++++++++++++++");
		return strResult;
	}

	// post�������뵥��json body��������ַ��
	public static String postJson(String host, String path, String region, String token, JSONObject jsonParam)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ����postJson++++++++++++++++++++++");
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String apiurl = host + path;
		HttpPost httppost = new HttpPost(apiurl);
		httppost.setHeader("Content-Type", "application/json");
		httppost.setHeader("region", region);
		httppost.setHeader("token", token);
		// ��Ա��֧����Ҫ��appId
		httppost.setHeader("appId", "appidzzkg9021v754d");
		Log.info("���Է�������" + host);
		Log.info("���Խӿڣ�" + path);
		Log.info("����������" + region);
		Log.info("�û���¼token:" + token);
		Log.info("���ԽӿڵĴ���json���ݣ�" + jsonParam.toString());
		StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");// ���������������
		httppost.setEntity(entity);
		CloseableHttpResponse httpresponse = httpclient.execute(httppost);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		Log.info("���Խӿڷ���:" + strResult);
		httpresponse.close();
		httppost.releaseConnection();
		httpclient.close();
		Log.info("+++++++++++++++++��������postJson++++++++++++++++++++++");
		return strResult;
	}

	// post��������jsonArray body(����һ������)
	public static String postJsonArray(String host, String path, String region, String token, JSONArray jsonArrayParam)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ����postJson++++++++++++++++++++++");
		HttpClient httpclient = HttpClients.createDefault();
		String apiurl = host + path;
		HttpPost httppost = new HttpPost(apiurl);
		httppost.setHeader("Content-Type", "application/json");
		httppost.setHeader("region", region);
		httppost.setHeader("token", token);
		// ��Ա��֧����Ҫ��appId
		httppost.setHeader("appId", "appidzzkg9021v754d");
		Log.info("���Է�������" + host);
		Log.info("���Խӿڣ�" + path);
		Log.info("����������" + region);
		Log.info("�û���¼token:" + token);
		Log.info("���ԽӿڵĴ���json���ݣ�" + jsonArrayParam.toString());
		StringEntity entity = new StringEntity(jsonArrayParam.toString(), "utf-8");// ���������������
		httppost.setEntity(entity);
		HttpResponse httpresponse = httpclient.execute(httppost);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		Log.info("���Խӿڷ���:" + strResult);
		httppost.releaseConnection();
		Log.info("+++++++++++++++++��������postJson++++++++++++++++++++++");
		return strResult;
	}

	// delete����
	public static String delete(String host, String path, String region, String token)
			throws ClientProtocolException, IOException {
		Log.info("+++++++++++++++++��ʼ����delete++++++++++++++++++++++");
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String apiurl = host + path;
		HttpDelete httpdelete = new HttpDelete(apiurl);
		httpdelete.setHeader("region", region);
		httpdelete.setHeader("token", token);
		Log.info("���Է�������" + host);
		Log.info("���Խӿڣ�" + path);
		Log.info("����������" + region);
		Log.info("�û���¼token:" + token);
		CloseableHttpResponse httpresponse = httpclient.execute(httpdelete);
		String strResult = EntityUtils.toString(httpresponse.getEntity());
		Log.info("���Խӿڷ���:" + strResult);
		httpresponse.close();
		httpdelete.releaseConnection();
		httpclient.close();
		Log.info("+++++++++++++++++��������delete++++++++++++++++++++++");
		return strResult;
	}
}
