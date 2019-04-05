package com.loghub.extention;

public class EReturnsExtension {
	public static boolean debug = true;

	public static String getDomainPath() {
		String DomainName = "";
		if (debug) {
			DomainName = "http://localhost:8080/postalove/";
			// DomainName= "http://192.168.1.22:8080/postalove/";
		} else {
			DomainName = "http://postalove.com/";
		}
		return DomainName;
	}

	public static String getFolderPath() {
		String FolderPath = "";
		if (debug) {
			FolderPath = "F:\\workspaces\\java_bit\\postalove\\src\\main\\webapp\\";
			// FolderPath= "D:\\Workspace\\Java\\postalove-web\\src\\main\\webapp\\";
		} else {
			FolderPath = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\ROOT\\";
		}
		return FolderPath;
	}

	public static String breakDomainPath(String url) {
		String DomainName = "";
		if (debug) {
			DomainName = url.split("postalove/")[1];
		} else {
			DomainName = url.split("postalove.com/")[1];
		}
		return DomainName;
	}

}
