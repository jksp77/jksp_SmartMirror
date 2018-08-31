
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Time extends JPanel {

	private static final long serialVersionUID = 1L;

	private Date Timestamp;
	Configuration prop;
	JLabel time1 = new JLabel();
	JLabel time2 = new JLabel();
	JLabel time = new JLabel();
	
	public Time(String size) {
		prop = new Configuration();
		

	
				
		if(size=="small") {
			this.setBackground(new Color(Integer.parseInt(prop.getProperty("ZeitSmallBackground"))));
			this.setVisible(Boolean.parseBoolean(prop.getProperty("ZeitSmallVisible")));
			this.setLayout(null);
			
			Font fontTime = new Font(prop.getProperty("Schriftart"), Font.PLAIN,
					Integer.parseInt(prop.getProperty("ZeitSmallSchriftgroesse")));
						
			
			this.add(time);
			time.setFont(fontTime); 
			time.setForeground(new Color(Integer.parseInt(prop.getProperty("ZeitSmallColor"))));
			time.setSize(100,Integer.parseInt(prop.getProperty("ZeitSmallSchriftgroesse")));
			time.setLocation(0,0);
			time.setVisible(true);
			
		}else {
			
			this.setBackground(new Color(Integer.parseInt(prop.getProperty("ZeitBackground"))));
			this.setVisible(Boolean.parseBoolean(prop.getProperty("ZeitVisible")));
			this.setLayout(null);
			
		Font fontTime1 = new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("ZeitSchriftgroesse1")));
		
		Font fontTime2 = new Font(prop.getProperty("Schriftart"), Font.PLAIN,
				Integer.parseInt(prop.getProperty("ZeitSchriftgroesse2")));
		
		
		this.add(time1);
		time1.setFont(fontTime1); 
		time1.setForeground(new Color(Integer.parseInt(prop.getProperty("ZeitColor1"))));
		time1.setSize(500,120);
		time1.setLocation(0,0);
		time1.setVisible(true);
		
		this.add(time2);
		time2.setFont(fontTime2); 
		time2.setForeground(new Color(Integer.parseInt(prop.getProperty("ZeitColor2"))));
		time2.setSize(300,120);
		time2.setLocation(360,30);
		time2.setVisible(true);
		}
	}

	void getTime() {
		Timestamp = new Date();
		SimpleDateFormat TimeFormat1 = new SimpleDateFormat(prop.getProperty("ZeitFormat1"));
		SimpleDateFormat TimeFormat2 = new SimpleDateFormat(prop.getProperty("ZeitFormat2"));
		SimpleDateFormat TimeFormat = new SimpleDateFormat(prop.getProperty("ZeitSmallFormat"));
		time1.setText(TimeFormat1.format(Timestamp).toString());
		time2.setText(TimeFormat2.format(Timestamp).toString());
		time.setText(TimeFormat.format(Timestamp).toString());;
			}
}
