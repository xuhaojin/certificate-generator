package com.x.certificate.doc.domain;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;

/** 
 * 证书模板中的所有字段对应的自定义数据，包含字段关键字、自定义内容、字体等
 * @author xuhaojin
 * @version [版本号, 2020年3月15日]
 */
public class CertificateData {

	private Map<String, CertificateField> key2CerticateField = Maps.newConcurrentMap();

	public Map<String, CertificateField> put(CertificateField value) {
		return put(value.getKey(), value);
	}

	public Map<String, CertificateField> put(String key, CertificateField value) {
		key2CerticateField.put(key, value);
		return key2CerticateField;
	}

	public CertificateField getValue(String key) {
		return this.key2CerticateField.get(key);
	}

	public Set<String> getKeys() {
		return this.key2CerticateField.keySet();
	}

	public Map<String, CertificateField> getKey2CerticateField() {
		return key2CerticateField;
	}

	public void setKey2CerticateField(Map<String, CertificateField> key2CerticateField) {
		this.key2CerticateField = key2CerticateField;
	}

}
