package com.ab.enums;

/**
 * <p>The ConfigProperties enum represents the configuration properties that can be used in a test automation framework.
 * These properties can be used to configure various aspects of the framework, such as the URL of the application under test,
 * whether to override existing reports, and whether to capture screenshots for passed, failed, or skipped steps.
 * </p>
 * @version 1.0
 * @author Andrew Bakheet
 * @project Selenium-Framework
 */
public enum ConfigProperties {

    /**
     * The URL property represents the URL of the application under test.
     */
    URL,

    /**
     * The OVER_RIDE_REPORTS property represents whether to override existing reports.
     */
    OVER_RIDE_REPORTS,

    /**
     * The PASSED_STEPS_SCREENSHOTS property represents whether to capture screenshots for passed steps.
     */
    PASSED_STEPS_SCREENSHOTS,

    /**
     * The FAILED_STEPS_SCREENSHOTS property represents whether to capture screenshots for failed steps.
     */
    FAILED_STEPS_SCREENSHOTS,

    /**
     * The SKIPPED_STEPS_SCREENSHOTS property represents whether to capture screenshots for skipped steps.
     */
    SKIPPED_STEPS_SCREENSHOTS,

    /**
     * The RETRY_FAILED_TESTS property represents whether to retry failed tests.
     */
    RETRY_FAILED_TESTS,

    RUN_MODE
}
