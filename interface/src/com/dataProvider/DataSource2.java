package com.dataProvider;

import java.util.HashMap;
import java.util.Map;

public class DataSource2 {

	public Map<String, Object[][]> dataSource2() {
		Map<String, Object[][]> dataMap = new HashMap<String,Object[][]>();
		Object[][] o1 = new Object[][]{{1,2},{3,4}};
		dataMap.put("testDemo", o1);
		Object[][] o2 = new Object[][]{{5,6},{7,8}};
		dataMap.put("testDemo1", o2);
		return dataMap;
	}
}
