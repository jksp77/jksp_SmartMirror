package Calendar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalMenue extends JPanel {

	private static final long serialVersionUID = 1L;

	public CalMenue() {

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		Point middle = new Point();
		middle.setLocation(d.getWidth() / 2, d.getHeight() / 2);

		this.setBackground(Color.black);
		this.setLayout(null);

		// Icons einfügen

		ImageIcon IconCal = new ImageIcon("resources/Icons/Icon_Cal.png");
		JLabel Cal = new JLabel(IconCal);
		this.add(Cal);
		Cal.setSize(52, 52);
		Cal.setLocation((int) (d.getWidth() - 100), (int) (d.getHeight() / 10 * 1));
		Cal.setVisible(true);

		ImageIcon IconSet = new ImageIcon("resources/Icons/Icon_Set.png");
		JLabel Set = new JLabel(IconSet);
		this.add(Set);
		Set.setSize(52, 52);
		Set.setLocation((int) (d.getWidth() - 100), (int) (d.getHeight() / 10 * 3));
		Set.setVisible(true);

		ImageIcon IconMail = new ImageIcon("resources/Icons/Icon_Mail.png");
		JLabel Mail = new JLabel(IconMail);
		this.add(Mail);
		Mail.setSize(52, 52);
		Mail.setLocation((int) (d.getWidth() - 100), (int) (d.getHeight() / 10 * 5));
		Mail.setVisible(true);

		ImageIcon IconSMS = new ImageIcon("resources/Icons/Icon_SMS.png");
		JLabel SMS = new JLabel(IconSMS);
		this.add(SMS);
		SMS.setSize(52, 52);
		SMS.setLocation((int) (d.getWidth() - 100), (int) (d.getHeight() / 10 * 7));
		SMS.setVisible(true);

		ImageIcon IconBLA = new ImageIcon("resources/Icons/Icon_Set.png");
		JLabel BLA = new JLabel(IconBLA);
		this.add(BLA);
		BLA.setSize(52, 52);
		BLA.setLocation((int) (d.getWidth() - 100), (int) (d.getHeight() / 10 * 9));
		BLA.setVisible(true);

	}

}
