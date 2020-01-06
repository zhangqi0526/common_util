package com.zhangqi.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author Administrator
 *
 */
public class DateUtil {

	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 时间格式化
	 * @param theDate
	 * @return:String
	 */
	public static String format(Date theDate) {
		return dateFormat.format(theDate);
	}
	/**
	 * 根据生日计算年龄
	 * @param:birthDate
	 */
	public static int getAge(Date birthDate) {
		//获得日历控件
		Calendar calendar = Calendar.getInstance();
		// 获得年、月、日
		int nowYear = calendar.get(Calendar.YEAR);
		int nowMonth = calendar.get(Calendar.MONTH);
		int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
		// 设置日历控件为生日的 时间
		int birthYear = calendar.get(Calendar.YEAR);
		int birthMonth = calendar.get(Calendar.MONTH);
		int birthDay = calendar.get(Calendar.DAY_OF_MONTH);
		// 计算年龄
		int age = nowYear-birthDay;
		// 如果生日的月份大于当前月份时，年龄-1
		if(birthMonth>nowMonth) {
			age--;
		}
		// 如果月份相等，判断日期
		if(birthMonth == nowMonth && birthDay>nowDay) {
			age--;
		}
		return age;
	}
	/**
	 * 根据出生日期计算年龄
	 * @param birthDateStr "2019-11-08"
	 */
	public static int getAge(String birthDateStr) {
		Date birthDate = null;
		try {
			birthDate= dateFormat.parse(birthDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 调用日期计算方法
		return getAge(birthDate);
	}
	/**
	 * 获取开始日期和结束日期之间有多少天
	 * @param:  startDate
	 * @param:  endDate
	 * return : int 
	 */
	public static int  getDayNum(Date date1,Date date2) {
		// 一天有多少毫秒
		Long dayTime = 100*60*60*24L;
		Long startTime = date1.getTime();
		Long endTime = date2.getTime();
		System.out.println(startTime);
		System.out.println(endTime);
		Double dayNum= Math.abs((endTime-startTime)/dayTime*1.0);
		return dayNum.intValue()+1;
	}
	/**
	 * 计算指定日期距离今天，过去了多少天或 还有多少天
	 * @param :date
	 * @return int 
	 */
	public static int getDayNum(Date date) {
		Date date2 = new Date();
		return getDayNum(date, date2);
	}
	/**
	 * 验证指定日期是否为今天
	 * @param theDate (Date theDate = dateFormat.parse("2013-05-26"))
	 * @throws ParseException
	 * @return boolean
	 */
	public static boolean isToday(Date theDate) {
		Date nowDate = new Date();
		String nowDateStr = dateFormat.format(nowDate);
		String theDateStr = dateFormat.format(theDate);
		return nowDateStr.equals(theDateStr);
	}
	/**
	 * 验证指定日期是否为今天
	 * @param theDate  "2013-05-26"
	 * @throws ParseException
	 * @return boolean
	 */
	public static boolean isToday(String theDateStr) {
		try {
			Date theDate = dateFormat.parse(theDateStr);
			return isToday(theDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * @Title: isInWeek
	 * 判断指定日期是否在本周
	 * @param theDate
	 * @throws ParseException
	 * @return : boolean
	 */
	public static boolean isInWeek(Date theDate){
		Date nowDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(nowDate);
		// 本周第几天
		int dayofweek = c.get(Calendar.DAY_OF_WEEK);
		// 设置本周第一天的时间
		c.add(Calendar.DAY_OF_YEAR, 1-dayofweek);
		c.add(Calendar.HOUR_OF_DAY, 0);
		c.add(Calendar.MINUTE, 0);
		c.add(Calendar.SECOND, 0);
		Date firstDate = c.getTime();
		System.out.println(dateTimeFormat.format(firstDate));
		//设置本周最后一天的时间
		c.add(Calendar.DAY_OF_YEAR, 6);
		c.add(Calendar.HOUR_OF_DAY, 23);
		c.add(Calendar.MINUTE, 59);
		c.add(Calendar.SECOND, 59);
		Date lastDate =c.getTime();
		System.out.println(dateTimeFormat.format(theDate));
		System.out.println(dateTimeFormat.format(lastDate));
		return compareTime(theDate,firstDate)>=0 && compareTime(theDate,lastDate)<=0;
	}
	public static int compareTime(Date date1,Date date2) {
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		if(time1==time2) {
			return 0;
		}
		if(time1>time2) {
			return 1;
		}
		return -1;
		
	}
	
	
	
	public static void main(String[] args) throws ParseException {
		Date theDate = dateFormat.parse("2013-05-26");
		System.out.println(getDayNum(theDate));
		System.out.println(isToday(theDate));
	}
}


































