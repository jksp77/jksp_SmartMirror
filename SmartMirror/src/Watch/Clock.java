package Watch;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;

import Config.Configuration;

public class Clock extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	Thread ThreadClock;
	Configuration prop;

	Time time;
	Datum date;

	public Clock(String Size) {


		if (Size == "small") {

			prop = new Configuration();
			time = new Time("small");
			date = new Datum();
			
			this.setBackground(new Color(Integer.parseInt(prop.getProperty("PanelClockSmallColor"))));
			this.setLayout(null);
			this.setVisible(Boolean.parseBoolean(prop.getProperty("PanelClockSmallVisible")));

			this.add(time);
			time.setSize(Integer.parseInt(prop.getProperty("ZeitSmallSizeX")),
					Integer.parseInt(prop.getProperty("ZeitSmallSizeY")));
			time.setLocation(Integer.parseInt(prop.getProperty("ZeitSmallPosX")),
					Integer.parseInt(prop.getProperty("ZeitSmallPosY")));
			time.setVisible(true);

			this.add(date);
			Font fontDatum = new Font( prop.getProperty("Schriftart"), Font.PLAIN, Integer.parseInt(prop.getProperty("DatumSmallSchriftgroesse")));
			date.setFont(fontDatum);
			date.setSize(Integer.parseInt(prop.getProperty("DatumSmallSizeX")),
					Integer.parseInt(prop.getProperty("DatumSmallSizeY")));
			date.setLocation(Integer.parseInt(prop.getProperty("DatumSmallPosX")),
					Integer.parseInt(prop.getProperty("DatumSmallPosY")));
			date.setVisible(true);
			date.DatumFormat = new SimpleDateFormat(prop.getProperty("DatumSmallFormat"));
			

		} else {
			
			prop = new Configuration();
			time = new Time("big");
			date = new Datum();

			this.setBackground(new Color(Integer.parseInt(prop.getProperty("PanelClockColor"))));
			this.setLayout(null);
			this.setVisible(Boolean.parseBoolean(prop.getProperty("PanelClockVisible")));

			this.add(time);
			time.setSize(Integer.parseInt(prop.getProperty("ZeitSizeX")),
					Integer.parseInt(prop.getProperty("ZeitSizeY")));
			time.setLocation(Integer.parseInt(prop.getProperty("ZeitPosX")),
					Integer.parseInt(prop.getProperty("ZeitPosY")));
			time.setVisible(true);

			this.add(date);
			date.setSize(Integer.parseInt(prop.getProperty("DatumSizeX")),
					Integer.parseInt(prop.getProperty("DatumSizeY")));
			date.setLocation(Integer.parseInt(prop.getProperty("DatumPosX")),
					Integer.parseInt(prop.getProperty("DatumPosY")));
			date.setVisible(true);
		}

		start();
	}

	public void start() {
		if (ThreadClock == null) {
			ThreadClock = new Thread(this);
			ThreadClock.start();
		}
	}

	@SuppressWarnings("deprecation")
	public void stop() {
		if (ThreadClock != null) {
			ThreadClock.stop();
			ThreadClock = null;
		}

	}

	public void run() {
		while (true) {
			time.getTime();
			date.getDate();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
