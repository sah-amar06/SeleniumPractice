package SeleniumBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {

	private Properties prop;
	
	public Properties initProp() {
		try {
			FileInputStream ip = new FileInputStream("./src/main/java/confi/confi.properties");
		 prop = new Properties();
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;

	}
}
