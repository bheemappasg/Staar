package com.pabb.staarcms.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() 
	{
		Random r=new Random();
		int randomnumber = r.nextInt(2000);
		return randomnumber;
	}
	public String getSystemDateyyyyMMdd()
	{
	   Date d=new Date();
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	  String date = sdf.format(d);
	  return date;
	}
public String getReqDateyyyyMMdd(int days)
	
	{
		
  Date obj=new Date();
		
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf1.format(obj);
		Calendar cal = sdf1.getCalendar();
		 cal.add(Calendar.DAY_OF_MONTH,days);
		 String reqDate = sdf1.format(cal.getTime());
		 System.out.println(reqDate);
		return reqDate;
	}
}
