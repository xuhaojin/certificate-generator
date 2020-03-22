package com.x.certificate.pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/** 
 * 用于pdf文件的格式转换
 * @author xuhaojin
 * @version [版本号, 2020年3月22日]
 */
public class PdfConverter {

	@SuppressWarnings("unchecked")
	public static File toImageUsingPdfbox(String pdfPath, String imagePath, String imageExt) {
		File out = null;

		try {
			File imagePathFile = new File(getPath(imagePath));
			if (!imagePathFile.exists()) {
				imagePathFile.mkdirs();
			}
			
			PDDocument document = PDDocument.load(new File(pdfPath));
			List<PDPage> list = document.getDocumentCatalog().getAllPages();
			BufferedImage image = list.get(0).convertToImage();
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
		String pdfPath = "C:\\Users\\a1579\\Desktop\\1.pdf";
		String imagePath = "C:\\Users\\a1579\\Desktop\\1.jpg";
		toImageUsingPdfbox(pdfPath, imagePath, "jpg");
		System.out.println("所用时间：" + (System.currentTimeMillis() - startTime) + "ms");
	}

}
