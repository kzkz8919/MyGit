package com.dataProvider;

import java.util.HashMap;
import java.util.Map;

public class DataSource3 {

	public Map<String, Object[][]> dataSource() {
		Map<String, Object[][]> dataMap = new HashMap<String,Object[][]>();
		TestEnum[] te = TestEnum.values();
		Object[][] o1 =new Object[te.length][];
		for (int i = 0; i < o1.length; i++) {
			Object[] o1temp =new Object[]{te[i]};
			o1[i] =o1temp;
		}
		dataMap.put("testDemo", o1);
		Object[][] o2 = new Object[][]{{5,6},{7,8}};
		dataMap.put("testDemo1", o2);
		return dataMap;
	}
		
}
