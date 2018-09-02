package Calendar;

import java.awt.Color;
import java.awt.Dimension;
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
	
	
	JLabel LTitle;
	JLabel LTime;
	JLabel LLocation;
	JLabel LDescription;
	

	public CalEntry(int i) {
		prop = new Configuration();
		CalData = new CalConfig();

		
		index = i;
		
		LTitle = new JLabel();
		LTime = new JLabel();
		LLocation = new JLabel();
		LDescription = new JLabel();
		
		getData();

		setAppearance();

	}

	void getData() {
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

		System.out.println("strings");
		System.out.println("StartTime " + StartTime);
		System.out.println("StartDate " + StartDate);
		System.out.println(EndTime);
		System.out.println(EndDate);

		StartTime = StartTime.substring(0, Math.min(StartTime.length(), 19));
		EndTime = EndTime.substring(0, Math.min(EndTime.length(), 19));
		
		SimpleDateFormat TimeFormat = new SimpleDateFormat(prop.getProperty("CalZeitFormat"));
		SimpleDateFormat TimeFormat2 = new SimpleDateFormat(prop.getProperty("CalZeitFormat2"));


		try {
			Starttime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(StartTime); // THH:mm:ss
			Endtime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(EndTime);
			LTime.setText(TimeFormat.format(Starttime).toString()+ " - \n"+TimeFormat.format(Endtime).toString());
				
		} catch (ParseException e) {
			StartTime = StartDate + "T00:00:00";
			EndTime = EndDate + "T00:00:00";
			try {
				Starttime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(StartTime);
				Endtime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(EndTime);
				LTime.setText(TimeFormat2.format(Starttime).toString()+ " - \n"+TimeFormat2.format(Endtime).toString());
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
	
	void setAppearance() {
		this.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1,Foreground));
		
		Timestamp = new Date();
		SimpleDateFormat Format = new SimpleDateFormat("EE");
		System.out.println(Format.format(Timestamp).toString());
		
		
	}

}
