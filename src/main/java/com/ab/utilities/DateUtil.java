package com.ab.utilities;

import com.ab.enums.DateFormats;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A utility class that provides methods for working with dates.
 * <p>
 * This class contains a method for converting a Unix timestamp to a formatted date string in the specified format.
 * It also includes a method for getting the current date and time in a human-readable format.
 * </p><p>
 *
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 * @see DateFormats
 * @since 2022-07-13
 */

public class DateUtil {

    /**
     * Converts a Unix timestamp to a formatted date string in the specified format.
     *
     * @param unixTime the Unix timestamp to convert.
     * @param format   the desired format of the date string.
     * @return a formatted date string representing the specified Unix timestamp.
     */
    private static String convertUnixTime(long unixTime, DateFormats format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format.getFormat());
        return simpleDateFormat.format(new Date(unixTime));
    }

    /**
     * Gets the current date and time in a human-readable format.
     *
     * @return a string representing the current date and time in a human-readable format.
     */
    public static String humanTime() {
        return convertUnixTime(System.currentTimeMillis(), DateFormats.LONG24H);
    }
}
