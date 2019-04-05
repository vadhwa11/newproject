package com.loghub.extention;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class HelperExtension {

	long Time = 0;

	public String getUniqueId() {

		return (new Date().getTime() + RandonNumber() + "");
	}

	public Timestamp getDateTime() {
		long serverTimeStamp = new Date().getTime() + Time;
		return new Timestamp(serverTimeStamp);
	}

	public Timestamp getDateTime(String string_timestamp) {

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(string_timestamp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Timestamp(date.getTime());
	}

	public Date getDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date sqlDate = null;
		try {
			Date utilDate = format.parse(date);
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}

	public int RandonNumber() {
		int randomNumber = (new Random().nextInt(9999 - 1000) + 1000);
		return randomNumber;
	}

	public Date timestampToDate(long time) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.setTimeZone(TimeZone.getDefault());
		return new Date(time);
	}

	public String millisToDate(long time) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getDefault());
		cal.setTimeInMillis(time);
		return cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
	}

	/*public String millisToDatePostcard(long time) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getDefault());
		cal.setTimeInMillis(time);
		return cal.get(Calendar.DAY_OF_MONTH) + " " + getMonthString(cal.get(Calendar.MONTH) + 1) + " "
				+ cal.get(Calendar.YEAR);
	}*/

	public String millisToDateTime(long millis) {
		HelperExtension.Print("millis ->" + millis);
		// Input -> millis ->1513408806000
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getDefault());
		cal.setTimeInMillis(millis);

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss aa");
		String datetime = sdf.format(cal.getTime());
		HelperExtension.Print("Date ->" + datetime);
		// Output -> Date ->16-12-2017 12:50:06 PM
		return datetime;
	}

	public static void Print(Object message) {
		if (EReturnsExtension.debug) {
			System.out.println(message);
		}
	}

	public boolean isNullOrEmpty(Object message) {
		if (message != null) {
			if (!message.toString().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public String isNullString(String message) {
		if (message == null || message.equalsIgnoreCase("null")) {
			return "";
		}
		return message.toString();
	}

	public String isNullInt(String message) {
		if (message == null) {
			return "";
		}
		return message.toString();
	}

/*	public String getMonthString(int month) {
		String monthString;
		switch (month) {
		case 1:
			monthString = "Jan";
			break;
		case 2:
			monthString = "Feb";
			break;
		case 3:
			monthString = "Mar";
			break;
		case 4:
			monthString = "Apr";
			break;
		case 5:
			monthString = "May";
			break;
		case 6:
			monthString = "Jun";
			break;
		case 7:
			monthString = "Jul";
			break;
		case 8:
			monthString = "Aug";
			break;
		case 9:
			monthString = "Sep";
			break;
		case 10:
			monthString = "Oct";
			break;
		case 11:
			monthString = "Nov";
			break;
		case 12:
			monthString = "Dec";
			break;
		default:
			monthString = "Invalid month";
			break;
		}
		return monthString;
	}*/

	/*public String getMonthInt(String month) {
		String monthInt;
		switch (month.toUpperCase()) {
		case "JAN":
			monthInt = "01";
			break;
		case "FEB":
			monthInt = "02";
			break;
		case "MAR":
			monthInt = "03";
			break;
		case "APR":
			monthInt = "04";
			break;
		case "MAY":
			monthInt = "05";
			break;
		case "JUN":
			monthInt = "06";
			break;
		case "JUL":
			monthInt = "07";
			break;
		case "AUG":
			monthInt = "08";
			break;
		case "SEP":
			monthInt = "09";
			break;
		case "OCT":
			monthInt = "10";
			break;
		case "NOV":
			monthInt = "11";
			break;
		case "DEC":
			monthInt = "12";
			break;
		default:
			monthInt = "01";
			break;
		}
		return monthInt;
	}
*/
	public static String getCalculateGeneralDefect(String strBf, String strOcc, String strRec) {
		String result = "";
		Double doubleBf = 0.0, doubleOcc = 0.0, doubleRec = 0.0;
		HelperExtension helperExtension = new HelperExtension();
		if (!helperExtension.isNullOrEmpty(strBf)) {
			doubleBf = Double.parseDouble(strBf);
		}
		if (!helperExtension.isNullOrEmpty(strOcc)) {
			doubleOcc = Double.parseDouble(strOcc);
		}
		if (!helperExtension.isNullOrEmpty(strRec)) {
			doubleRec = Double.parseDouble(strRec);
		}
		HelperExtension.Print("rec" + strRec);
		HelperExtension.Print("bf: " + doubleBf + "occ: " + doubleOcc + "rec: " + doubleRec);
		result = "" + (doubleBf + doubleOcc - doubleRec);
		HelperExtension.Print(result);
		return result;
	}

	public boolean tryParseInt(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
