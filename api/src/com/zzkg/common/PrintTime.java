package com.zzkg.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
*@author �Ŵ�ү
*@time 2017��9��11�� ����5:54:35
*automation
*/
public class PrintTime {
	public static String nowTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String nowTime = "��ǰʱ��Ϊ��" + sdf.format(date);
		return  nowTime;
	}
	
}
