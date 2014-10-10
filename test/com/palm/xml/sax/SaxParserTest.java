package com.palm.xml.sax;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaxParserTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReadXml() {
		String filePath = "/Users/lottery/Desktop/result.xml";
		SaxParser.readXml(filePath);
	}

	@After
	public void tearDown() throws Exception {
	}

}
