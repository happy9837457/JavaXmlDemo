package com.palm.xml.dom4j;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.palm.xml.share.bean.Bank;
import com.palm.xml.share.bean.User;

/**
 * dom4j解析xml
 * 
 * @author weixiang.qin
 * 
 */
public class Dom4jParser {
	/**
	 * xml转换成user对象
	 * 
	 * @param xml
	 * @return
	 * @throws DocumentException
	 */
	@SuppressWarnings("unchecked")
	public static User convertXmlToUser(String xml) throws DocumentException {
		Document doc = DocumentHelper.parseText(xml);
		Element root = doc.getRootElement();
		// node.selectNodes("*") 获得所有子节点
		// node.selectNodes("@*") 获得所有节点属性
		// node.selectNodes("@className") 获得节点名为className的属性
		User user = new User();
		user.setUserId(root.selectSingleNode("userId").getStringValue());
		user.setUsername(root.selectSingleNode("username").getStringValue());
		List<Node> permissionNodes = root
				.selectNodes("//permissions/permission");
		List<String> permissions = new ArrayList<String>();
		for (Node permissionNode : permissionNodes) {
			permissions.add(permissionNode.getText());
		}
		user.setPermissions((ArrayList<String>) permissions);
		List<Node> bankNodes = root.selectNodes("//banks/bank");
		List<Bank> banks = new ArrayList<Bank>();
		for (Node bankNode : bankNodes) {
			banks.add(new Bank(bankNode.selectSingleNode("bankId").getText(),
					bankNode.selectSingleNode("bankName").getText()));
		}
		user.setBanks((ArrayList<Bank>) banks);
		return user;
	}

	/**
	 * user对象转换成xml
	 * 
	 * @param user
	 * @param needFormat
	 * @return
	 * @throws IOException
	 */
	public static String convertUserToXml(User user, boolean needFormat)
			throws IOException {
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("user");
		root.addElement("userId").addText(user.getUserId());
		root.addElement("userName").addText(user.getUsername());
		List<Bank> banks = user.getBanks();
		Element banksElement = root.addElement("banks");
		for (Bank bank : banks) {
			Element bankElement = banksElement.addElement("bank");
			bankElement.addElement("bankId").addText(bank.getBankId());
			bankElement.addElement("bankName").addText(bank.getBankName());
		}
		StringWriter writer = new StringWriter();
		XMLWriter xmlWriter = null;
		if (needFormat) {
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			format.setNewLineAfterDeclaration(false);
			xmlWriter = new XMLWriter(writer, format);
			xmlWriter.write(doc);
		} else {
			xmlWriter = new XMLWriter(writer);
			xmlWriter.write(doc);
		}
		return writer.toString();
	}

}
