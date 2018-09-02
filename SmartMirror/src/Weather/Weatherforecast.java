package Weather;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Main.SmartMirror;
import Config.Configuration;

public class Weatherforecast extends JPanel {

	private static final long serialVersionUID = 1L;
	Configuration prop;

	private String[] TempMax = new String[3];
	private String[] TempMin = new String[3];
	private String[] TempAvg = new String[3];
	private String[] Icon = new String[3];
	private String[] Precip = new String[3];

	private JLabel D0_TempAvg = new JLabel();
	private JLabel D0_TempMM = new JLabel();
	private JLabel D0_Icon = new JLabel();
	private JLabel D0_Precip = new JLabel();
	private JLabel D0_Day = new JLabel();

	private JLabel D1_TempAvg = new JLabel();
	private JLabel D1_TempMM = new JLabel();
	private JLabel D1_Icon = new JLabel();
	private JLabel D1_Precip = new JLabel();
	private JLabel D1_Day = new JLabel();

	private JLabel D2_TempAvg = new JLabel();
	private JLabel D2_TempMM = new JLabel();
	private JLabel D2_Icon = new JLabel();
	private JLabel D2_Precip = new JLabel();
	private JLabel D2_Day = new JLabel();

	private Date Timestamp;
	private SimpleDateFormat DatumFormat = new SimpleDateFormat("EEE dd.MM");
	long days = 24 * 60 * 60 * 1000;

	public Weatherforecast() {
		prop = new Configuration();

		this.setBackground(new Color(Integer.parseInt(prop.getProperty("PanelForecastColor"))));
		this.setLayout(null);
		this.setVisible(Boolean.parseBoolean(prop.getProperty("PanelForecastVisible")));

		D0_TempAvg.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("TempAvgSchriftgroesse"))));
		D0_TempAvg.setForeground(new Color(Integer.parseInt(prop.getProperty("TempAvgColor"))));
		D0_TempAvg.setSize(Integer.parseInt(prop.getProperty("TempAvgSizeX")),
				Integer.parseInt(prop.getProperty("TempAvgSizeY")));
		D0_TempAvg.setLocation(Integer.parseInt(prop.getProperty("TempAvgD0PosX")),
				Integer.parseInt(prop.getProperty("TempAvgD0PosY")));
		D0_TempAvg.setVisible(Boolean.parseBoolean(prop.getProperty("TempAvgVisible")));

		D0_TempMM.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("TempMMSchriftgroesse"))));
		D0_TempMM.setForeground(new Color(Integer.parseInt(prop.getProperty("TempMMColor"))));
		D0_TempMM.setSize(Integer.parseInt(prop.getProperty("TempMMSizeX")),
				Integer.parseInt(prop.getProperty("TempMMSizeY")));
		D0_TempMM.setLocation(Integer.parseInt(prop.getProperty("TempMMD0PosX")),
				Integer.parseInt(prop.getProperty("TempMMD0PosY")));
		D0_TempMM.setVisible(Boolean.parseBoolean(prop.getProperty("TempMMVisible")));

		D0_Icon.setSize(Integer.parseInt(prop.getProperty("IconSize")), Integer.parseInt(prop.getProperty("IconSize")));
		D0_Icon.setLocation(Integer.parseInt(prop.getProperty("IconD0PosX")),
				Integer.parseInt(prop.getProperty("IconD0PosY")));
		D0_Icon.setVisible(Boolean.parseBoolean(prop.getProperty("IconVisible")));

		D0_Precip.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("PrecipSchriftgroesse"))));
		D0_Precip.setForeground(new Color(Integer.parseInt(prop.getProperty("PrecipColor"))));
		D0_Precip.setSize(Integer.parseInt(prop.getProperty("PrecipSizeX")),
				Integer.parseInt(prop.getProperty("PrecipSizeY")));
		D0_Precip.setLocation(Integer.parseInt(prop.getProperty("PrecipD0PosX")),
				Integer.parseInt(prop.getProperty("PrecipD0PosY")));
		D0_Precip.setVisible(Boolean.parseBoolean(prop.getProperty("PrecipVisible")));

		D0_Day.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("DaySchriftgroesse"))));
		D0_Day.setForeground(new Color(Integer.parseInt(prop.getProperty("DayColor"))));
		D0_Day.setSize(Integer.parseInt(prop.getProperty("DaySizeX")), Integer.parseInt(prop.getProperty("DaySizeY")));
		D0_Day.setLocation(Integer.parseInt(prop.getProperty("Day0PosX")),
				Integer.parseInt(prop.getProperty("Day0PosY")));
		D0_Day.setVisible(Boolean.parseBoolean(prop.getProperty("DayVisible")));

		D1_TempAvg.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("TempAvgSchriftgroesse"))));
		D1_TempAvg.setForeground(new Color(Integer.parseInt(prop.getProperty("TempAvgColor"))));
		D1_TempAvg.setSize(Integer.parseInt(prop.getProperty("TempAvgSizeX")),
				Integer.parseInt(prop.getProperty("TempAvgSizeY")));
		D1_TempAvg.setLocation(Integer.parseInt(prop.getProperty("TempAvgD1PosX")),
				Integer.parseInt(prop.getProperty("TempAvgD1PosY")));
		D1_TempAvg.setVisible(Boolean.parseBoolean(prop.getProperty("TempAvgVisible")));

		D1_TempMM.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("TempMMSchriftgroesse"))));
		D1_TempMM.setForeground(new Color(Integer.parseInt(prop.getProperty("TempMMColor"))));
		D1_TempMM.setSize(Integer.parseInt(prop.getProperty("TempMMSizeX")),
				Integer.parseInt(prop.getProperty("TempMMSizeY")));
		D1_TempMM.setLocation(Integer.parseInt(prop.getProperty("TempMMD1PosX")),
				Integer.parseInt(prop.getProperty("TempMMD1PosY")));
		D1_TempMM.setVisible(Boolean.parseBoolean(prop.getProperty("TempMMVisible")));

		D1_Icon.setSize(Integer.parseInt(prop.getProperty("IconSize")), Integer.parseInt(prop.getProperty("IconSize")));
		D1_Icon.setLocation(Integer.parseInt(prop.getProperty("IconD1PosX")),
				Integer.parseInt(prop.getProperty("IconD1PosY")));
		D1_Icon.setVisible(Boolean.parseBoolean(prop.getProperty("IconVisible")));

		D1_Precip.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("PrecipSchriftgroesse"))));
		D1_Precip.setForeground(new Color(Integer.parseInt(prop.getProperty("PrecipColor"))));
		D1_Precip.setSize(Integer.parseInt(prop.getProperty("PrecipSizeX")),
				Integer.parseInt(prop.getProperty("PrecipSizeY")));
		D1_Precip.setLocation(Integer.parseInt(prop.getProperty("PrecipD1PosX")),
				Integer.parseInt(prop.getProperty("PrecipD1PosY")));
		D1_Precip.setVisible(Boolean.parseBoolean(prop.getProperty("PrecipVisible")));

		D1_Day.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("DaySchriftgroesse"))));
		D1_Day.setForeground(new Color(Integer.parseInt(prop.getProperty("DayColor"))));
		D1_Day.setSize(Integer.parseInt(prop.getProperty("DaySizeX")), Integer.parseInt(prop.getProperty("DaySizeY")));
		D1_Day.setLocation(Integer.parseInt(prop.getProperty("Day1PosX")),
				Integer.parseInt(prop.getProperty("Day1PosY")));
		D1_Day.setVisible(Boolean.parseBoolean(prop.getProperty("DayVisible")));

		D2_TempAvg.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("TempAvgSchriftgroesse"))));
		D2_TempAvg.setForeground(new Color(Integer.parseInt(prop.getProperty("TempAvgColor"))));
		D2_TempAvg.setSize(Integer.parseInt(prop.getProperty("TempAvgSizeX")),
				Integer.parseInt(prop.getProperty("TempAvgSizeY")));
		D2_TempAvg.setLocation(Integer.parseInt(prop.getProperty("TempAvgD2PosX")),
				Integer.parseInt(prop.getProperty("TempAvgD2PosY")));
		D2_TempAvg.setVisible(Boolean.parseBoolean(prop.getProperty("TempAvgVisible")));

		D2_TempMM.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("TempMMSchriftgroesse"))));
		D2_TempMM.setForeground(new Color(Integer.parseInt(prop.getProperty("TempMMColor"))));
		D2_TempMM.setSize(Integer.parseInt(prop.getProperty("TempMMSizeX")),
				Integer.parseInt(prop.getProperty("TempMMSizeY")));
		D2_TempMM.setLocation(Integer.parseInt(prop.getProperty("TempMMD2PosX")),
				Integer.parseInt(prop.getProperty("TempMMD2PosY")));
		D2_TempMM.setVisible(Boolean.parseBoolean(prop.getProperty("TempMMVisible")));

		D2_Icon.setSize(Integer.parseInt(prop.getProperty("IconSize")), Integer.parseInt(prop.getProperty("IconSize")));
		D2_Icon.setLocation(Integer.parseInt(prop.getProperty("IconD2PosX")),
				Integer.parseInt(prop.getProperty("IconD2PosY")));
		D2_Icon.setVisible(Boolean.parseBoolean(prop.getProperty("IconVisible")));

		D2_Precip.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("PrecipSchriftgroesse"))));
		D2_Precip.setForeground(new Color(Integer.parseInt(prop.getProperty("PrecipColor"))));
		D2_Precip.setSize(Integer.parseInt(prop.getProperty("PrecipSizeX")),
				Integer.parseInt(prop.getProperty("PrecipSizeY")));
		D2_Precip.setLocation(Integer.parseInt(prop.getProperty("PrecipD2PosX")),
				Integer.parseInt(prop.getProperty("PrecipD2PosY")));
		D2_Precip.setVisible(Boolean.parseBoolean(prop.getProperty("PrecipVisible")));

		D2_Day.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("DaySchriftgroesse"))));
		D2_Day.setForeground(new Color(Integer.parseInt(prop.getProperty("DayColor"))));
		D2_Day.setSize(Integer.parseInt(prop.getProperty("DaySizeX")), Integer.parseInt(prop.getProperty("DaySizeY")));
		D2_Day.setLocation(Integer.parseInt(prop.getProperty("Day2PosX")),
				Integer.parseInt(prop.getProperty("Day2PosY")));
		D2_Day.setVisible(Boolean.parseBoolean(prop.getProperty("DayVisible")));

		this.add(D0_TempAvg);
		this.add(D0_TempMM);
		this.add(D0_Icon);
		this.add(D0_Precip);
		this.add(D0_Day);

		this.add(D1_TempAvg);
		this.add(D1_TempMM);
		this.add(D1_Icon);
		this.add(D1_Precip);
		this.add(D1_Day);

		this.add(D2_TempAvg);
		this.add(D2_TempMM);
		this.add(D2_Icon);
		this.add(D2_Precip);
		this.add(D2_Day);
	}

	public void writeWeatherForecast() {

		File targetFile = new File("resources/WeatherForecast.xml");
		Date d = new Date(targetFile.lastModified() + Integer.parseInt(prop.getProperty("MinUpdateTime")));
		Timestamp = new Date();

		if (Timestamp.compareTo(d) > 0) {

			try {
				URL url = new URL("http://api.apixu.com/v1/forecast.xml?key=" + prop.getProperty("ApiKeyForecast")
						+ "&q=" + prop.getProperty("City") + "&days=3");

				InputStream initialStream = url.openStream();
				byte[] buffer = new byte[initialStream.available()];
				initialStream.read(buffer);

				targetFile = new File("resources/WeatherForecast.xml");
				@SuppressWarnings("resource")
				OutputStream outStream = new FileOutputStream(targetFile);
				outStream.write(buffer);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

	public void getWeatherForecast() {
		Timestamp = new Date();
		try {
			File file = new File("resources/WeatherForecast.xml");
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("forecastday");
			handleForecastdayTag(nodeList);

			// Daten Ausgeben
			D0_TempAvg.setText(TempAvg[0]);
			D0_TempMM.setText(TempMax[0] + "/" + TempMin[0]);
			D0_Icon.setIcon(new ImageIcon(SmartMirror.class.getResource("/" + cutFront(Icon[0], "/", 4))));
			D0_Precip.setText(Precip[0]);
			D0_Day.setText(DatumFormat.format(new Date(Timestamp.getTime() + 1 * days)).toString());

			D1_TempAvg.setText(TempAvg[1]);
			D1_TempMM.setText(TempMax[1] + "/" + TempMin[1]);
			D1_Icon.setIcon(new ImageIcon(SmartMirror.class.getResource("/" + cutFront(Icon[1], "/", 4))));
			D1_Precip.setText(Precip[1]);
			D1_Day.setText(DatumFormat.format(new Date(Timestamp.getTime() + 2 * days)).toString());

			D2_TempAvg.setText(TempAvg[2]);
			D2_TempMM.setText(TempMax[2] + "/" + TempMin[2]);
			D2_Icon.setIcon(new ImageIcon(SmartMirror.class.getResource("/" + cutFront(Icon[2], "/", 4))));
			D2_Precip.setText(Precip[2]);
			D2_Day.setText(DatumFormat.format(new Date(Timestamp.getTime() + 3 * days)).toString());

		} catch (ParserConfigurationException | IOException | DOMException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			FileWriter fw = new FileWriter("resources/WeatherForecast.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("Day: " + D0_Day.getText());
			bw.write("\n");
			bw.write("Temperatur Avg: " + TempAvg[0]);
			bw.write("\n");
			bw.write("Temperatur MM: " + TempMax[0] + "/" + TempMin[0]);
			bw.write("\n");
			bw.write("Icon: " + cutFront(Icon[0], "/", 4));
			bw.write("\n");
			bw.write("Precipication: " + Precip[0]);

			bw.write("Day: " + D1_Day.getText());
			bw.write("\n");
			bw.write("Temperatur Avg: " + TempAvg[1]);
			bw.write("\n");
			bw.write("Temperatur MM: " + TempMax[1] + "/" + TempMin[1]);
			bw.write("\n");
			bw.write("Icon: " + cutFront(Icon[1], "/", 4));
			bw.write("\n");
			bw.write("Precipication: " + Precip[1]);

			bw.write("Day: " + D2_Day.getText());
			bw.write("\n");
			bw.write("Temperatur Avg: " + TempAvg[2]);
			bw.write("\n");
			bw.write("Temperatur MM: " + TempMax[2] + "/" + TempMin[2]);
			bw.write("\n");
			bw.write("Icon: " + cutFront(Icon[2], "/", 4));
			bw.write("\n");
			bw.write("Precipication: " + Precip[2]);

			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String cutFront(String txt, String teil, int number) {
		for (int i = 0; i < number; i++) {
			txt = txt.substring(txt.indexOf(teil) + 1, txt.length());
		}
		return txt;
	}

	private void handleForecastdayTag(NodeList nodeList) {
		for (int i = 0; i < nodeList.getLength(); i++) {
			// System.out.println("Forecastday" + i);
			Node node = (Node) nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				// System.out.println(i);
				// System.out.println(handleTextTag("maxtemp_c", element));
				// System.out.println(handleTextTag("mintemp_c", element));
				// System.out.println(handleTextTag("avgtemp_c", element));
				// System.out.println(handleTextTag("icon", element));
				// System.out.println(handleTextTag("totalprecip_mm", element));

				TempMax[i] = handleTextTag("maxtemp_c", element);
				TempMin[i] = handleTextTag("mintemp_c", element) + prop.getProperty("TempUnit");
				TempAvg[i] = handleTextTag("avgtemp_c", element) + prop.getProperty("TempUnit");
				Icon[i] = handleTextTag("icon", element);
				Precip[i] = handleTextTag("totalprecip_mm", element) + prop.getProperty("PrecipUnit");

			}
		}
	}

	private String handleTextTag(String tagName, Element element) {
		StringBuffer returnValue = new StringBuffer();
		for (int i = 0; i < element.getElementsByTagName(tagName).getLength(); i++) {
			NodeList nodeList = element.getElementsByTagName(tagName).item(i).getChildNodes();
			Node node = (Node) nodeList.item(0);
			returnValue.append(node.getNodeValue());
		}
		return returnValue.toString();
	}

}

// Today: http://api.apixu.com/v1/current.xml?key=e819511b990c4f96be4183627183107&q=Luzern

//forecast: http://api.apixu.com/v1/forecast.xml?key=e819511b990c4f96be4183627183107&q=Luzern&days=3
