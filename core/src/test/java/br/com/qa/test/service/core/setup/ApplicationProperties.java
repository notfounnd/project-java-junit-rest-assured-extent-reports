package br.com.qa.test.service.core.setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Assert;

import br.com.qa.test.service.core.helper.EnvironmentBuilder;

public class ApplicationProperties {

	private Properties properties = new Properties();

	public ApplicationProperties() {
		String sourcePath = EnvironmentBuilder.getEnvironment();
		loadAplicationProperties(sourcePath);
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	private void loadAplicationProperties(String sourcePath) {
		try {
			InputStream stream = new FileInputStream(sourcePath);
			properties.load(stream);
		} catch (IOException e) {
			Assert.fail("Error on trying to read properties");
		}
	}

}
