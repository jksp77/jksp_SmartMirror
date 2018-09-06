package Main;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Config.Configuration;

public class MenuIcons extends JPanel {
	private static final long serialVersionUID = 1L;

	ImageIcon IconCalendar = new ImageIcon(SmartMirror.class.getResource("/Icons/Icon_Calendar.png"));
	ImageIcon IconSettings = new ImageIcon(SmartMirror.class.getResource("/Icons/Icon_Settings.png"));
	ImageIcon IconMail = new ImageIcon(SmartMirror.class.getResource("/Icons/Icon_Mail.png"));
	ImageIcon IconSMS = new ImageIcon(SmartMirror.class.getResource("/Icons/Icon_SMS.png"));
	ImageIcon IconWeather = new ImageIcon(SmartMirror.class.getResource("/Icons/Icon_Weather.png"));
	ImageIcon IconArrowBack = new ImageIcon(SmartMirror.class.getResource("/Icons/Icon_Arrow_back.png"));
	ImageIcon IconArrowDown = new ImageIcon(SmartMirror.class.getResource("/Icons/Icon_Arrow_down.png"));
	ImageIcon IconArrowUp = new ImageIcon(SmartMirror.class.getResource("/Icons/Icon_Arrow_up.png"));
	ImageIcon IconArrowLeft = new ImageIcon(SmartMirror.class.getResource("/Icons/Icon_Arrow_left.png"));
	ImageIcon IconArrowRight = new ImageIcon(SmartMirror.class.getResource("/Icons/Icon_Arrow_right.png"));
	ImageIcon IconHome = new ImageIcon(SmartMirror.class.getResource("/Icons/Icon_Home.png"));
	ImageIcon IconSleep = new ImageIcon(SmartMirror.class.getResource("/Icons/Icon_Sleep.png"));
	
	JLabel Icon0;
	JLabel Icon1;
	JLabel Icon2;
	JLabel Icon3;
	JLabel Icon4;
	
	public MenuIcons(String Menu) {
		Configuration prop = new Configuration();

		this.setBackground(new Color(Integer.parseInt(prop.getProperty("PanelIconsColor"))));
		this.setLayout(null);

		Icon0 = new JLabel();
		Icon1 = new JLabel();
		Icon2 = new JLabel();
		Icon3 = new JLabel();
		Icon4 = new JLabel();

		this.add(Icon0);
		Icon0.setSize(Integer.parseInt(prop.getProperty("MenuIconSize")),
				Integer.parseInt(prop.getProperty("MenuIconSize")));
		Icon0.setLocation(Integer.parseInt(prop.getProperty("Icon0PosX")),
				Integer.parseInt(prop.getProperty("Icon0PosY")));
		Icon0.setVisible(true);

		this.add(Icon1);
		Icon1.setSize(Integer.parseInt(prop.getProperty("MenuIconSize")),
				Integer.parseInt(prop.getProperty("MenuIconSize")));
		Icon1.setLocation(Integer.parseInt(prop.getProperty("Icon1PosX")),
				Integer.parseInt(prop.getProperty("Icon1PosY")));
		Icon1.setVisible(true);

		this.add(Icon2);
		Icon2.setSize(Integer.parseInt(prop.getProperty("MenuIconSize")),
				Integer.parseInt(prop.getProperty("MenuIconSize")));
		Icon2.setLocation(Integer.parseInt(prop.getProperty("Icon2PosX")),
				Integer.parseInt(prop.getProperty("Icon2PosY")));
		Icon2.setVisible(true);

		this.add(Icon3);
		Icon3.setSize(Integer.parseInt(prop.getProperty("MenuIconSize")),
				Integer.parseInt(prop.getProperty("MenuIconSize")));
		Icon3.setLocation(Integer.parseInt(prop.getProperty("Icon3PosX")),
				Integer.parseInt(prop.getProperty("Icon3PosY")));
		Icon3.setVisible(true);

		this.add(Icon4);
		Icon4.setSize(Integer.parseInt(prop.getProperty("MenuIconSize")),
				Integer.parseInt(prop.getProperty("MenuIconSize")));
		Icon4.setLocation(Integer.parseInt(prop.getProperty("Icon4PosX")),
				Integer.parseInt(prop.getProperty("Icon4PosY")));
		Icon4.setVisible(true);

		setIcons(Menu);
		
		
	}
	
	void setIcons(String Menu) {
		
		switch (Menu) {
		case "Home":
			Icon0.setIcon(IconCalendar);
			Icon1.setIcon(IconMail);
			Icon2.setIcon(IconWeather);
			Icon3.setIcon(IconSettings);
			Icon4.setIcon(IconSleep);
			break;

			
			
		case "Calendar":
			Icon0.setIcon(IconArrowBack);
			Icon1.setIcon(IconArrowRight);
			Icon2.setIcon(IconArrowLeft);
			Icon3.setIcon(null);
			Icon4.setIcon(IconHome);
			break;
		case "Mail":
			Icon0.setIcon(null);
			Icon1.setIcon(null);
			Icon2.setIcon(null);
			Icon3.setIcon(null);
			Icon4.setIcon(null);
			break;
		case "Settings":
			Icon0.setIcon(null);
			Icon1.setIcon(null);
			Icon2.setIcon(null);
			Icon3.setIcon(null);
			Icon4.setIcon(null);
			break;

		}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
