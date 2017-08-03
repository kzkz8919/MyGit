package com.test.ExternalDataDrive;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class TestBase {

	private TestData td;

	private void initailTestData() {
		if (td == null) {
			td = new TestData(this.getClass().getSimpleName());
			// 将测试类名传给TestData，从而找到对应的XML文件
			System.out.println(td);
		}
	}

	@DataProvider
	public Object[][] dataProvider(Method method) {
		this.initailTestData();
		List<Map<String, String>> listData = td.getTestMethodData(method.getName());
		Object[][] object = new Object[listData.size()][];
		for (int i = 0; i < object.length; i++) {
			object[i] = new Object[] { listData.get(i) };
			// 最后返回的数据结构为{{Map<String,String>},{Map<String,String>}}
		}
		return object;
	}

}
