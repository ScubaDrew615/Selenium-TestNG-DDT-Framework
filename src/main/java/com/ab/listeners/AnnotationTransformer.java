package com.ab.listeners;

import com.ab.utilities.DataProviderUtil;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * <p>The AnnotationTransformer class is used to transform the TestNG annotations for a test method in a test automation framework.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public class AnnotationTransformer implements IAnnotationTransformer {

    /**
     * Transforms the TestNG annotations for a test method.
     *
     * @param annotation       the TestNG annotation to transform
     * @param testClass        the class of the test method
     * @param testConstructor  the constructor of the test method
     * @param testMethod       the test method to transform
     */
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setDataProvider("getData");
        annotation.setDataProviderClass(DataProviderUtil.class);
        annotation.setRetryAnalyzer(RetryFailedTests.class);
    }
}
