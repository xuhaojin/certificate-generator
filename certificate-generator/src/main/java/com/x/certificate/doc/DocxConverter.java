package com.x.certificate.doc;

import java.io.File;
import java.io.IOException;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

/** 
 * 用于docx文件的格式转换
 * @author xuhaojin
 * @version [版本号, 2020年3月22日]
 */
public class DocxConverter {

	/**
	 * 使用libreoffice服务，将docx格式文件转成pdf格式文件
	 * @param docxPath
	 * @param pdfPath
	 * @param libreOfficePath
	 * @return
	 * @throws IOException    参数
	 * File    返回类型
	 */
	public static File toPdfUsingLibreOffice(String docxPath, String pdfPath, String libreOfficePath)
			throws IOException {
		File pdf = new File(pdfPath);

		try {
			OfficeManager officeManager = getOfficeManager(libreOfficePath);
			OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
			converter.convert(new File(docxPath), pdf);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pdf;
	}

	public static OfficeManager getOfficeManager(String libreOfficePath) {
		OfficeManager officeManager = new DefaultOfficeManagerConfiguration().setOfficeHome(new File(libreOfficePath))
				.buildOfficeManager();
		officeManager.start();
		return officeManager;
	}

	public static void main(String[] args) throws IOException {
		String inputFile = "C:\\Users\\a1579\\Desktop\\custom.docx";
		String outputFile = "C:\\Users\\a1579\\Desktop\\custom.pdf";
		String librePath = "D:\\libreoffice";
		toPdfUsingLibreOffice(inputFile, outputFile, librePath);
	}

}
