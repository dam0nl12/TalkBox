package talkbox;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FunctionHandler {
	
	private final static String DATE_FORMAT = "yyyy--mm--dd";
	
	public boolean emptyRECheck(String str) {
		return str.matches("");
	}

	public boolean spaceRECheck(String str) {
		return str.matches("^\\s+");
	}

	public boolean doubleRECheck(String str) {
		return (str.matches("") || str.matches("^\\s+"));
	}

	public boolean dateCheck(String date) {
		try {
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			df.setLenient(false);
			df.parse(date);
			return true;
			
		} catch (ParseException e) {
			return false;
		}
	}

	public static void main(String[] args) {
		FunctionHandler fh = new FunctionHandler();
		String str1 = " ";
		String str2 = "2    2";
		String str3 = "";

		System.out.println(fh.spaceRECheck(str1));
		System.out.println(fh.spaceRECheck(str2));
		System.out.println(fh.emptyRECheck(str3));
	}
}
