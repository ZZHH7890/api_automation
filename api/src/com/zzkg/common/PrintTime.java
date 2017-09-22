package com.zzkg.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
*@author 张大爷
*@time 2017年9月11日 下午5:54:35
*automation
*/
public class PrintTime {
	public static String nowTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String nowTime = "当前时间为：" + sdf.format(date);
		return  nowTime;
	}
	
}
