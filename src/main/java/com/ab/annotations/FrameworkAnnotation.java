package com.ab.annotations;


import com.ab.enums.SuiteType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotation {

    String[] author();

    SuiteType[] suites();
}
