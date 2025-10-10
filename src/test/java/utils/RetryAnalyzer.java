package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;
    private static final int MAX_RETRY = 4;  // run up to 3 times

    @Override
    public boolean retry(ITestResult result) {
        if (count < MAX_RETRY) {
            count++;
            System.out.println("Retrying " + result.getName() + " again | Attempt " + (count + 1));
            return true;   // true → TestNG will re-run the test
        }
        return false;      // false → TestNG stops retrying
    }
}

