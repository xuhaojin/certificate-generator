package com.x.certificate.path;

import java.util.List;
import java.util.UUID;

import com.google.common.collect.Lists;
import com.x.certificate.path.domain.TempFilePath;

/** 
 * 生成临时文件
 * @author xuhaojin
 * @version [版本号, 2020年3月5日]
 */
public class TempPathGenerator {

	public static String tempFilePath = "/src/main/resources/tmp/";

	public static TempFilePath generateTempPath(String fileExt) {
		String path = System.getProperty("user.dir") + tempFilePath + fileExt + "/" + System.currentTimeMillis();
		String name = getId() + "." + fileExt;
		return new TempFilePath(path, name);
	}

	public static List<TempFilePath> generateTempPaths(String... fileExts) {
		List<TempFilePath> tempFilePaths = Lists.newArrayList();

		for (String fileExt : fileExts) {
			tempFilePaths.add(generateTempPath(fileExt));
		}

		return tempFilePaths;
	}

	public static String getId() {
		return UUID.randomUUID().toString().substring(0, 8);
	}

}
