package test.listener;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.testng.listener.Assertion;

public class ListenerResult extends TestListenerAdapter {

	/*
	 * @Override public void onTestStart(ITestResult result) {
	 * System.out.println("this is test start."); }
	 * 
	 * @Override public void onTestFailure(ITestResult tr) { System.out.println(
	 * "this is test fail."); }
	 * 
	 * @Override public void onTestSkipped(ITestResult tr) { System.out.println(
	 * "this is test skip."); }
	 * 
	 * @Override public void onTestSuccess(ITestResult tr) { System.out.println(
	 * "this is test success."); }
	 */

	@Override
	public void onTestStart(ITestResult result) {
		Assertion.begin();
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		if (!Assertion.flag) {
			tr.setStatus(ITestResult.FAILURE);
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		if (!Assertion.flag) {
			tr.setStatus(ITestResult.FAILURE);
		}
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		if (!Assertion.flag) {
			tr.setStatus(ITestResult.FAILURE);
		}
	}
}
