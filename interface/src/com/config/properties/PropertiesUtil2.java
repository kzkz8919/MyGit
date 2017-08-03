package com.config.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil2 {

	private static Properties p = null;
	
	private static String path ="config/config.properties";
	
	public static  void loadProperties(){
		if(p==null){
			p = new Properties();
			File file = new File(path);
			InputStream in =null;
			try {
				in = new FileInputStream(file);
				p.load(in);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if (in!=null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static String getProperties(String key){
		PropertiesUtil2.loadProperties();
		return p.getProperty(key);
	}
	
	
	public static String getProperties(String key,String deaultValue){
		PropertiesUtil2.loadProperties();
		return p.getProperty(key, deaultValue);
	}
	
	public static void main(String[] args) {


		System.out.println(PropertiesUtil2.getProperties("base.url"));
	}

}
