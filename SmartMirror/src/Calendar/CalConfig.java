package Calendar;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import Main.SmartMirror;

public class CalConfig extends Properties {
	private static final long serialVersionUID = 1L;
	Properties prop = new Properties();
	OutputStream output = null;
	InputStream input = SmartMirror.class.getResourceAsStream("/Cal.properties");

	public CalConfig() {

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
	
	
	
}
