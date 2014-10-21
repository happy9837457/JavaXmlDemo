package com.palm.xml.pull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.palm.xml.share.bean.Bank;
import com.palm.xml.share.bean.User;

/**
 * pull解析xml
 * 
 * @author weixiang.qin
 * 
 */
public class PullParser {
	/**
	 * 读取xml
	 * 
	 * @param filePath
	 */
	public static User readXml(String filePath) {
		User user = new User();
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();
			parser.setInput(new FileInputStream(new File(filePath)), "UTF-8");
			ArrayList<String> permissions = null;
			ArrayList<Bank> banks = null;
			Bank bank = null;
			int event = parser.getEventType();
			while (event != XmlPullParser.END_DOCUMENT) {
				String nodeName = parser.getName();
				switch (event) {
				case XmlPullParser.START_DOCUMENT:
					break;
				case XmlPullParser.START_TAG:
					if ("userId".equals(nodeName)) {
						user.setUserId(parser.nextText());
					} else if ("username".equals(nodeName)) {
						user.setUsername(parser.nextText());
					} else if ("permissions".equals(nodeName)) {
						permissions = new ArrayList<String>();
					} else if ("permission".equals(nodeName)) {
						permissions.add(parser.nextText());
					} else if ("banks".equals(nodeName)) {
						banks = new ArrayList<Bank>();
					} else if ("bank".equals(nodeName)) {
						bank = new Bank();
						bank.setType(parser.getAttributeValue(0));
					} else if ("bankId".equals(nodeName)) {
						bank.setBankId(parser.nextText());
					} else if ("bankName".equals(nodeName)) {
						bank.setBankName(parser.nextText());
					}
					break;
				case XmlPullParser.END_TAG:
					if ("permissions".equals(nodeName)) {
						user.setPermissions(permissions);
					} else if ("bank".equals(nodeName)) {
						banks.add(bank);
					} else if ("banks".equals(nodeName)) {
						user.setBanks(banks);
					}
					break;
				}
				event = parser.next();
			}
			return user;
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
