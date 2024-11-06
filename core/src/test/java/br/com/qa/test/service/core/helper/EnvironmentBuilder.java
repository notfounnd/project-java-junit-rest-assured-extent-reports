package br.com.qa.test.service.core.helper;

import java.io.File;

import org.junit.Assert;

public class EnvironmentBuilder {

	private EnvironmentBuilder() { }

	public static String getEnvironment() {
		if (System.getProperty("env") == null) {
			Assert.fail("Environment not defined");
		}

		String env = System.getProperty("env").toLowerCase();

		return validateEnvironmentFile(String.format("%s-application.properties", env));
	}

	private static String validateEnvironmentFile(String fileName) {
		File source = new File(getSourcePropertieFilePath(fileName));

		if (!source.isFile()) {
			Assert.fail(String.format("Error on validate environment file: %s", fileName));
		}

		System.out.println(String.format("-------------------------------------------------------"));
		System.out.println(String.format("Environment argument: %s", System.getProperty("env")));
		System.out.println(String.format("Environment file: %s", fileName));
		System.out.println(String.format("Source file: %s", source.getPath()));
		System.out.println(String.format("-------------------------------------------------------"));

		return source.getPath();
	}

	private static String getSourcePropertieFilePath(String fileName) {
		if (fileName.endsWith(".properties")) {
			return ConfigConstants.ENVIRONMENTS_DIRECTORY + fileName;
		}

		return ConfigConstants.ENVIRONMENTS_DIRECTORY + fileName + ".properties";
	}

}
