package com.dataProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
	@DataProvider
	public Object[][] dataProvider(){
		return new Object[][]{{1,2},{3,4}};
	}
	
	@Test(dataProvider="dataProvider")
	public void testDemo(int a,int b){
		int sum = a+b;
		System.out.println("this is sum:"+sum);
	}
	
	
	
}
