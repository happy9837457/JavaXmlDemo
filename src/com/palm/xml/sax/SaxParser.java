package com.palm.xml.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * sax解析xml
 * 
 * @author weixiang.qin
 * 
 */
public class SaxParser {
	/**
	 * 
	 * @param filePath
	 */
	public static void readXml(String filePath) {
		XMLReader xmlReader = null;
		try {
			// 解析工厂
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(false);
			SAXParser saxParser = factory.newSAXParser();
			xmlReader = saxParser.getXMLReader();
			// 设置解析器 当发现一个标签，由SaxHandler类中的回调方法处理
			xmlReader.setContentHandler(new SaxHandler());
			InputSource source = new InputSource(filePath);
			xmlReader.parse(source);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
