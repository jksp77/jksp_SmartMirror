import java.awt.Color;
import javax.swing.JPanel;

public class HomeMenu extends JPanel {

	private static final long serialVersionUID = 1L;

	Configuration prop;

	Clock clock;
	Weather weather;

	public HomeMenu() {
		prop = new Configuration();

		this.setBackground(new Color(Integer.parseInt(prop.getProperty("Background"))));
		this.setLayout(null);

		clock = new Clock("big");
		weather = new Weather();

		// Zeit einfügen
		this.add(clock);
		clock.setSize(Integer.parseInt(prop.getProperty("PanelClockSizeX")),
				Integer.parseInt(prop.getProperty("PanelClockSizeY")));
		clock.setLocation(Integer.parseInt(prop.getProperty("PanelClockPosX")),
				Integer.parseInt(prop.getProperty("PanelClockPosY")));
		clock.setVisible(Boolean.parseBoolean(prop.getProperty("PanelClockVisible")));

		// Wetter einfügen
		this.add(weather);
		weather.setSize(Integer.parseInt(prop.getProperty("PanelWeatherSizeX")),
				Integer.parseInt(prop.getProperty("PanelWeatherSizeY")));
		weather.setLocation(Integer.parseInt(prop.getProperty("PanelWeatherPosX")),
				Integer.parseInt(prop.getProperty("PanelWeatherPosY")));
		weather.setVisible(Boolean.parseBoolean(prop.getProperty("PanelWeatherVisible")));

	}

	public void start() {
		clock.start();
		weather.start();
		this.setVisible(true);
	}

	public void stop() {
		clock.stop();
		weather.stop();
		this.setVisible(false);
	}
}
