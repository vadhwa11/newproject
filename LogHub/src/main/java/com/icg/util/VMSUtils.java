package com.icg.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class VMSUtils {

	public static Date dateFormatterDDMMYYYY(String stringDate) {
		SimpleDateFormat dateFormatterDDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return (dateFormatterDDMMYYYY.parse(stringDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	 public static String URLify(String str) {
	       str = str.trim();
	       int length = str.length();
	       int trueL = length;
	       if(str.contains(" ")) {
	           for(int i = 0; i < length; i++) {
	               if(str.charAt(i) == ' ') {
	                   trueL = trueL + 2;
	               }
	           }
	           char[] oldArr = str.toCharArray();
	           char[] newArr = new char[trueL];
	           int x = 0;
	           for(int i = 0; i < length; i++) {
	               if(oldArr[i] == ' ') {
	                   newArr[x] = '%';
	                   newArr[x+1] = '2';
	                   newArr[x+2] = '0';
	                   x += 3;
	               } else {
	                   newArr[x] = oldArr[i];
	                   x++;
	               }
	           }
	           str = new String(newArr, 0, trueL);
	       }
	       return str;
	   }
	
	
	public static String getDate(Calendar cal){
        return "" + cal.get(Calendar.DATE) +"/" +
                (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR);
    }

	public static String dateInDDMMYYYY(String stringDate) {
		 String str=stringDate.substring(0,10);
		 System.out.println("str: "+str);
		 
		 String strArray[]= str.split("-");
		 
		 String date=strArray[2]+"/"+strArray[1]+"/"+strArray[0]; 
		 System.out.println("date : "+date);
		 return date;
	}
	
	
	public static Date getDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date sqlDate = null;
		try {
			Date utilDate = format.parse(date);
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}
	
	
	public static boolean isValidEmail(String email)
    {
       /* String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";*/
        
        //string s="^(([-\w\d]+)(\.[-\w\d]+)*@([-\w\d]+)(\.[-\w\d]+)*(\.([a-zA-Z]{2,5}|[\d]{1,3})){1,2})$";
        String emailRegex ="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
                             
        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }
	
	public static boolean isValidMobNo(String s)
    {
        // The given argument to compile() method 
        // is regular expression. With the help of 
        // regular expression we can validate mobile
        // number. 
        // 1) Begins with 0 or 91
        // 2) Then contains 7 or 8 or 9.
        // 3) Then contains 9 digits
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
 
        // Pattern class contains matcher() method
        // to find matching between given number 
        // and regular expression
        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }
}
