package tools;

import java.time.LocalDateTime;

public class ErrorHandler {
	public static final boolean INFO = false;
	public static final boolean DEBUG = false;
	
	public static void HandleError(String message, Exception e) {
		
		String time = LocalDateTime.now().toString();
		
		if (INFO) {
			System.out.println("[INFO] " + time + " An error has occured for the following: " + message);
			System.out.println("[INFO] " + time + " Error message localized: " + e.toString());
		}
		
		if (DEBUG) {
			System.out.println("[DEBUG] " + time + " Error stack trace: ");
			e.printStackTrace();
		}
		
	}
}
