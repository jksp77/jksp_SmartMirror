package Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Config.Configuration;

public class CalWeek extends JPanel{
	
	Configuration prop;
	
	JPanel[] Weekday = new JPanel[7];
	JPanel[] Frame = new JPanel[7];
	JLabel[] Days = new JLabel[7];
	String[] Names = {"Mo","Di","Mi","Do","Fr","Sa","So"};
	
	int width = 100;
	
	public CalWeek() {
		prop = new Configuration();
		
		
		this.setForeground(null);
		this.setBackground(null);
		this.setLayout(null);
		this.setLocation(0,200);
		this.setSize(750,800);
		this.setVisible(true);
		
		for(int i=0; i<7;i++) {
			Weekday[i] = new JPanel();
			Weekday[i].setLayout(null);
			Weekday[i].setSize(width,720);
			Weekday[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.white));
			Weekday[i].setLocation(i*width, 0);
			Weekday[i].setVisible(true);
			Weekday[i].setForeground(null);
			Weekday[i].setBackground(null);
			this.add(Weekday[i]);
			
			Days[i] = new JLabel();
			Days[i].setSize(width,50);
			Days[i].setLocation(10,0);
			Days[i].setVisible(true);
			Days[i].setForeground(Color.white);
			Days[i].setBackground(null);
			Days[i].setText(Names[i]);
			Days[i].setFont(new Font(prop.getProperty("Schriftart"), Font.PLAIN,
					Integer.parseInt(prop.getProperty("WeekdaySchriftgroesse"))));
			Weekday[i].add(Days[i]);
			
			Frame[i] = new JPanel();
			Frame[i].setSize(width,50);
			Frame[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.white));
			Frame[i].setLocation(0, 0);
			Frame[i].setVisible(true);
			Frame[i].setForeground(null);
			Frame[i].setBackground(null);
			Weekday[i].add(Frame[i]);
		}
		
		
		
		
	}
	

}
