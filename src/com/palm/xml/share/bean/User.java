package com.palm.xml.share.bean;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * required可选的非强制性的元素或属性
 * 
 * @author weixiang.qin
 * 
 */
@Root
public class User {
	@Element
	private String userId;
	@Element
	private String username;
	@ElementList(name = "permissions", entry = "permission", inline = false)
	private ArrayList<String> permissions;
	// ArrayList去掉class="java.util.ArrayList"
	// inline节点是否在一行
	@ElementList(inline = false)
	private ArrayList<Bank> banks;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(ArrayList<String> permissions) {
		this.permissions = permissions;
	}

	public List<Bank> getBanks() {
		return banks;
	}

	public void setBanks(ArrayList<Bank> banks) {
		this.banks = banks;
	}

}
