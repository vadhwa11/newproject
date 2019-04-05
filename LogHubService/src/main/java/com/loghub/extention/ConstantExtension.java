package com.loghub.extention;


public class ConstantExtension {

	public static String MESSAGE_ERROR = "Internal Server Error";
	public static String SUCCESS_UPLOADED = "Successfully Updated";
	public static String MESSAGE_DUPLICATE = "Cannot have same Defect List No";

	public static String SUCCESS_MESSAGE_SIGNUP_ERROR = "Email-Id or Phone already exist";
	public static String SUCCESS_MESSAGE_LOGIN_FAILED = "Bad Credential";
	public static String SUCCESS_RECEIVE = "SUCCESSFULLY RECEIVED!!";
	public static String DELETION_ERROR = "Not Deleted!!";
	public static String DUPLICATE_MESSAGE = "Sku is already exists!";

	// adminLogin

	public static String SUCCESS_MESSAGE_ADMIN_TRUE = "Welcome admin";
	public static String SUCCESS_MESSAGE_ADMIN_FALSE = "Wrong credentials";
	public static String ADMIN_WRONG_PASSWORD = "Old Password is not Correct";
	public static String ADMIN_PASSWORD_CHANGED = "Password Changed Successfully";

	public static String SUCCESS_MESSAGE = "Successfully Fetched";
	public static String SUCCESS_MESSAGE_UPDATED = "Successfully Updated";
	public static String SUCCESS_MESSAGE_DELETED = "Successfully Deleted";
	public static String MSG_PHONE_NUMBER_MISSING = "Phone Number is missing";
	public static String MESSAGE_LOGOUT = "Logout Successfully";

	public static String ERROR = "Record Not Found";
	// Paths
	public static String FolderPath = EReturnsExtension.getFolderPath();
	public static String DomainName = EReturnsExtension.getDomainPath();

	public static String FolderPathPostkards = FolderPath + "Images\\Postkards\\";

	public static String DatabasePathPostkards = "Images/Postkards/";
	
	public static String LOGIN_MESSAGE_ERROR ="User name or password is wrong";
 
}
