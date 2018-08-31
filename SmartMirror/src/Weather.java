import java.awt.Color;
import javax.swing.JPanel;

public class Weather extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private Thread ThreadWeather;
	Configuration prop;
	
	WeatherToday Today;
	Weatherforecast Forecast;

	 
	public Weather() {
		prop = new Configuration();
		Today = new WeatherToday();
		Forecast = new Weatherforecast();
		
		this.setBackground(new Color(Integer.parseInt(prop.getProperty("PanelWeatherColor"))));
		this.setLayout(null);
		this.setVisible(Boolean.parseBoolean(prop.getProperty("PanelWeatherVisible")));
		
		this.add(Today);
		Today.setSize(Integer.parseInt(prop.getProperty("PanelHeuteSizeX")),Integer.parseInt(prop.getProperty("PanelHeuteSizeY")));
		Today.setLocation(Integer.parseInt(prop.getProperty("PanelHeutePosX")),Integer.parseInt(prop.getProperty("PanelHeutePosY")));
		Today.setVisible(Boolean.parseBoolean(prop.getProperty("PanelHeuteVisible")));
		
		
		
		this.add(Forecast);
		Forecast.setSize(Integer.parseInt(prop.getProperty("PanelForecastSizeX")),Integer.parseInt(prop.getProperty("PanelForecastSizeY")));
		Forecast.setLocation(Integer.parseInt(prop.getProperty("PanelForecastPosX")),Integer.parseInt(prop.getProperty("PanelForecastPosY")));
		Forecast.setVisible(Boolean.parseBoolean(prop.getProperty("PanelForecastVisible")));
		
		start();
	}

	public void start() {
		if (ThreadWeather == null) {
			ThreadWeather = new Thread(this);
			ThreadWeather.start();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void stop() {
		if (ThreadWeather != null) {
			ThreadWeather.stop();
			ThreadWeather = null;
			}
		}

	public void run() {
			while (true) {
			Forecast.writeWeatherForecast();
			Today.writeWeatherToday();

			Forecast.getWeatherForecast();
			Today.getWeatherToday();
			try {
				Thread.sleep(Integer.parseInt(prop.getProperty("UpdateTime")));
			} catch (InterruptedException e) {
				e.printStackTrace(); 
			}
		}
	}
}
