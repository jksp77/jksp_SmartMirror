package Calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Config.Configuration;

public class CalEntry extends JPanel {
	private static final long serialVersionUID = 1L;

	Configuration prop;
	CalConfig CalData;

	String Title;
	String Location;
	String Description;

	String ColorID;
	Color Foreground;

	String StartTime;
	String StartDate;
	String EndTime;
	String EndDate;
	Date Starttime;
	Date Endtime;
	Dimension Size;
	Point StartPoint;
	Date Timestamp;

	int index;
	int length;
	int width;
	int gap;
	int startX;
	int startY;
	
	public int PositionX;
	public int PositionY;
	public int SizeX;
	public int SizeY;

	JLabel LTitle;
	JLabel LTime;
	JLabel LLocation;
	JLabel LDescription;

	public CalEntry(int i) {
		prop = new Configuration();
		CalData = new CalConfig();

		index = i;
		
		this.setBackground(null);
		// this.setLocation(pointPanel);
		// this.setSize(DimPanel);
		this.setLayout(null);
		this.setVisible(false);
		
		LTitle = new JLabel();
		LTime = new JLabel();
		LLocation = new JLabel();
		LDescription = new JLabel();
		
		LTitle.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,15));
		LTitle.setForeground(Color.white);
		LTitle.setSize(80,20);
		LTitle.setLocation(5,3);
		LTitle.setVisible(true);

		LTime.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,12));
		LTime.setForeground(Color.white);
		LTime.setSize(80,30);
		LTime.setLocation(5,25);
		LTime.setVisible(true);
		
		LLocation.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,12));
		LLocation.setForeground(Color.white);
		LLocation.setSize(80,15);
		LLocation.setLocation(5,55);
		LLocation.setVisible(false);
		
		LDescription.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,12));
		LDescription.setForeground(Color.white);
		LDescription.setSize(80,15);
		LDescription.setLocation(5,70);
		LDescription.setVisible(false);

		this.add(LTitle);
		this.add(LTime);
		this.add(LLocation);
		this.add(LDescription);
	}

	void getData() {
		CalData = new CalConfig();
		Title = CalData.getProperty("title" + index);
		LTitle.setText(Title);

		Location = CalData.getProperty("location" + index);
		if (Location == "None") {
			Location = "";
		}
		LLocation.setText(Location);

		Description = CalData.getProperty("description" + index);
		if (Description == "None") {
			Description = "";
		}
		LDescription.setText(Description);

		StartTime = CalData.getProperty("stime" + index);
		StartDate = CalData.getProperty("sdate" + index);
		EndTime = CalData.getProperty("etime" + index);
		EndDate = CalData.getProperty("edate" + index);

		
		  System.out.println("strings"); System.out.println("StartTime " + StartTime);
		  System.out.println("StartDate " + StartDate); System.out.println(EndTime);
		  System.out.println(EndDate);
		 

		StartTime = StartTime.substring(0, Math.min(StartTime.length(), 19));
		EndTime = EndTime.substring(0, Math.min(EndTime.length(), 19));

		SimpleDateFormat TimeFormat = new SimpleDateFormat(prop.getProperty("CalZeitFormat"));
		SimpleDateFormat TimeFormat2 = new SimpleDateFormat(prop.getProperty("CalZeitFormat2"));

		try {
			Starttime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(StartTime); // THH:mm:ss
			Endtime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(EndTime);
			LTime.setText("<html>"+TimeFormat.format(Starttime).toString() + "<br/> - " + TimeFormat.format(Endtime).toString()+"</html>");

		} catch (ParseException e) {
			StartTime = StartDate + "T00:00:00";
			EndTime = EndDate + "T00:00:00";
			try {
				Starttime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(StartTime);
				Endtime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(EndTime);
				LTime.setText(
						"<html>"+TimeFormat2.format(Starttime).toString() + "<br/> - " + TimeFormat2.format(Endtime).toString()+"</html>");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		ColorID = CalData.getProperty("color" + index);
		switch (ColorID) {
		case "green":
			Foreground = Color.green;
			break;
		case "pink":
			Foreground = Color.pink;
			break;
		case "5":
			Foreground = Color.yellow;
			break;
		default:
			Foreground = Color.blue;
		}

	}

	@SuppressWarnings("deprecation")
	public void setAppearanceWeek() {

		length = 720;
		width = 100;
		gap = 2;
		startX = 0;
		startY = 50;
		
		this.setBorder(BorderFactory.createMatteBorder(3,2, 3, 2, Foreground));
		LTitle.setForeground(Foreground);
		/*
		if (Endtime.getDate() == Starttime.getDate()) {
			this.setLocation(width * (Starttime.getDay() - 1) + gap,(length / 24) * Starttime.getHours());
			this.setSize(width - (2 * gap), (length / 24) * (int) ((Endtime.getTime() - Starttime.getTime())/(1000 * 60 * 60)));
		} else {
			this.setSize(width - (2 * gap) * (int) (Endtime.getDate() - Starttime.getDate()), length);
			this.setLocation(width * (Starttime.getDay() - 1) + gap, startY);
		}
		*/
		
		if (Endtime.getDate() == Starttime.getDate()) {
			PositionX = width * (Starttime.getDay() - 1) + gap;
			PositionY = (length / 24) * Starttime.getHours();
			
			SizeX = width - (2 * gap);
			SizeY = (length / 24) * (int) ((Endtime.getTime() - Starttime.getTime())/(1000 * 60 * 60));
		} else {
			SizeX = width - (2 * gap) * (int) (Endtime.getDate() - Starttime.getDate());
			SizeY = length;
			
			PositionX = width * (Starttime.getDay() - 1) + gap;
			PositionY = startY;
		}
		
		if (SizeY<60) {
			SizeY = 60;
		}

	}
	
	public void printData() {
		System.out.println("strings"); 
		System.out.println("StartTime " + StartTime);
		System.out.println("StartDate " + StartDate);
		System.out.println(EndTime);
		System.out.println(EndDate);
		
		System.out.println("Dates"); 
		System.out.println("Starttime: " + Starttime);
		System.out.println("Endtime: "+ Endtime);
		 
	}
	
	public void delete() {

		PositionX = 0;
		PositionY = 0;
		
		SizeX = 0;
		SizeY = 0;
		
		LTitle.setText(null);
		LTime.setText(null);
		LLocation.setText(null);
		LDescription.setText(null);
	}

}
