package com.ab.enums;


/**
 * <p>The DateFormats enum represents the various date formats that can be used in a test automation framework.
 * </p>
 * @project Selenium-Framework
 * @version 1.0
 * @author Andrew Bakheet
 */
public enum DateFormats {

    /**
     * The DEFAULT24H format represents the default date format using the 24-hour clock.
     */
    DEFAULT24H("yyyy-MM-dd HH:mm:ss z"),

    /**
     * The DEFAULT24H format represents the default date format using the 24-hour clock.
     */
    DEFAULT12H("yyyy-MM-dd hh:mm:ss a z"),

    /**
     * The LONG12H format represents a long date format using the 12-hour clock.
     */
    LONG12H("MMMM dd, yyyy hh:mm:ss a z"),

    /**
     * The LONG24H format represents a long date format using the 24-hour clock.
     */
    LONG24H("MMMM dd, yyyy HH:mm:ss z");

    private final String format;

    DateFormats(String format) {
        this.format = format;
    }

    /**
     * Returns the format string for the date format.
     *
     * @return the format string
     */
    public String getFormat() {
        return format;
    }
}
