package Calendar;

import java.awt.Dimension;
import java.awt.Point;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;

import Config.Configuration;
import Main.SmartMirror;

public class CalEntry extends JPanel { 
	private static final long serialVersionUID = 1L;
	
	Configuration prop;
	CalConfig CalData;
	
	String Title;
	String Location;
	String Description;
	
	String StartTime;
	String StartDate;
	String EndTime;
	String EndDate;
	Date Starttime;
	Date Endtime;
	Dimension Size;
	Point StartPoint;
	
	
	int index;

public CalEntry(int i) {
	prop = new Configuration();
	CalData = new CalConfig();
		
	SimpleDateFormat TimeFormat = new SimpleDateFormat(prop.getProperty("CalZeitFormat"));
	SimpleDateFormat TimeFormat2 = new SimpleDateFormat(prop.getProperty("CalZeitFormat2"));
	
	index = i;
	
	getData();
	
	System.out.println(TimeFormat.format(Starttime).toString());
	System.out.println(TimeFormat2.format(Starttime).toString());
	
	System.out.println(TimeFormat.format(Endtime).toString());
	System.out.println(TimeFormat2.format(Endtime).toString());
	
	}

void getData() {
	Title = CalData.getProperty("title" + index);
	
	Location = CalData.getProperty("location" + index);
	if(Location == "None") {
		Location = "";
	}
	Description = CalData.getProperty("description" + index);
	if(Description == "None") {
		Description = "";
	}
	
	StartTime = CalData.getProperty("stime" + index);
	StartDate = CalData.getProperty("sdate" + index);
	EndTime = CalData.getProperty("etime" + index);
	EndDate = CalData.getProperty("edate" + index);
	
	if(StartTime == "None") {
		StartTime = StartDate + "T00:00:00";
		EndTime = EndDate + "T00:00:00";
	}else {
		StartTime = StartTime.substring(19);
		EndTime = EndTime.substring(19);
	}
	
	try {
		Starttime = new SimpleDateFormat("yyyy-MM-ddTHH:mm:ss").parse(StartTime);
		Endtime = new SimpleDateFormat("yyyy-MM-ddTHH:mm:ss").parse(EndTime);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}
public static void main(String[] args) {

	CalEntry Entry = new CalEntry(1);
	
}

}
