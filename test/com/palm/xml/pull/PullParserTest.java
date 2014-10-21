package com.palm.xml.pull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.palm.xml.UserUtil;
import com.palm.xml.share.bean.User;

public class PullParserTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReadXml() {
		String filePath = "/Users/lottery/Desktop/result.xml";
		User user = PullParser.readXml(filePath);
		UserUtil.printUser(user);
	}

	@After
	public void tearDown() throws Exception {
	}

}
