package com.palm.xml.simple;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 * simple框架解析xml
 * 
 * @author weixiang.qin
 * 
 */
public class SimpleParser {
	/**
	 * 对象转换成string
	 * 
	 * @param obj
	 * @return
	 */
	public static String convertObjectToXmlString(Object obj) {
		try {
			Serializer serializer = new Persister();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			serializer.write(obj, baos);
			return baos.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 对象转换输出到文件
	 * 
	 * @param obj
	 * @param file
	 * @return
	 */
	public static boolean convertObjectToXmlFile(Object obj, File file) {
		try {
			Serializer serializer = new Persister();
			serializer.write(obj, file);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * xml字符串解析
	 * 
	 * @param <T>
	 * 
	 * @param xml
	 * @param cls
	 * @return
	 */
	public static <T> T convertXmlToObjectFromString(String xml, Class<T> cls) {
		try {
			Serializer serializer = new Persister();
			return serializer.read(cls, xml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * xml文件解析
	 * 
	 * @param xml
	 * @param cls
	 * @return
	 */
	public static <T> T convertXmlToObjectFromFile(File file, Class<T> cls) {
		try {
			Serializer serializer = new Persister();
			return serializer.read(cls, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
