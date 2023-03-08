package com.ab.annotations;


import com.ab.enums.SuiteType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

/**
 * <p>The FrameworkAnnotation annotation is used to define the author and suites for a test method in a test automation framework.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotation {

    /**
     * Returns the author of the test method.
     *
     * @return the author of the test method
     */
    String[] author();

    /**
     * Returns the suites for the test method.
     *
     * @return the suites for the test method
     */
    SuiteType[] suites();
}
