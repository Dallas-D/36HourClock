import java.awt.Font;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class ThirtySix extends JFrame {
	
	static DateFormat hourFormat = new SimpleDateFormat("HH");
	static DateFormat minuteFormat = new SimpleDateFormat("mm");
	static DateFormat secondFormat = new SimpleDateFormat("ss");
	static DateFormat milliSecondFormat = new SimpleDateFormat("S");
	static double newHour, newMinute, newSecond;
	static JLabel time = new JLabel();
	static JLabel oldTime = new JLabel();
	static DecimalFormat decimalFormat = new DecimalFormat("00");

	public ThirtySix() {
		initUI();
	}

	public final void initUI() {
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);

		time = new JLabel();
		time.setBounds(50, 20, 300, 100);
		time.setFont(new Font("Dotum", Font.PLAIN, 72));
		
		oldTime = new JLabel();
		oldTime.setBounds(60, 80, 300, 100);
		oldTime.setFont(new Font("Sans", Font.PLAIN, 30));

		panel.add(time);
		panel.add(oldTime);

		setTitle("36 Hour Clock");
		setSize(400, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void setTime() {
		final Date d = new Date();
		final String hour = hourFormat.format(d);
		final String minute = minuteFormat.format(d);
		final String second = secondFormat.format(d);
		final String milliSecond = milliSecondFormat.format(d);

		newHour = (1.5 * Double.parseDouble(hour));
		newMinute = (0.6 * Double.parseDouble(minute));
		newSecond = (0.6 * (Double.parseDouble(second) + Double.parseDouble(milliSecond) / 1000));
		time.setText(decimalFormat.format(newHour) + ":" + decimalFormat.format(newMinute) + ":" + decimalFormat.format(newSecond));
		oldTime.setText(new SimpleDateFormat("hh").format(new Date()) + ":" + minuteFormat.format(new Date()) + ":" + secondFormat.format(new Date()));
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ThirtySix ts = new ThirtySix();
				ts.setVisible(true);
			}
		});
		
		while (true) {
			setTime();
		}

	}
}