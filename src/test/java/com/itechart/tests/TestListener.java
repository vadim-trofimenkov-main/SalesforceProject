package com.itechart.tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.printf("-------------------- STARTING TEST %s -----------------------\n", iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //TODO Api request to set passed status of test case
        System.out.printf("-------------- FINISHED TEST %s Duration: %ss ----------------\n", iTestResult.getName(),
                getExecutionTime(iTestResult));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        //TODO make screenshot
        //TODO Api request to set failed status of test case
        System.out.printf("-------------- FAILED TEST %s Duration: %ss ----------------\n", iTestResult.getName(),
                getExecutionTime(iTestResult));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        //TODO Api request to set skipped status of test case
        System.out.printf("--------- SKIPPING TEST %s ---------\n", iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        //TODO create test run using api

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}
