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
				log.info("文件加载异常"+filePath);
			}
		}else {
			log.info("文件不存在：");
		}
	}
	
	public Element getElementObject(String elementPath) {
		return (Element) document.selectSingleNode(elementPath);
	}
	
	/**
	* 用xpath来获取一组元素节点对象
	* @param elementPath
	* @return
	*/
	@SuppressWarnings("unchecked")
	public List<Element> getElementObjects(String elementPath){
		return document.selectNodes(elementPath);
	}

	/**
	* 根据Element来获取该节点下的所有的子结点的信息
	* 且返回值中以子结点名称为key,子结点的text为value
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
	* 用xpath来判断一个结点对象是否存在
	*/
	public boolean isExist(String elementPath) {
		boolean flag = false;
		Element element = this.getElementObject(elementPath);
		if (element!=null) flag = true;
		return flag;
	}
	
	/**
	* 用xpath来取得一个结点对象的值
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
