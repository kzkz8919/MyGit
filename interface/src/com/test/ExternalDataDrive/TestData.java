package com.test.ExternalDataDrive;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.operate.xml.ParseXml;

public class TestData {

	private String fileName;
	private ParseXml px;

	public TestData(String fileName) {
		this.fileName = fileName;
		px = new ParseXml("test-data" + File.separator + this.fileName + ".xml");
	}

	public List<Map<String, String>> getTestMethodData(String methodName) {
		List<Element> elements = px.getElementObjects("/*/" + methodName);
		// 根据方法名找出所有的与方法名相同的节点对象
		List<Map<String, String>> listData = new ArrayList<Map<String, String>>();
		for (Element element : elements) {
			Map<String, String> dataMap = px.getChildrenInfoByElement(element);
			// 根据方法名节点对象找出其所有的子节点的信息
			listData.add(dataMap);
		}
		return listData;
	}

	public static void main(String[] args) {
		TestData td = new TestData("TestDemo");
		List<Map<String, String>> testDemo = td.getTestMethodData("testDemo");
		System.out.println(testDemo.get(0).get("username"));
	}
}
