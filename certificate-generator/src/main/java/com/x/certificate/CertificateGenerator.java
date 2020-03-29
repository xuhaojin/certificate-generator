package com.x.certificate;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.XmlException;

import com.x.certificate.doc.domain.CertificateData;
import com.x.certificate.doc.domain.CertificateField;

/** 
 * 证件图片生成器
 * @author xuhaojin
 * @version [版本号, 2020年3月24日]
 */
public class CertificateGenerator {

	public static void generate(CertificateData data) throws IOException {
		// TODO 获取生成证书预设参数
		
		// TODO 获取证书模板
		
		// TODO 生成临时文件路径
		
		// TODO 复制证书模板，将字段替换为自定义数据
		
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
