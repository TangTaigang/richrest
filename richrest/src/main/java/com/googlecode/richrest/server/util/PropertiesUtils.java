package com.googlecode.richrest.server.util;

import java.io.InputStream;
import java.util.Properties;

import com.googlecode.richrest.server.ActionServletContext;

public final class PropertiesUtils {

	private PropertiesUtils() {}

	public static Properties getProperties(String propertiesName) {
		Properties properties = new Properties();
		try {
			InputStream in = getClasspathInputStream(propertiesName);
			if (in != null)
				properties.load(in);
		} catch (Throwable e) {
			// ignore
		}
		try {
			InputStream in = getWebappInputStream("WEB-INF/" + propertiesName);
			if (in != null)
				properties.load(in);
		} catch (Throwable e) {
			// ignore
		}
		try {
			InputStream in = getWebappInputStream(propertiesName);
			if (in != null)
				properties.load(in);
		} catch (Throwable e) {
			// ignore
		}
		return properties;
	}

	private static InputStream getWebappInputStream(String propertiesName) {
		return ActionServletContext.getContext().getServletContext().getResourceAsStream("/" + propertiesName);
	}

	private static InputStream getClasspathInputStream(String propertiesName) {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesName);
	}

}
