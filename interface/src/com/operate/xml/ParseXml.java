package com.operate.xml;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import log4j.Log;


public class ParseXml {

	private String filePath;
	private Document document;
	private Log log;
	
	public ParseXml(String filePath) {

		this.filePath = filePath;
		this.load(this.filePath);
	}

	private void load(String filePath) {

		File file = new File(filePath);
		if (file.exists()) {
			SAXReader saxReader = new SAXReader();
			try {
				document = saxReader.read(file);
			} catch (DocumentException e) {
				log.info("�ļ������쳣"+filePath);
			}
		}else {
			log.info("�ļ������ڣ�");
		}
	}
	
	public Element getElementObject(String elementPath) {
		return (Element) document.selectSingleNode(elementPath);
	}
	
	/**
	* ��xpath����ȡһ��Ԫ�ؽڵ����
	* @param elementPath
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<Element> getElementObjects(String elementPath){
		return document.selectNodes(elementPath);
	}

	/**
	* ����Element����ȡ�ýڵ��µ����е��ӽ�����Ϣ
	* �ҷ���ֵ�����ӽ������Ϊkey,�ӽ���textΪvalue
	* @param element
	* @return
	*/
	@SuppressWarnings("unchecked")
	public Map<String, String> getChildrenInfoByElement(Element element){
		Map<String, String> map = new HashMap<String,String>();
		List<Element> chidren = element.elements();
		for (Element e:chidren){
			map.put(e.getName(), e.getText());
		}
		return map;
		
	}
	
	/**
	* ��xpath���ж�һ���������Ƿ����
	*/
	public boolean isExist(String elementPath) {
		boolean flag = false;
		Element element = this.getElementObject(elementPath);
		if (element!=null) flag = true;
		return flag;
	}
	
	/**
	* ��xpath��ȡ��һ���������ֵ
	*/
	

	public String getElementText(String elementPath) {
		Element element = this.getElementObject(elementPath);
		if(element!=null){
			return element.getText().trim();
		}else{
			return null;
		}
	}
	
	
	
	
	
//	public static void main(String[] args) {
//		ParseXml parseXml = new ParseXml("config/TestIP.xml");
//		List<Element> elements = parseXml.getElementObjects("/*/testIP");
//		Object[][] object  = new Object[elements.size()][];
//		for (int i = 0; i < elements.size(); i++) {
//			Object[] temp = new Object[]{parseXml.getChildrenInfoByElement(elements.get(i))};
//			object[i] = temp;
//		}
//		System.out.println(object[0][0]);
//	}










}
