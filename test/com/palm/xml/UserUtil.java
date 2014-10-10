package com.palm.xml;

import java.util.ArrayList;
import java.util.List;

import com.palm.xml.share.bean.Bank;
import com.palm.xml.share.bean.User;

/**
 * 
 * @author weixiang.qin
 * 
 */
public class UserUtil {
	/**
	 * 创建user
	 * 
	 * @return
	 */
	public static User createUser() {
		User user = new User();
		user.setUserId("10000001");
		user.setUsername("whoami");
		ArrayList<String> permissions = new ArrayList<String>();
		permissions.add("addUser");
		permissions.add("delUser");
		permissions.add("addNews");
		permissions.add("queryUser");
		user.setPermissions(permissions);
		ArrayList<Bank> banks = new ArrayList<Bank>();
		Bank bankA = new Bank();
		bankA.setBankId("101");
		bankA.setBankName("中国农业银行");
		banks.add(bankA);
		Bank bankB = new Bank();
		bankB.setBankId("102");
		bankB.setBankName("中国工商银行");
		banks.add(bankB);
		user.setBanks(banks);
		return user;
	}

	/**
	 * 输出user
	 * 
	 * @param user
	 */
	public static void printUser(User user) {
		StringBuffer sb = new StringBuffer();
		sb.append(user.getUserId()).append("\n").append(user.getUsername())
				.append("\n");
		List<String> permissions = user.getPermissions();
		for(String permission : permissions){
			sb.append(permission).append("\n");
		}
		List<Bank> banks = user.getBanks();
		for (Bank bank : banks) {
			sb.append(bank.getBankId()).append(" ").append(bank.getBankName())
					.append("\n");
		}
		System.out.println(sb.toString());
	}
}
