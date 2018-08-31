import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class SmartMirror extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	Configuration prop;

	HomeMenu PHome;
	CalendarMenu PCalendar;
	MailMenu PMail;
	SettingsMenu PSettings;
	WeatherMenu PWeather;
	public String Menu = "Home";

	MenuIcons icons;

	public SmartMirror() {

		prop = new Configuration();

		PHome = new HomeMenu();
		PCalendar = new CalendarMenu();
		PMail = new MailMenu();
		PSettings = new SettingsMenu();
		PWeather = new WeatherMenu();

		icons = new MenuIcons(Menu);

		addKeyListener(this);

		// Fenster erstellen
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setLayout(null);
		this.setCursor(this.getToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB),
				new Point(), null));


		this.add(icons);
		icons.setSize(Integer.parseInt(prop.getProperty("PanelIconsSizeX")),
				Integer.parseInt(prop.getProperty("PanelIconsSizeY")));
		icons.setLocation((int) (d.getWidth() - Integer.parseInt(prop.getProperty("PanelIconsSizeX"))),
				Integer.parseInt(prop.getProperty("PanelIconsLocationY")));
		icons.setVisible(Boolean.parseBoolean(prop.getProperty("PanelIconsVisible")));

		this.add(PHome);
		PHome.setLocation(0, 0);
		PHome.setSize((int) (d.getWidth() - Integer.parseInt(prop.getProperty("PanelIconsSizeX"))),
				(int) d.getHeight());
		PHome.setVisible(true);

		this.add(PCalendar);
		PCalendar.setLocation(0, 0);
		PCalendar.setSize((int) (d.getWidth() - Integer.parseInt(prop.getProperty("PanelIconsSizeX"))),
				(int) d.getHeight());
		PCalendar.setVisible(false);
		
		this.add(PMail);
		PMail.setLocation(0, 0);
		PMail.setSize((int) (d.getWidth() - Integer.parseInt(prop.getProperty("PanelIconsSizeX"))),
				(int) d.getHeight());
		PMail.setVisible(false);
		
		this.add(PSettings);
		PSettings.setLocation(0, 0);
		PSettings.setSize((int) (d.getWidth() - Integer.parseInt(prop.getProperty("PanelIconsSizeX"))),
				(int) d.getHeight());
		PSettings.setVisible(false);
		
		this.add(PWeather);
		PWeather.setLocation(0, 0);
		PWeather.setSize((int) (d.getWidth() - Integer.parseInt(prop.getProperty("PanelIconsSizeX"))),
				(int) d.getHeight());
		PWeather.setVisible(false);
		
		openMenu("Home");

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			PHome.stop();
			PCalendar.stop();
			System.exit(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_1) {
			switch (Menu) {
			case "Home":
				openMenu("Calendar");
				break;
			case "Calendar":
				;
				break;
			case "Mail":

				break;
			case "Settings":

				break;

			}
		}
		if (e.getKeyCode() == KeyEvent.VK_2) {
			switch (Menu) {
			case "Home":
				openMenu("Mail");
				break;
			case "Calendar":

				break;
			case "Mail":

				break;
			case "Settings":

				break;

			}
		}
		if (e.getKeyCode() == KeyEvent.VK_3) {
			switch (Menu) {
			case "Home":
				openMenu("Weather");
				break;
			case "Calendar":

				break;
			case "Mail":

				break;
			case "Settings":

				break;

			}
		}
		if (e.getKeyCode() == KeyEvent.VK_4) {
			switch (Menu) {
			case "Home":
				openMenu("Settings");
				break;
			case "Calendar":

				break;
			case "Mail":

				break;
			case "Settings":

				break;
			case "Weather":
				PSettings.stop();
				break;

			}
		}
		if (e.getKeyCode() == KeyEvent.VK_5) {
			openMenu("Home");
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void openMenu(String Men) {

		switch (Men) {
		case "Home":
			PHome.start();
			PCalendar.stop();
			PMail.stop();
			PSettings.stop();
			PWeather.stop();

			break;

		case "Calendar":
			PCalendar.start();
			PHome.stop();
			PMail.stop();
			PSettings.stop();
			PWeather.stop();
			
			break;

		case "Mail":
			PMail.start();
			PCalendar.stop();
			PHome.stop();
			PSettings.stop();
			PWeather.stop();
			
			break;
			
		case "Weather":
			PWeather.start();
			PMail.stop();
			PCalendar.stop();
			PHome.stop();
			PSettings.stop();
			
			break;

		case "Settings":
			PSettings.start();
			PCalendar.stop();
			PHome.stop();
			PMail.stop();
			PWeather.stop();

			break;

		}
		
		icons.setIcons(Men);
		Menu = Men;

	}

	public static void main(String[] args) {

		new SmartMirror();
	}

}
