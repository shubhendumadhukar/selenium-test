package in.amazon.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int count = 0;

    @Override
    public boolean retry(ITestResult result) {
        while (count < Constants.RETRY_COUNT) {
            count++;
            return true;
        }
        return false;
    }

}
