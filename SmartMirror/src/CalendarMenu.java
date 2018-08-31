import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarMenu extends JPanel {

	private static final long serialVersionUID = 1L;

	Configuration prop;

	Clock clock;
	JLabel Titel;

	public CalendarMenu() {
		prop = new Configuration();

		this.setBackground(new Color(Integer.parseInt(prop.getProperty("Background"))));
		this.setLayout(null);

		clock = new Clock("small");
		
		// Zeit einfügen
		this.add(clock);
		clock.setSize(Integer.parseInt(prop.getProperty("PanelClockSmallSizeX")),
				Integer.parseInt(prop.getProperty("PanelClockSmallSizeY")));
		clock.setLocation(Integer.parseInt(prop.getProperty("PanelClockSmallPosX")),
				Integer.parseInt(prop.getProperty("PanelClockSmallPosY")));
		clock.setVisible(Boolean.parseBoolean(prop.getProperty("PanelClockSmallVisible")));

		Titel = new JLabel();
		this.add(Titel);
		Titel.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("TitelSchriftgroesse"))));
		Titel.setSize(Integer.parseInt(prop.getProperty("TitelSizeX")),
				Integer.parseInt(prop.getProperty("TitelSizeY")));
		Titel.setLocation(Integer.parseInt(prop.getProperty("TitelPosX")),
				Integer.parseInt(prop.getProperty("TitelPosY")));
		Titel.setVisible(Boolean.parseBoolean(prop.getProperty("TitelVisible")));
		Titel.setForeground(new Color(Integer.parseInt(prop.getProperty("TitelColor"))));
		Titel.setText("Kalender");
	
	}

	public void start() {
		clock.start();
	
		this.setVisible(true);
	}

	public void stop() {
		clock.stop();
	
		this.setVisible(false);
	}
}
