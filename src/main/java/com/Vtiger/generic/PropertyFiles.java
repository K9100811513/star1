package com.Vtiger.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFiles {

	
		public String readDatafrompropertyfile(String key) throws IOException {
			FileInputStream fis = new FileInputStream("C:\\KCSM12\\TYSS_KALPANA1\\vtiger.properties");

			Properties prop = new Properties();
			prop.load(fis);

			return	prop.getProperty(key);

		}


}
