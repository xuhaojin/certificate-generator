package com.x.certificate.path.domain;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import com.x.certificate.path.TempPathGenerator;

/** 
 * 证书临时文件路径
 * @author xuhaojin
 * @version [版本号, 2020年3月8日]
 */
public class CertificateTempPaths {

	private TempFilePath tempDoc;

	private TempFilePath tempPdf;

	private TempFilePath tempImage;

	public static CertificateTempPaths newInstance(String docSuffix, String pdfSuffix, String imageSuffix) {
		List<TempFilePath> tempFilePaths = TempPathGenerator.generateTempPaths(docSuffix, pdfSuffix, imageSuffix);
		createTempFiles(tempFilePaths);
		return new CertificateTempPaths(tempFilePaths);
	}

	public static void createTempFiles(List<TempFilePath> tempFilePaths) {
		for (TempFilePath tempFilePath : tempFilePaths) {
			createTempFile(tempFilePath);
		}
	}

	public static void createTempFile(TempFilePath tempFilePath) {
		try {
			File path = new File(tempFilePath.getPath());
			if (!path.exists()) {
				path.mkdirs();
			}

			File tempFile = new File(tempFilePath.getPathName());
			if (!tempFile.exists()) {
				tempFile.createNewFile();
			}
		} catch (IOException | SecurityException | NullPointerException e) {
			e.printStackTrace();
		}
	}

	public boolean deleteTempFiles() {
		boolean docResult = deleteTempFile(this.tempDoc);
		boolean pdfResult = deleteTempFile(this.tempPdf);
		boolean imageResult = deleteTempFile(this.tempImage);
		return docResult && pdfResult && imageResult;
	}

	public boolean deleteTempFile(TempFilePath tempPath) {
		return deleteTempFile(tempPath.getPathName());
	}

	public boolean deleteTempFile(String filePath) {
		try {
			File tempFile = new ClassPathResource(filePath).getFile();
			if (tempFile.exists()) {
				FileUtils.deleteQuietly(tempFile);
				FileUtils.deleteQuietly(tempFile.getParentFile());
			}
		} catch (NullPointerException | SecurityException | IOException e) {
			return false;
		}

		return true;
	}

	public CertificateTempPaths(List<TempFilePath> tempFilePaths) {
		this(tempFilePaths.get(0), tempFilePaths.get(1), tempFilePaths.get(2));
	}

	public CertificateTempPaths(TempFilePath tempDoc, TempFilePath tempPdf, TempFilePath tempImage) {
		super();
		this.tempDoc = tempDoc;
		this.tempPdf = tempPdf;
		this.tempImage = tempImage;
	}

	public String getTempDocDirPath() {
		return tempDoc.getPath();
	}

	public String getTempDocPathName() {
		return tempDoc.getPathName();
	}

	public String getTempPdfDirPath() {
		return tempPdf.getPath();
	}

	public String getTempPdfPathName() {
		return tempPdf.getPathName();
	}

	public String getTempImagePath() {
		return tempImage.getPath();
	}

	public String getTempImagePathName() {
		return tempImage.getPathName();
	}

}
