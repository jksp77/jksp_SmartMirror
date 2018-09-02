package Calendar;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TEST {

	public static void main(String[] args) {

	/*	CalEntry[] Entries = new CalEntry[20];
		
		for(int i=0;i<20;i++) {
			Entries[i] = new CalEntry(i);
		}
	*/	
		Date Timestamp = new Date();
		SimpleDateFormat Format = new SimpleDateFormat("EE");
		
		long day = 1000*60*60*24;
		Timestamp = new Date(Timestamp.getTime() - day);
		
		String Weekday = Format.format(Timestamp).toString();
		
		switch (Weekday) {
		case "Mo":
			Weekday = "Montag";
			break;
		case "Di":
			Weekday = "Dienstag";
			break;
		case "Mi":
			Weekday = "Mittwoch";
			break;
		case "Do":
			Weekday = "Donnerstag";
			break;
		case "Fr":
			Weekday = "Freitag";
			break;
		case "Sa":
			Weekday = "Samstag";
			break;
		case "So":
			Weekday = "Sonntag";
			break;
		default:
			Weekday = "unknown";
		}
		
		System.out.println(Weekday);
		
	}

	
}
