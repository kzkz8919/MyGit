package com.dataProvider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestData {

	// @Test(dataProvider="dataProvider",dataProviderClass=DataSource.class)
	// public void testDemo(int a,int b){
	// int sum = a+b;
	// System.out.println("this is sum: "+sum);
	// }

	@DataProvider()
	public Object[][] dataProvider(Method method) {
		System.out.println(method.getName());
		return new Object[][] { { 1, 2 }, { 3, 4 } };
	}

	@Test(dataProvider="dataProvider")
	public void testDemo(int a, int b) {
		int sum = a + b;
		System.out.println("this is sum:" + sum);
	}
}
