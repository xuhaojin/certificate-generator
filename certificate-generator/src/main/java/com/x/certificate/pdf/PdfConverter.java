package com.x.certificate.pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

/** 
 * 用于pdf文件的格式转换
 * @author xuhaojin
 * @version [版本号, 2020年3月22日]
 */
public class PdfConverter {

	public static File toImageUsingPdfbox(String pdfPath, String imagePath, String imageExt) {
		File out = null;

		try (PDDocument document = PDDocument.load(new File(pdfPath));) {
			File imagePathFile = new File(getPath(imagePath));
			if (!imagePathFile.exists()) {
				imagePathFile.mkdirs();
			}
			PDFRenderer pdfRender = new PDFRenderer(document);
			BufferedImage image = pdfRender.renderImage(0, 2);
			out = new File(imagePath);
			ImageIO.write(image, imageExt, out);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return out;
	}

	public static String getPath(String pathName) {
		if (pathName.endsWith("\\") || pathName.endsWith("/")) {
			return pathName;
		}

		if (pathName.contains("\\")) {
			return pathName.substring(0, pathName.lastIndexOf('\\') + 1);
		}

		return pathName.substring(0, pathName.lastIndexOf('/') + 1);
	}

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		String pdfPath = "C:\\Users\\a1579\\Desktop\\custom.pdf";
		String imagePath = "C:\\Users\\a1579\\Desktop\\custom.jpg";
		toImageUsingPdfbox(pdfPath, imagePath, "jpg");
		System.out.println("所用时间：" + (System.currentTimeMillis() - startTime) + "ms");
	}

}
