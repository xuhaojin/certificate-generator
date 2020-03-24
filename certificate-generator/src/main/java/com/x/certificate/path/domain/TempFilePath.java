package com.x.certificate.path.domain;

/** 
 * 临时文件路径
 * @author xuhaojin
 * @version [版本号, 2020年3月8日]
 */
public class TempFilePath {

	/**
	 * 文件路径，例如/a
	 */
	private String path;

	/**
	 * 文件名称，例如b.txt
	 */
	private String name;

	public TempFilePath(String path, String name) {
		super();
		this.path = path;
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public String getName() {
		return this.name;
	}

	public String getPathName() {
		return this.path + "/" + this.name;
	}

	@Override
	public String toString() {
		return getPathName();
	}

}
