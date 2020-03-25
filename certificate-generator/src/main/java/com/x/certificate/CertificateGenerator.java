package com.x.certificate;

import java.io.IOException;
import java.util.Properties;

import com.x.certificate.properties.PropertiesReader;

/** 
 * 证件图片生成器
 * @author xuhaojin
 * @version [版本号, 2020年3月24日]
 */
public class CertificateGenerator {

	public static void generate() throws IOException {
		Properties properties = PropertiesReader.getProperties("config\\certificate.properties");
		String libreofficePath = properties.getProperty("libreoffice.path");
		String imageSuffix = properties.getProperty("certificate.image.suffix");
	}

	public static void generate(String docPath, String imagePath, String imageSuffix) {

	}

}
