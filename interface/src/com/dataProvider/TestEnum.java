package com.dataProvider;

public enum TestEnum {

	/**
	* 定义两组数据,分别是{200,"success."}与{400,"failed."}
	* 枚举的意思是根据定义好的数据，来生成对象，有几组数据，就生成几个对象
	*/
	SUCCESS(200, "success."), FAIL(400, "failed.");
	private int retCode;
	private String retMsg;

	private TestEnum(int retCode, String retMsg) {
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public int getRetCode() {
		return retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public static void main(String[] args) {
		System.out.println(TestEnum.SUCCESS.getRetCode());// 输出200
		System.out.println(TestEnum.FAIL.getRetMsg());// 输出failed.
	}
}
