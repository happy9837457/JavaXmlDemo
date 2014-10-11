package com.palm.xml.share.bean;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 
 * @author weixiang.qin
 * 
 */
@Root
public class Bank {
	@Attribute
	private String type;
	@Element
	private String bankId;
	@Element
	private String bankName;

	public Bank() {
	}

	public Bank(String type, String bankId, String bankName) {
		this.type = type;
		this.bankId = bankId;
		this.bankName = bankName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}
