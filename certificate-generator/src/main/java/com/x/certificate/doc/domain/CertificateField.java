package com.x.certificate.doc.domain;

import org.apache.commons.lang3.StringUtils;

/** 
 * 证书doc模板中的一个字段信息
 * @author xuhaojin
 * @version [版本号, 2020年3月15日]
 */
public class CertificateField {

	private String key;

	private String content;

	private Integer fontSize;

	private String fontFamily;

	private Boolean isBold = false;

	public CertificateField() {
		this(null, null);
	}

	public CertificateField(String key, String content) {
		this(key, content, null, null);
	}

	public CertificateField(String key, String content, Integer fontSize, String fontFamily) {
		this(key, content, fontSize, fontFamily, false);
	}

	public CertificateField(String key, String content, Integer fontSize, String fontFamily, Boolean isBold) {
		super();
		this.key = key;
		this.content = (StringUtils.isEmpty(content) ? "" : content);
		this.fontSize = (fontSize == null ? 24 : fontSize);
		this.fontFamily = (StringUtils.isEmpty(fontFamily) ? "" : fontFamily);
		this.isBold = (isBold == null ? false : isBold);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getFontSize() {
		return fontSize;
	}

	public void setFontSize(Integer fontSize) {
		this.fontSize = fontSize;
	}

	public String getFontFamily() {
		return fontFamily;
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}

	public Boolean getIsBold() {
		return isBold;
	}

	public void setIsBold(Boolean isBold) {
		this.isBold = isBold;
	}

}
