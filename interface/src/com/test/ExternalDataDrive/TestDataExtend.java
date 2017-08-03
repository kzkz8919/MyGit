package com.test.ExternalDataDrive;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.operate.xml.ParseXml;

public class TestDataExtend {

	private String fileName;
	private ParseXml px;
	private Map<String, String> commonData;

	public TestDataExtend(String fileName) {
		this.fileName = fileName;
		px = new ParseXml("test-data" + File.separator + this.fileName + ".xml");
	}

	public List<Map<String, String>> getTestMethodData(String methodName) {
		List<Element> elements = px.getElementObjects("/*/" + methodName);
		// ���ݷ������ҳ����е��뷽������ͬ�Ľڵ����
		List<Map<String, String>> listData = new ArrayList<Map<String, String>>();
		for (Element element : elements) {
			Map<String, String> dataMap = px.getChildrenInfoByElement(element);
			// ���ݷ������ڵ�����ҳ������е��ӽڵ����Ϣ
			Map<String, String> data = this.getMergeMapData(dataMap, this.getCommonData());
			//�ϲ����Է�����common������
			listData.add(data);
		}
		return listData;
	}

	public Map<String, String> getCommonData() {
		if (commonData == null) {
			try {
				Element element = px.getElementObject("/*/common");
				commonData = px.getChildrenInfoByElement(element);
			} catch (Exception e) {
				commonData = null;
			}
		}
		return commonData;
	}

	private Map<String, String> getMergeMapData(Map<String, String> map1, Map<String, String> map2) {
		if (map2 == null) {
			return map1;
		}

		Iterator<String> it = map2.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = map2.get(key);
			if (!map1.containsKey(key)) {
				map1.put(key, value);
			}
		}
		return map1;
	}

	public static void main(String[] args) {
		TestData td = new TestData("TestDemo");
		List<Map<String, String>> testDemo = td.getTestMethodData("testDemo");
		System.out.println(testDemo.get(0).get("username"));
	}
}
