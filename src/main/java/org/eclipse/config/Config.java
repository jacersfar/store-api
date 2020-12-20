package org.eclipse.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	private Properties properties = new Properties();
	public Config(String fileName) throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
		if (inputStream != null) {
			properties.load(inputStream);
		} else {
			throw new FileNotFoundException("Properties file not found: " + fileName);
		}
	}
	
	public Properties getProperties() {
		return this.properties;
	}
}
