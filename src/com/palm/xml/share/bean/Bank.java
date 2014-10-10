package com.palm.xml.share.bean;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 
 * @author weixiang.qin
 * 
 */
@Root
public class Bank {
	@Element
	private String bankId;
	@Element
	private String bankName;

	public Bank() {
	}

	public Bank(String bankId, String bankName) {
		this.bankId = bankId;
		this.bankName = bankName;
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
