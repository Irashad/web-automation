package com.insider.automation.failsafe;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.function.Supplier;

public class RetryAnalyze implements IRetryAnalyzer {

    int retryAttemptsCounter = 0;

    //The max limit to retry running of failed test cases
    //Set the value to the number of times we want to retry
    int maxRetryLimit = 1;


    @Override
    public boolean retry(ITestResult result) {
        return !result.isSuccess() && retryAttemptsCounter < maxRetryLimit &&
                ((Supplier<Boolean>) () -> {
                    retryAttemptsCounter++;
                    return true;
                }).get();
    }
}
