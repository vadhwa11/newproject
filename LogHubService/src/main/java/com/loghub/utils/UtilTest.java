package com.loghub.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class UtilTest {

	public static Date dateFormatterDDMMYYYY(String stringDate) {
		SimpleDateFormat dateFormatterDDMMYYYY = new SimpleDateFormat(
				"dd/MM/yyyy");
		try {
			return (dateFormatterDDMMYYYY.parse(stringDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

   public static long getDateInMilis(String date){
		
	    System.out.println("date ::: "+date);
	
	    String[] dateSplitOnSpace=date.split(" ");
	    String mainDate=dateSplitOnSpace[0];
	    
	    System.out.println("main date ::: "+mainDate);
	    
		String[] dateSplit=mainDate.split("-");
		int d = Integer.parseInt(dateSplit[2]);
		int m = Integer.parseInt(dateSplit[1]);
		int y = Integer.parseInt(dateSplit[0]);
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%5"+d+"/"+m+"/"+y);
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		calendar.clear();
		calendar.set(y,m-1, d);
		long secondsSinceEpoch = calendar.getTimeInMillis();
		return secondsSinceEpoch;
    }

}
