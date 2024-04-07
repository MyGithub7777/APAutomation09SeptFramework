package com.odoo.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerSetup implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Testcase execution started :- "+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcase execution Passed :- "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Utils.captureScreenshot(result.getName());
		System.out.println("Testcase execution Failed :- "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcase execution Skipped :- "+result.getName());
	}

}
