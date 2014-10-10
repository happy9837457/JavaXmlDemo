package com.palm.xml.dom4j;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.palm.xml.UserUtil;
import com.palm.xml.share.bean.User;
import com.palm.xml.share.util.FileUtil;

public class Dom4jParserTest {
	private User user;

	@Before
	public void setUp() throws Exception {
		user = UserUtil.createUser();
	}

	@Test
	public void testConvertXmlToUser() throws DocumentException, IOException {
		User user = Dom4jParser.convertXmlToUser(FileUtil
				.read("/Users/lottery/Desktop/result.xml"));
		UserUtil.printUser(user);
	}

	@Test
	public void testConvertUserToXml() throws IOException {
		String result = Dom4jParser.convertUserToXml(user, true);
		System.out.println(result);
	}

	@After
	public void tearDown() throws Exception {
	}

}
