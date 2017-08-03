package com.config.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	public void getProperties() {
		File file = new File("config/config.properties");
		Properties p = new Properties();
		InputStream in = null;
		try {
			in =new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			p.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (in!=null) {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(p.getProperty("base.url"));
		System.out.println(p.getProperty("base.url1"));
		System.out.println(p.getProperty("base.url1","http://cn.bing.com/"));
	}
//	public void getProperties() {
//		File file = new File("config/config.properties");// 根据路径生成File对象
//		Properties p = new Properties();// 生成Properties对象
//		InputStream in = null;
//		try {
//			in = new FileInputStream(file);// 将File对象转成流对象
//			p.load(in);// 加载流至Properties对象
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		} finally {
//			try {
//				if (in != null) {
//					in.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println(p.getProperty("base.url"));// 输出http://www.baidu.com
//		System.out.println(p.getProperty("base.url1"));// 输出null
//		/**
//		 * 第二个参数是指getProperty方法返回的默认值，
//		 * 如果在config.properties文件中没有base.url1这个key,那么将输出默认傎
//		 * 也就是会输出http://cn.bing.com/
//		 */
//		System.out.println(p.getProperty("base.url1", "http://cn.bing.com/"));// 输出http://cn.bing.com/
//	}
//
//	public static void main(String[] args) {
//		PropertiesUtil p = new PropertiesUtil();
//		p.getProperties();
//	}
	
	public static void main(String[] args){
		PropertiesUtil p = new PropertiesUtil();
		p.getProperties();
	}
}
