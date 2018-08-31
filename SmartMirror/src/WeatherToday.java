
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class WeatherToday extends JPanel {

	private static final long serialVersionUID = 1L;
	Configuration prop;

	public String Temperatur;
	public String Wetter;
	public String StringIcon;
	public String Update;
	public String Percipication;

	private JLabel Temp = new JLabel();
	private JLabel Pic = new JLabel();
	private JLabel Percip = new JLabel();
	private JLabel Updated = new JLabel();

	public WeatherToday() {
		prop = new Configuration();

		this.setBackground(new Color(Integer.parseInt(prop.getProperty("PanelHeuteColor"))));
		// this.setLocation(pointPanel);
		// this.setSize(DimPanel);
		this.setLayout(null);
		this.setVisible(Boolean.parseBoolean(prop.getProperty("PanelHeuteVisible")));

		Temp.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("TempHeuteSchriftgroesse"))));
		Temp.setForeground(new Color(Integer.parseInt(prop.getProperty("TempHeuteColor"))));
		Temp.setSize(Integer.parseInt(prop.getProperty("TempHeuteSizeX")),
				Integer.parseInt(prop.getProperty("TempHeuteSizeY")));
		Temp.setLocation(Integer.parseInt(prop.getProperty("TempHeutePosX")),
				Integer.parseInt(prop.getProperty("TempHeutePosY")));
		Temp.setVisible(Boolean.parseBoolean(prop.getProperty("TempHeuteVisible")));

		Percip.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("PrecipHeuteSchriftgroesse"))));
		Percip.setForeground(new Color(Integer.parseInt(prop.getProperty("PrecipHeuteColor"))));
		Percip.setSize(Integer.parseInt(prop.getProperty("PrecipHeuteSizeX")),
				Integer.parseInt(prop.getProperty("PrecipHeuteSizeY")));
		Percip.setLocation(Integer.parseInt(prop.getProperty("PrecipHeutePosX")),
				Integer.parseInt(prop.getProperty("PrecipHeutePosY")));
		Percip.setVisible(Boolean.parseBoolean(prop.getProperty("PrecipHeuteVisible")));

		Updated.setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("UpdatedSchriftgroesse"))));
		Updated.setForeground(new Color(Integer.parseInt(prop.getProperty("UpdatedColor"))));
		Updated.setSize(Integer.parseInt(prop.getProperty("UpdatedSizeX")),
				Integer.parseInt(prop.getProperty("UpdatedSizeY")));
		Updated.setLocation(Integer.parseInt(prop.getProperty("UpdatedPosX")),
				Integer.parseInt(prop.getProperty("UpdatedPosY")));
		Updated.setVisible(Boolean.parseBoolean(prop.getProperty("UpdatedVisible")));

		Pic.setSize(Integer.parseInt(prop.getProperty("IconHeuteSize")),
				Integer.parseInt(prop.getProperty("IconHeuteSize")));
		Pic.setLocation(Integer.parseInt(prop.getProperty("IconHeutePosX")),
				Integer.parseInt(prop.getProperty("IconHeutePosY")));
		Pic.setVisible(Boolean.parseBoolean(prop.getProperty("IconHeuteVisible")));

		this.add(Temp);
		this.add(Percip);
		this.add(Updated);
		this.add(Pic);

	}

	public void writeWeatherToday() {
		File targetFile = new File("resources/WeatherForecast.xml");
		Date d = new Date(targetFile.lastModified() + Integer.parseInt(prop.getProperty("MinUpdateTime")));
		Date Timestamp = new Date();

		if (Timestamp.compareTo(d) > 0) {

			try {
				URL url = new URL("http://api.apixu.com/v1/current.xml?key=" + prop.getProperty("ApiKeyHeute") + "&q="
						+ prop.getProperty("City"));

				InputStream initialStream = url.openStream();
				byte[] buffer = new byte[initialStream.available()];
				initialStream.read(buffer);

				targetFile = new File("resources/WeatherToday.xml");
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

	public void getWeatherToday() {
		// File testfile = new File("testfile.xml");
		try {

			File file = new File("resources/WeatherToday.xml");
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(file);
			doc.getDocumentElement().normalize();

			Temperatur = doc.getElementsByTagName("temp_c").item(0).getTextContent() + prop.getProperty("TempUnit");
			StringIcon = doc.getElementsByTagName("icon").item(0).getTextContent();
			Update = "@ " + doc.getElementsByTagName("last_updated").item(0).getTextContent();
			Percipication = doc.getElementsByTagName("precip_mm").item(0).getTextContent()
					+ prop.getProperty("PrecipUnit");

			try {
				FileWriter fw = new FileWriter("resources/WeatherToday.txt");
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write("Temperatur: " + Temperatur);
				bw.write("\n");
				bw.write("Icon: " + StringIcon);
				bw.write("\n");
				bw.write("Update: " + Update);
				bw.write("\n");
				bw.write("Percipication: " + Percipication);

				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println(Temperatur);
			// System.out.println(Update);
			// System.out.println(Percipication);
			// System.out.println(cutFront(StringIcon, "/", 4));

			ImageIcon icon = new ImageIcon(SmartMirror.class.getResource("/" + cutFront(StringIcon, "/", 4)));
			Image buffer = getScaledImage(icon.getImage(), Integer.parseInt(prop.getProperty("IconHeuteSize")),
					Integer.parseInt(prop.getProperty("IconHeuteSize")));
			ImageIcon resized = new ImageIcon(buffer);

			Temp.setText(Temperatur);
			Updated.setText(Update);
			Percip.setText(Percipication);
			Pic.setIcon(resized);

			// System.out.println(resized.getIconWidth());

		} catch (ParserConfigurationException | IOException | DOMException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String cutFront(String txt, String teil, int number) {
		for (int i = 0; i < number; i++) {
			txt = txt.substring(txt.indexOf(teil) + 1, txt.length());
		}
		return txt;
	}

	private Image getScaledImage(Image icon, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(icon, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}

}

// Today: http://api.apixu.com/v1/current.xml?key=e819511b990c4f96be4183627183107&q=Luzern

//forecast: http://api.apixu.com/v1/forecast.xml?key=e819511b990c4f96be4183627183107&q=Luzern&days=3