package com.numberONe.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtil {

	public static String formatDate(Date date,String format){
		String result="";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		if(date!=null){
			result=sdf.format(date);
		}
		return result;
	}
	
	
	public static Date formatString(String str,String format) throws Exception{
		if(StringUtil.isEmpty(str)){
			return null;
		}
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.parse(str);
	}
	
	public static String getCurrentDateStr()throws Exception{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		return sdf.format(date);
	}
	//���ݴ����int���������գ�����yyyy-MM-dd��������
	public static String getDateFormat(int year,int month,int day) {
		String y = year+"";
		String m = month+"";
		String d = day+"";
		if (m.length()==1) {
			m = "0"+m;
		}
		if (d.length()==1) {
			d = "0"+d;
		}
		String dateFomart = y+"-"+m+"-"+d;
		return dateFomart;
	}
	//������ݺ��·��жϸ���������
	public static int getDaysByYearAndMonth(int year,int month) {
		int totalDays;
		if(year%4==0 && year%100 !=0 ||year%400 ==0) {
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				totalDays=31;
				break;
			case 2:
				totalDays=29;
				break;
			default:
				totalDays=30;
				break;
			}
		}else {
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				totalDays=31;
				break;
			case 2:
				totalDays=28;
				break;
			default:
				totalDays=30;
				break;
			}
		}
		return totalDays;
	}
	//���ݵ�ǰ���£������һ����
	public static List<String> getLastMonth(String year,String month) {
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month);
		List<String> list = new ArrayList<String>();
		if(m==1) {
			year = y-1+"";
			month = "12";
			list.add(year);
			list.add(month);
			return list;			
		}
		month = m-1+"";
		list.add(year);
		list.add(month);
		return list;
	}

}
