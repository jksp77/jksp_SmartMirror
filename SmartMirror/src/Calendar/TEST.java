package Calendar;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

public class TEST extends JFrame {

	CalEntry[] Entries = new CalEntry[20];
	
	public TEST() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(false);
		this.setVisible(true);
		this.setLayout(null);
		
		this.setForeground(Color.black);
			
		for(int i=0; i<20;i++) {
			Entries[i] = new CalEntry(i);
			Entries[i].setAppearanceWeek();
			Entries[i].setSize(Entries[i].SizeX,Entries[i].SizeY);
			Entries[i].setLocation(Entries[i].PositionX,Entries[i].PositionY);
			this.add(Entries[i]);
		}
		
		int Eintrag = 4;
		Entries[Eintrag].setVisible(true);
		System.out.println(Entries[Eintrag].getBounds());
		System.out.println(Entries[Eintrag].isVisible());
		Entries[Eintrag].printData();
	}
	
	
	public static void main(String[] args) {
new TEST();
				
		
		
		/*
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
		*/

		
		
	}

	
}
