

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class Datum extends JLabel{

	private static final long serialVersionUID = 1L;

	private Date Timestamp;
	Configuration prop;
	SimpleDateFormat DatumFormat;

	public Datum() {
		prop = new Configuration();
		
		DatumFormat = new SimpleDateFormat(prop.getProperty("DatumFormat"));
		Font fontDatum = new Font( prop.getProperty("Schriftart"), Font.PLAIN, Integer.parseInt(prop.getProperty("DatumSchriftgroesse")));
		this.setFont(fontDatum);
		this.setForeground(new Color(Integer.parseInt(prop.getProperty("DatumColor"))));

	}

 void getDate() {
	 Timestamp = new Date();
		this.setText(DatumFormat.format(Timestamp).toString());
		
	}


}
