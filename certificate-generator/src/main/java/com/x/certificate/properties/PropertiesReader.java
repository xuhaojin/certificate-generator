package com.x.certificate.properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

/** 
 * 读取properties文件的配置
 * @author xuhaojin
 * @version [版本号, 2020年3月23日]
 */
public class PropertiesReader {

	public static String getConfig(String pathInDemo, String key) throws IOException {
		return getProperties(pathInDemo).getProperty(key);
	}

	public static Properties getProperties(String pathInDemo) throws IOException {
		Properties properties = new Properties();

		ClassPathResource classPathResource = new ClassPathResource(pathInDemo);

		File file = classPathResource.getFile();

		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			properties.load(bufferedReader);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

	public static Properties getProperties2(String pathInDemo) throws IOException {
		Properties properties = new Properties();

		String path = System.getProperty("user.dir") + "/src/main/resources/" + pathInDemo;
		
		File file = new File(path);

		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			properties.load(bufferedReader);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("libreoffice.path=" + getConfig("config\\certificate.properties", "libreoffice.path"));
		System.out.println(
				"certificate.image.suffix=" + getConfig("config\\certificate.properties", "certificate.image.suffix"));
	}

}
