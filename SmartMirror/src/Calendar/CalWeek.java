package Calendar;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Config.Configuration;

public class CalWeek extends JPanel {
	private static final long serialVersionUID = 1L;

	Configuration prop;
	CalConfig CalData;

	JPanel[] Weekday = new JPanel[7];
	JPanel[] Frame = new JPanel[7];
	JLabel[] Days = new JLabel[7];
	JLabel[] Dates = new JLabel[7];
	String[] Names = { "Mo", "Di", "Mi", "Do", "Fr", "Sa", "So" };
	Date[] Week = new Date[7];

	int Anzahl;
	CalEntry[] Event = new CalEntry[200];

	Date Monday;
	Date Today;
	long day = 1000 * 60 * 60 * 24;

	int WeekShown = 0;

	SimpleDateFormat FormatWeekday = new SimpleDateFormat("EE");
	SimpleDateFormat FormatShort = new SimpleDateFormat("dd.MM");

	int width = 100;

	public CalWeek() {
		prop = new Configuration();
		CalData = new CalConfig();

		Anzahl = Integer.parseInt(CalData.getProperty("Anzahl"));

		this.setBackground(null);
		this.setLayout(null);

		for (int i = 0; i < 7; i++) {
			Weekday[i] = new JPanel();
			Weekday[i].setLayout(null);
			Weekday[i].setSize(width, 720);
			Weekday[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
			Weekday[i].setLocation(i * width, 50);
			Weekday[i].setVisible(true);
			Weekday[i].setForeground(null);
			Weekday[i].setBackground(null);
			this.add(Weekday[i]);
			this.setComponentZOrder(Weekday[i], 0);

			Frame[i] = new JPanel();
			Frame[i].setSize(width, 50);
			Frame[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
			Frame[i].setLocation(i * width, 0);
			Frame[i].setVisible(true);
			Frame[i].setForeground(null);
			Frame[i].setBackground(null);
			this.add(Frame[i]);
			this.setComponentZOrder(Frame[i], 0);

			Days[i] = new JLabel();
			Days[i].setSize(width, 50);
			Days[i].setLocation(10, 0);
			Days[i].setVisible(true);
			Days[i].setForeground(Color.white);
			Days[i].setBackground(null);
			Days[i].setText(Names[i]);
			Days[i].setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
					Integer.parseInt(prop.getProperty("WeekdaySchriftgroesse"))));
			Frame[i].add(Days[i]);

			Dates[i] = new JLabel();
			Dates[i].setSize(width, 50);
			Dates[i].setLocation(10, 0);
			Dates[i].setVisible(true);
			Dates[i].setForeground(Color.white);
			Dates[i].setBackground(null);
			Dates[i].setText("XXX");
			Dates[i].setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
					Integer.parseInt(prop.getProperty("WeekdaySchriftgroesse"))));
			Frame[i].add(Dates[i]);

		}

		for (int i = 0; i < 200; i++) {
			Event[i] = new CalEntry(i);
			this.add(Event[i]);
			Event[i].setVisible(false);
		}
		
		for (int i = 0; i < Anzahl; i++) {
			Event[i].getData();
			Event[i].setAppearanceWeek();
			Event[i].setSize(Event[i].SizeX, Event[i].SizeY);
			Event[i].setLocation(Event[i].PositionX, Event[i].PositionY);
			this.setComponentZOrder(Event[i], 1);
		}
		
		setWeek();
		setEvents();
	}

	void setEvents() {
		Today = new Date();
		for (int n = 0; n < Anzahl; n++) {
			Event[n].setVisible(false);
		}
		
		for (int i = 0; i < 7; i++) {
			if (compare(Week[i], Today)) {
				Days[i].setForeground(Color.green);
				Dates[i].setForeground(Color.green);
			} else {
				Days[i].setForeground(Color.white);
				Dates[i].setForeground(Color.white);
			}
			for (int n = 0; n < Anzahl; n++) {
				if (compare(Week[i], Event[n].Starttime)) {
					Event[n].setVisible(true);
					Event[i].setAppearanceWeek();
					Event[i].setSize(Event[i].SizeX, Event[i].SizeY);
					Event[i].setLocation(Event[i].PositionX, Event[i].PositionY);
					this.setComponentZOrder(Event[i], 1);
				}
			}
		}
	}

	public void setWeek() {
		Today = new Date();
		Date Timestamp = new Date(Today.getTime() + (WeekShown * 7 * day));
		String DayOfTheWeek = FormatWeekday.format(Timestamp).toString();

		switch (DayOfTheWeek) {
		case "Mo":
			Monday = new Date(Timestamp.getTime());
			break;
		case "Di":
			Monday = new Date(Timestamp.getTime() - day);
			break;
		case "Mi":
			Monday = new Date(Timestamp.getTime() - (2 * day));
			break;
		case "Do":
			Monday = new Date(Timestamp.getTime() - (3 * day));
			break;
		case "Fr":
			Monday = new Date(Timestamp.getTime() - (4 * day));
			break;
		case "Sa":
			Monday = new Date(Timestamp.getTime() - (5 * day));
			break;
		case "So":
			Monday = new Date(Timestamp.getTime() - (6 * day));
			break;
		default:
			Monday = new Date();
		}
		for (int i = 0; i < 7; i++) {
			Week[i] = new Date(Monday.getTime() + (i * day));
			Dates[i].setText(FormatShort.format(Week[i]).toString());
		}
	}

	@SuppressWarnings("deprecation")
	public boolean compare(Date Today, Date Event) {
		boolean istoday;
		if (Today.getYear() != Event.getYear()) {
			istoday = false;
		} else if (Today.getMonth() != Event.getMonth()) {
			istoday = false;
		} else if (Today.getDate() != Event.getDate()) {
			istoday = false;
		} else {
			istoday = true;
		}
		return istoday;
	}

	public void nextWeek() {
		WeekShown++;
		setWeek();
		setEvents();
	}

	public void lastWeek() {
		WeekShown--;
		setWeek();
		setEvents();
	}

	public void presentWeek() {
		WeekShown = 0;
		setWeek();
		setEvents();
	}

	public void refresh() {
		CalData = new CalConfig();
		Anzahl = Integer.parseInt(CalData.getProperty("Anzahl"));
		for (int i = 0; i < 200; i++) {
			Event[i].delete();
			Event[i].setVisible(false);
		}

		for (int i = 0; i < Anzahl; i++) {
			Event[i].getData();
			Event[i].setAppearanceWeek();
			Event[i].setSize(Event[i].SizeX, Event[i].SizeY);
			Event[i].setLocation(Event[i].PositionX, Event[i].PositionY);
			this.setComponentZOrder(Event[i], 1);
		}
		
		setWeek();
		setEvents();
	}

}
