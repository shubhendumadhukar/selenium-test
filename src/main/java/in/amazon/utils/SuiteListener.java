package in.amazon.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import in.amazon.BaseClass;

public class SuiteListener implements ITestListener, IAnnotationTransformer {
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String fileName = Constants.SCREENSHOT_LOCATION + File.separator + iTestResult.getMethod().getMethodName()
                + ".png";
        File f = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(f, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }

}
