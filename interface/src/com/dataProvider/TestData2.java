package com.dataProvider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestData2 {

	@DataProvider
	public Object[][] dataProvider(Method method) {
		System.out.println(method.getName());
		DataSource2 data = new DataSource2();
		Object[][] obj = data.dataSource2().get(method.getName());
		return obj;

	}

	@Test(dataProvider="dataProvider")
	public void testDemo(int a,int b){
		int sum = a + b;
		System.out.println("this is sum: "+sum);
	}
	
	@Test(dataProvider="dataProvider")
	public void testDemo1(int a,int b){
		int sum = a + b;
		System.out.println("this is sum: "+sum);
	}
}
