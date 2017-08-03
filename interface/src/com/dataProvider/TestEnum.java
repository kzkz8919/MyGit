package com.dataProvider;

public enum TestEnum {

	/**
	* ������������,�ֱ���{200,"success."}��{400,"failed."}
	* ö�ٵ���˼�Ǹ��ݶ���õ����ݣ������ɶ����м������ݣ������ɼ�������
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
		System.out.println(TestEnum.SUCCESS.getRetCode());// ���200
		System.out.println(TestEnum.FAIL.getRetMsg());// ���failed.
	}
}
