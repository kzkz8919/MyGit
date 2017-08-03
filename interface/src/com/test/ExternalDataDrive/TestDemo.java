package com.test.ExternalDataDrive;

import java.util.Map;

import org.testng.annotations.Test;

public class TestDemo extends TestBase{

	@Test(dataProvider="dataProvider")
	public void testDemo(Map<String,String> param){
		System.out.println(param.get("username"));
		System.out.println(param.get("password"));
		System.out.println(param.get("inputValue"));
	}

}
