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
//		File file = new File("config/config.properties");// ����·������File����
//		Properties p = new Properties();// ����Properties����
//		InputStream in = null;
//		try {
//			in = new FileInputStream(file);// ��File����ת��������
//			p.load(in);// ��������Properties����
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
//		System.out.println(p.getProperty("base.url"));// ���http://www.baidu.com
//		System.out.println(p.getProperty("base.url1"));// ���null
//		/**
//		 * �ڶ���������ָgetProperty�������ص�Ĭ��ֵ��
//		 * �����config.properties�ļ���û��base.url1���key,��ô�����Ĭ�ς�
//		 * Ҳ���ǻ����http://cn.bing.com/
//		 */
//		System.out.println(p.getProperty("base.url1", "http://cn.bing.com/"));// ���http://cn.bing.com/
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
