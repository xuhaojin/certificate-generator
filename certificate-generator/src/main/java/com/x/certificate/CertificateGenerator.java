package com.x.certificate;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.XmlException;
import org.springframework.core.io.ClassPathResource;

import com.x.certificate.doc.DocOperator;
import com.x.certificate.doc.domain.CertificateData;
import com.x.certificate.doc.domain.CertificateField;
import com.x.certificate.path.TempPathGenerator;
import com.x.certificate.path.domain.TempFilePath;
import com.x.certificate.properties.PropertiesReader;

/** 
 * 证件图片生成器
 * @author xuhaojin
 * @version [版本号, 2020年3月24日]
 */
public class CertificateGenerator {

	public static void generate(CertificateData data) throws IOException, XmlException {
		// 获取生成证书预设参数
		Properties properties = PropertiesReader.getProperties("config\\certificate.properties");
		String officePath = properties.getProperty("libreoffice.path");
		String imageSuffix = properties.getProperty("certificate.image.suffix");
		String imageScale = properties.getProperty("certificate.image.scale");

		// 获取证书模板
		File docxTemplate = new ClassPathResource("template\\template.docx").getFile();

		// 生成临时文件路径
		List<TempFilePath> tempPaths = TempPathGenerator.generateTempPaths("docx", "pdf", imageSuffix);

		// 复制证书模板，将字段替换为自定义数据
		String tempDocxPath = tempPaths.get(0).getPathName();
		DocOperator.toCumstomDoc(docxTemplate, tempDocxPath, data);

		// TODO 将doc模板转成pdf

		// TODO 将pdf转成证书图片

		// TODO 删除生成证书使用的临时文件

	}

	public static void generate(CertificateData data, String imageSuffix) {

	}

	public static String addBlankSpace(String text) {
		StringBuffer sb = new StringBuffer();

		if (text == null) {
			return null;
		}

		char[] chars = text.toCharArray();

		String regex = "[\u4E00-\u9FA5]{1}";
		for (char aChar : chars) {
			String str = aChar + "";
			if (StringUtils.isBlank(str)) {
				continue;
			}

			sb.append(aChar);

			if (str.matches(regex)) {
				sb.append(" ");
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) throws IOException, XmlException {
		// String templatePath = "C:\\Users\\a1579\\Desktop\\template.docx";
		// String outputPath = "C:\\Users\\a1579\\Desktop\\custom.docx";
		CertificateData data = new CertificateData();
		data.put(new CertificateField("持证人", addBlankSpace("张三"), 34));
		data.put(new CertificateField("证书中文信息", "祝贺您完成\"直升机飞行员岗位资质\"培训课程。特发此证！", 18));
		data.put(new CertificateField("证书英文信息",
				"Congratulations on completion of training program of \"Helicopter Pilot Qualification\"", 15));
		data.put(new CertificateField("证书编号", "100224512", 18));
		data.put(new CertificateField("证书签名", addBlankSpace("李四"), 25));
		data.put(new CertificateField("证书日期", "2020年3月21日", 15));
		generate(data);
	}

}
