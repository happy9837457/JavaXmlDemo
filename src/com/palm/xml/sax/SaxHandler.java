package com.palm.xml.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.palm.xml.UserUtil;
import com.palm.xml.share.bean.Bank;
import com.palm.xml.share.bean.User;

/**
 * 标签处理类
 * 
 * @author weixiang.qin
 * 
 */
public class SaxHandler extends DefaultHandler {
	public User user = new User();
	private String curElement;
	private Attributes curAttributes;
	public List<String> permissions;
	public List<Bank> banks;
	public Bank bank;
	private boolean isStart = false;

	@Override
	// 开始解析xml时调用此方法
	public void startDocument() throws SAXException {
		super.startDocument();
//		System.out.println("开始解析xml时调用此方法");
	}

	@Override
	// 遇到开始元素时会调用此方法
	// 元素中的属性存放在Attributes中
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		curElement = name;
		curAttributes = attributes;
		isStart = true;
	}

	@Override
	// 遇到标签中内容时调用此方法
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(!isStart){
			return;
		}
		String content = new String(ch, start, length);
		if ("userId".equals(curElement)) {
			user.setUserId(content);
		} else if ("username".equals(curElement)) {
			user.setUsername(content);
		} else if ("permissions".equals(curElement)) {
			permissions = new ArrayList<String>();
		} else if ("permission".equals(curElement)) {
			permissions.add(content);
		} else if ("banks".equals(curElement)) {
			banks = new ArrayList<Bank>();
		} else if ("bank".equals(curElement)) {
			bank = new Bank();
			bank.setType(curAttributes.getValue("type"));
		} else if ("bankId".equals(curElement)) {
			bank.setBankId(content);
		} else if ("bankName".equals(curElement)) {
			bank.setBankName(content);
		}
//		System.out.println(new String(ch, start, length));
	}

	@Override
	// 遇到结束元素时会调用此方法
	public void endElement(String uri, String localName, String name)
			throws SAXException {
		if ("permissions".equals(name)) {
			user.setPermissions((ArrayList<String>) permissions);
		} else if ("bank".equals(name)) {
			banks.add(bank);
		} else if ("banks".equals(name)) {
			user.setBanks((ArrayList<Bank>) banks);
		}
		isStart = false;
	}

	@Override
	// 结束解析xml时调用此方法
	public void endDocument() throws SAXException {
		super.endDocument();
//		System.out.println("结束解析xml时调用此方法");
		UserUtil.printUser(user);
	}
}
