package Config;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import Main.SmartMirror;

/*Hilfe
 * 
 Color: 
 Color c = new Color(Integer.parseInt(colorS));  
String colorS = Integer.toString(myColor.getRGB());
 
Boolean: 
Boolean.toString(var);
 * 
 * 
 * 
 * 
 */

public class Configuration extends Properties {
	private static final long serialVersionUID = 1L;
	Properties prop = new Properties();
	OutputStream output = null;
//InputStream input = null;

	InputStream input = SmartMirror.class.getResourceAsStream("/config.properties");

// Configurationsdaten
	String Schriftart = "Verdana";

//Datum & Zeit
	String DatumFormat = "EEE dd.MMMM";
	int DatumSchriftgroesse = 60;
	int DatumPosX = 10;
	int DatumPosY = 150;
	Color DatumColor = Color.white;

	String ZeitFormat = "HH:mm:ss";
	int ZeitSchriftgroesse = 120;
	int ZeitPosX = 10;
	int ZeitPosY = 150;
	Color ZeitColor = Color.green;

// Wetter

	String City = "Luzern";

// Heute

	String ApiKeyHeute = "e819511b990c4f96be4183627183107";

	int PanelHeutePosX = 10;
	int PanelHeutePosY = 350;
	int PanelHeuteSizeX = 600;
	int PanelHeuteSizeY = 170;
	boolean PanelHeuteVisible = true;
	Color PanelHeuteColor = Color.black;

	int TempHeuteSchriftgroesse = 50;
	int TempHeutePosX = 150;
	int TempHeutePosY = 0;
	int TempHeuteSizeX = 500;
	int TempHeuteSizeY = 62;

	boolean TempHeuteVisible = true;
	Color TempHeuteColor = Color.white;

	int PrecipHeuteSchriftgroesse = 50;
	int PrecipHeutePosX = 0;
	int PrecipHeutePosY = 130;
	int PrecipHeuteSizeX = 500;
	int PrecipHeuteSizeY = 62;
	boolean PrecipHeuteVisible = true;
	Color PrecipHeuteColor = Color.white;

	int UpdatedSchriftgroesse = 15;
	int UpdatedPosX = 150;
	int UpdatedPosY = 50;
	int UpdatedSizeX = 500;
	int UpdatedSizeY = 62;
	boolean UpdatedVisible = true;
	Color UpdatedColor = Color.white;

	int IconHeutePosX = 0;
	int IconHeutePosY = 0;
	int IconHeuteSize = 150;
	int IconHeuteSizeX = 150;
	int IconHeuteSizeY = 150;
	boolean IconHeuteVisible = true;

//Forecast
	String ApiKeyForecast = "e819511b990c4f96be4183627183107";

	int PanelForecastPosX = 10;
	int PanelForecastPosY = 600;
	int PanelForecastSizeX = 600;
	int PanelForecastSizeY = 170;
	boolean PanelForecastVisible = true;
	Color PanelForecastColor = Color.black;

	int TempAvgSchriftgroesse = 30;
	boolean TempAvgVisible = true;
	Color TempAvgColor = Color.white;
	int TempAvgSizeX = 500;
	int TempAvgSizeY = 30;

	int TempMMSchriftgroesse = 12;
	boolean TempMMVisible = true;
	Color TempMMColor = Color.white;
	int TempMMSizeX = 500;
	int TempMMSizeY = 30;

	int PrecipSchriftgroesse = 12;
	boolean PrecipVisible = true;
	Color PrecipColor = Color.white;
	int PrecipSizeX = 500;
	int PrecipSizeY = 30;

	int DaySchriftgroesse = 20;
	boolean DayVisible = true;
	Color DayColor = Color.green;
	int DaySizeX = 500;
	int DaySizeY = 30;

	int IconSize = 64;
	int IconSizeX = 64;
	int IconSizeY = 64;
	boolean IconVisible = true;

//Day0
	int TempAvgD0PosX = 150;
	int TempAvgD0PosY = 0;

	int TempMMD0PosX = 150;
	int TempMMD0PosY = 0;

	int PrecipD0PosX = 0;
	int PrecipD0PosY = 130;

	int Day0PosX = 150;
	int Day0PosY = 50;

	int IconD0PosX = 0;
	int IconD0PosY = 0;

//Day1
	int TempAvgD1PosX = 150;
	int TempAvgD1PosY = 0;

	int TempMMD1PosX = 150;
	int TempMMD1PosY = 0;

	int PrecipD1PosX = 0;
	int PrecipD1PosY = 130;

	int Day1PosX = 150;
	int Day1PosY = 50;

	int IconD1PosX = 0;
	int IconD1PosY = 0;

// Day 2	
	int TempAvgD2PosX = 150;
	int TempAvgD2PosY = 0;

	int TempMMD2PosX = 150;
	int TempMMD2PosY = 0;

	int PrecipD2PosX = 0;
	int PrecipD2PosY = 130;

	int Day2PosX = 150;
	int Day2PosY = 50;

	int IconD2PosX = 0;
	int IconD2PosY = 0;

	public Configuration() {

		try {

			// load a properties file
			this.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public void setConfiguration() {

		try {

			output = new FileOutputStream("resources/config.properties");

			// set the properties value
			prop.setProperty("Schriftart", Schriftart);

		
			// Wetter

			prop.setProperty("City", City);

			// Heute

			prop.setProperty("ApiKeyHeute", ApiKeyHeute);

			prop.setProperty("PanelHeutePosX", Integer.toString(PanelHeutePosX));
			prop.setProperty("PanelHeutePosY", Integer.toString(PanelHeutePosY));
			prop.setProperty("PanelHeuteSizeX", Integer.toString(PanelHeuteSizeX));
			prop.setProperty("PanelHeuteSizeY", Integer.toString(PanelHeuteSizeY));
			prop.setProperty("PanelHeuteVisible", Boolean.toString(PanelHeuteVisible));
			prop.setProperty("PanelHeuteColor", Integer.toString(PanelHeuteColor.getRGB()));

			prop.setProperty("TempHeuteSchriftgroesse", Integer.toString(TempHeuteSchriftgroesse));
			prop.setProperty("TempHeutePosX", Integer.toString(TempHeutePosX));
			prop.setProperty("TempHeutePosY", Integer.toString(TempHeutePosY));
			prop.setProperty("TempHeuteSizeX", Integer.toString(TempHeuteSizeX));
			prop.setProperty("TempHeuteSizeY", Integer.toString(TempHeuteSizeY));

			prop.setProperty("TempHeuteVisible", Boolean.toString(TempHeuteVisible));
			prop.setProperty("TempHeuteColor", Integer.toString(TempHeuteColor.getRGB()));

			prop.setProperty("PrecipHeuteSchriftgroesse", Integer.toString(PrecipHeuteSchriftgroesse));
			prop.setProperty("PrecipHeutePosX", Integer.toString(PrecipHeutePosX));
			prop.setProperty("PrecipHeutePosY", Integer.toString(PrecipHeutePosY));
			prop.setProperty("PrecipHeuteSizeX", Integer.toString(PrecipHeuteSizeX));
			prop.setProperty("PrecipHeuteSizeY", Integer.toString(PrecipHeuteSizeY));
			prop.setProperty("PrecipHeuteVisible", Boolean.toString(PrecipHeuteVisible));
			prop.setProperty("PrecipHeuteColor", Integer.toString(PrecipHeuteColor.getRGB()));

			prop.setProperty("UpdatedSchriftgroesse", Integer.toString(UpdatedSchriftgroesse));
			prop.setProperty("UpdatedPosX", Integer.toString(UpdatedPosX));
			prop.setProperty("UpdatedPosY", Integer.toString(UpdatedPosY));
			prop.setProperty("UpdatedSizeX", Integer.toString(UpdatedSizeX));
			prop.setProperty("UpdatedSizeY", Integer.toString(UpdatedSizeY));
			prop.setProperty("UpdatedVisible", Boolean.toString(UpdatedVisible));
			prop.setProperty("UpdatedColor", Integer.toString(UpdatedColor.getRGB()));

			prop.setProperty("IconHeutePosX", Integer.toString(IconHeutePosX));
			prop.setProperty("IconHeutePosY", Integer.toString(IconHeutePosY));
			prop.setProperty("IconHeuteSize", Integer.toString(IconHeuteSize));
			prop.setProperty("IconHeuteSizeX", Integer.toString(IconHeuteSizeX));
			prop.setProperty("IconHeuteSizeY", Integer.toString(IconHeuteSizeY));
			prop.setProperty("IconHeuteVisible", Boolean.toString(IconHeuteVisible));

			// Forecast
			prop.setProperty("ApiKeyForecast", ApiKeyForecast);

			prop.setProperty("PanelForecastPosX", Integer.toString(PanelForecastPosX));
			prop.setProperty("PanelForecastPosY", Integer.toString(PanelForecastPosY));
			prop.setProperty("PanelForecastSizeX", Integer.toString(PanelForecastSizeX));
			prop.setProperty("PanelForecastSizeY", Integer.toString(PanelForecastSizeY));
			prop.setProperty("PanelForecastVisible", Boolean.toString(PanelForecastVisible));
			prop.setProperty("PanelForecastColor", Integer.toString(PanelForecastColor.getRGB()));

			prop.setProperty("TempAvgSchriftgroesse", Integer.toString(TempAvgSchriftgroesse));
			prop.setProperty("TempAvgVisible", Boolean.toString(TempAvgVisible));
			prop.setProperty("TempAvgColor", Integer.toString(TempAvgColor.getRGB()));
			prop.setProperty("TempAvgSizeX", Integer.toString(TempAvgSizeX));
			prop.setProperty("TempAvgSizeY", Integer.toString(TempAvgSizeY));

			prop.setProperty("TempMMSchriftgroesse", Integer.toString(TempMMSchriftgroesse));
			prop.setProperty("TempMMVisible", Boolean.toString(TempMMVisible));
			prop.setProperty("TempMMColor", Integer.toString(TempMMColor.getRGB()));
			prop.setProperty("TempMMSizeX", Integer.toString(TempMMSizeX));
			prop.setProperty("TempMMSizeY", Integer.toString(TempMMSizeY));

			prop.setProperty("PrecipSchriftgroesse", Integer.toString(PrecipSchriftgroesse));
			prop.setProperty("PrecipVisible", Boolean.toString(PrecipVisible));
			prop.setProperty("PrecipColor", Integer.toString(PrecipColor.getRGB()));
			prop.setProperty("PrecipSizeX", Integer.toString(PrecipSizeX));
			prop.setProperty("PrecipSizeY", Integer.toString(PrecipSizeY));

			prop.setProperty("DaySchriftgroesse", Integer.toString(DaySchriftgroesse));
			prop.setProperty("DayVisible", Boolean.toString(DayVisible));
			prop.setProperty("DayColor", Integer.toString(DayColor.getRGB()));
			prop.setProperty("DaySizeX", Integer.toString(DaySizeX));
			prop.setProperty("DaySizeY", Integer.toString(DaySizeY));

			prop.setProperty("IconSize", Integer.toString(IconSize));
			prop.setProperty("IconSizeX", Integer.toString(IconSizeX));
			prop.setProperty("IconSizeY", Integer.toString(IconSizeY));
			prop.setProperty("IconVisible", Boolean.toString(IconVisible));

			// Day0
			prop.setProperty("TempAvgD0PosX", Integer.toString(TempAvgD0PosX));
			prop.setProperty("TempAvgD0PosY", Integer.toString(TempAvgD0PosY));

			prop.setProperty("TempMMD0PosX", Integer.toString(TempMMD0PosX));
			prop.setProperty("TempMMD0PosY", Integer.toString(TempMMD0PosY));

			prop.setProperty("PrecipD0PosX", Integer.toString(PrecipD0PosX));
			prop.setProperty("PrecipD0PosY", Integer.toString(PrecipD0PosY));

			prop.setProperty("Day0PosX", Integer.toString(Day0PosX));
			prop.setProperty("Day0PosY", Integer.toString(Day0PosY));

			prop.setProperty("IconD0PosX", Integer.toString(IconD0PosX));
			prop.setProperty("IconD0PosY", Integer.toString(IconD0PosY));

			// Day1
			prop.setProperty("TempAvgD1PosX", Integer.toString(TempAvgD1PosX));
			prop.setProperty("TempAvgD1PosY", Integer.toString(TempAvgD1PosY));

			prop.setProperty("TempMMD1PosX", Integer.toString(TempMMD1PosX));
			prop.setProperty("TempMMD1PosY", Integer.toString(TempMMD1PosY));

			prop.setProperty("PrecipD1PosX", Integer.toString(PrecipD1PosX));
			prop.setProperty("PrecipD1PosY", Integer.toString(PrecipD1PosY));

			prop.setProperty("Day1PosX", Integer.toString(Day1PosX));
			prop.setProperty("Day1PosY", Integer.toString(Day1PosY));

			prop.setProperty("IconD1PosX", Integer.toString(IconD1PosX));
			prop.setProperty("IconD1PosY", Integer.toString(IconD1PosY));

			// Day 2
			prop.setProperty("TempAvgD2PosX", Integer.toString(TempAvgD2PosX));
			prop.setProperty("TempAvgD2PosY", Integer.toString(TempAvgD2PosY));

			prop.setProperty("TempMMD2PosX", Integer.toString(TempMMD2PosX));
			prop.setProperty("TempMMD2PosY", Integer.toString(TempMMD2PosY));

			prop.setProperty("PrecipD2PosX", Integer.toString(PrecipD2PosX));
			prop.setProperty("PrecipD2PosY", Integer.toString(PrecipD2PosY));

			prop.setProperty("Day2PosX", Integer.toString(Day2PosX));
			prop.setProperty("Day2PosY", Integer.toString(Day2PosY));

			prop.setProperty("IconD2PosX", Integer.toString(IconD2PosX));
			prop.setProperty("IconD2PosY", Integer.toString(IconD2PosY));

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	void getConfiguration() {

		try {

			// input = Configuration.class.getResource("/config.properties");

			// load a properties file
			prop.load(input);

			// get the property value

			// set the properties value
			Schriftart = prop.getProperty("Schriftart");
			
			// Wetter

			City = prop.getProperty("City");

			// Heute

	

		


		

			// Forecast);
			ApiKeyForecast = prop.getProperty("ApiKeyForecast");

			PanelForecastPosX = Integer.parseInt(prop.getProperty("PanelForecastPosX"));
			PanelForecastPosY = Integer.parseInt(prop.getProperty("PanelForecastPosY"));
			PanelForecastSizeX = Integer.parseInt(prop.getProperty("PanelForecastSizeX"));
			PanelForecastSizeY = Integer.parseInt(prop.getProperty("PanelForecastSizeY"));
			PanelForecastVisible = Boolean.parseBoolean(prop.getProperty("PanelForecastVisible"));
			PanelForecastColor = new Color(Integer.parseInt(prop.getProperty("PanelForecastColor")));

			TempAvgSchriftgroesse = Integer.parseInt(prop.getProperty("TempAvgSchriftgroesse"));
			TempAvgVisible = Boolean.parseBoolean(prop.getProperty("TempAvgVisible"));
			TempAvgColor = new Color(Integer.parseInt(prop.getProperty("TempAvgColor")));
			TempAvgSizeX = Integer.parseInt(prop.getProperty("TempAvgSizeX"));
			TempAvgSizeY = Integer.parseInt(prop.getProperty("TempAvgSizeY"));

			TempMMSchriftgroesse = Integer.parseInt(prop.getProperty("TempMMSchriftgroesse"));
			TempMMVisible = Boolean.parseBoolean(prop.getProperty("TempMMVisible"));
			TempMMColor = new Color(Integer.parseInt(prop.getProperty("TempMMColor")));
			TempMMSizeX = Integer.parseInt(prop.getProperty("TempMMSizeX"));
			TempMMSizeY = Integer.parseInt(prop.getProperty("TempMMSizeY"));

			PrecipSchriftgroesse = Integer.parseInt(prop.getProperty("PrecipSchriftgroesse"));
			PrecipVisible = Boolean.parseBoolean(prop.getProperty("PrecipVisible"));
			PrecipColor = new Color(Integer.parseInt(prop.getProperty("PrecipColor")));
			PrecipSizeX = Integer.parseInt(prop.getProperty("PrecipSizeX"));
			PrecipSizeY = Integer.parseInt(prop.getProperty("PrecipSizeY"));

			DaySchriftgroesse = Integer.parseInt(prop.getProperty("DaySchriftgroesse"));
			DayVisible = Boolean.parseBoolean(prop.getProperty("DayVisible"));
			DayColor = new Color(Integer.parseInt(prop.getProperty("DayColor")));
			DaySizeX = Integer.parseInt(prop.getProperty("DaySizeX"));
			DaySizeY = Integer.parseInt(prop.getProperty("DaySizeY"));

			IconSize = Integer.parseInt(prop.getProperty("IconSize"));
			IconSizeX = Integer.parseInt(prop.getProperty("IconSizeX"));
			IconSizeY = Integer.parseInt(prop.getProperty("IconSizeY"));
			IconVisible = Boolean.parseBoolean(prop.getProperty("IconVisible"));

			// Day0
			TempAvgD0PosX = Integer.parseInt(prop.getProperty("TempAvgD0PosX"));
			TempAvgD0PosY = Integer.parseInt(prop.getProperty("TempAvgD0PosY"));

			TempMMD0PosX = Integer.parseInt(prop.getProperty("TempMMD0PosX"));
			TempMMD0PosY = Integer.parseInt(prop.getProperty("TempMMD0PosY"));

			PrecipD0PosX = Integer.parseInt(prop.getProperty("PrecipD0PosX"));
			PrecipD0PosY = Integer.parseInt(prop.getProperty("PrecipD0PosY"));
			
			Day0PosX = Integer.parseInt(prop.getProperty("Day0PosX"));
			Day0PosY = Integer.parseInt(prop.getProperty("Day0PosY"));

			IconD0PosX = Integer.parseInt(prop.getProperty("IconD0PosX"));
			IconD0PosY = Integer.parseInt(prop.getProperty("IconD0PosY"));

			// Day1
			TempAvgD1PosX = Integer.parseInt(prop.getProperty("TempAvgD1PosX"));
			TempAvgD1PosY = Integer.parseInt(prop.getProperty("TempAvgD1PosY"));

			TempMMD1PosX = Integer.parseInt(prop.getProperty("TempMMD1PosX"));
			TempMMD1PosY = Integer.parseInt(prop.getProperty("TempMMD1PosY"));

			PrecipD1PosX = Integer.parseInt(prop.getProperty("PrecipD1PosX"));
			PrecipD1PosY = Integer.parseInt(prop.getProperty("PrecipD1PosY"));

			Day1PosX = Integer.parseInt(prop.getProperty("Day1PosX"));
			Day1PosY = Integer.parseInt(prop.getProperty("Day1PosY"));

			IconD1PosX = Integer.parseInt(prop.getProperty("IconD1PosX"));
			IconD1PosY = Integer.parseInt(prop.getProperty("IconD1PosY"));

			// Day 2
			TempAvgD2PosX = Integer.parseInt(prop.getProperty("TempAvgD2PosX"));
			TempAvgD2PosY = Integer.parseInt(prop.getProperty("TempAvgD2PosY"));

			TempMMD2PosX = Integer.parseInt(prop.getProperty("TempMMD2PosX"));
			TempMMD2PosY = Integer.parseInt(prop.getProperty("TempMMD2PosY"));

			PrecipD2PosX = Integer.parseInt(prop.getProperty("PrecipD2PosX"));
			PrecipD2PosY = Integer.parseInt(prop.getProperty("PrecipD2PosY"));

			Day2PosX = Integer.parseInt(prop.getProperty("Day2PosX"));
			Day2PosY = Integer.parseInt(prop.getProperty("Day2PosY"));

			IconD2PosX = Integer.parseInt(prop.getProperty("IconD2PosX"));
			IconD2PosY = Integer.parseInt(prop.getProperty("IconD2PosY"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
