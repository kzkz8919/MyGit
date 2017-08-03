package com.dataProvider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestData3 {

	@DataProvider
	public Object[][] dataProvider(Method method){
		DataSource3 data = new DataSource3();
		Object[][] obj = data.dataSource().get(method.getName());
		return obj;
	}
	
	@Test(dataProvider="dataProvider")
	public void testDemo(TestEnum te){
		System.out.println("retCode is: "+ te.getRetCode()+"retMsg is: "+te.getRetMsg());
	}
	
	@Test(dataProvider="dataProvider")
	public void testDemo1(int a,int b){
		int sum = a + b;
		System.out.println("this is sum :"+sum);
	}
	
}
