package com.dataProvider;

import org.testng.annotations.DataProvider;

public class DataSource {
	@DataProvider
	public static Object[][] dataProvider() {
		return new Object[][] { { 1, 2 }, { 3, 4 } };
	}

}
