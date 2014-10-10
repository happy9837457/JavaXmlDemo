package com.palm.xml.simple;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.palm.xml.UserUtil;
import com.palm.xml.share.bean.User;

public class SimpleParserTest {
	private User user;

	@Before
	public void setUp() throws Exception {
		user = UserUtil.createUser();
	}

//	@Test
	public void testConvertXmlToObjectFromString() {
		// object转换成xml
		String result = SimpleParser.convertObjectToXmlString(user);
		System.out.println(result);
		// xml转换成object
		User user = SimpleParser.convertXmlToObjectFromString(result, User.class);
		UserUtil.printUser(user);
	}

	@Test
	public void testConvertXmlToObjectFromFile() {
		File file = new File("/Users/lottery/Desktop/result.xml");
		// object转换成xml
		boolean result = SimpleParser.convertObjectToXmlFile(user, file);
		System.out.println("result:" + result);
		// xml转换成object
		User user = SimpleParser.convertXmlToObjectFromFile(file, User.class);
		UserUtil.printUser(user);
	}

	@After
	public void tearDown() throws Exception {
	}

}
