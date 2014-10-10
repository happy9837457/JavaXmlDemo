package com.palm.xml.share.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文件工具类
 * 
 * @author weixiang.qin
 * 
 */
public class FileUtil {
	/**
	 * 生成文件
	 * 
	 * @param path
	 * @param key
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void write(String path, String key)
			throws FileNotFoundException, IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream(path));
		out.writeBytes(key);
		out.close();
	}

	/**
	 * 读取文件
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String read(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		StringBuffer buffer = new StringBuffer();
		String line = br.readLine();
		while (line != null) {
			buffer.append(line);
			line = br.readLine();
		}
		return buffer.toString();
	}
}
