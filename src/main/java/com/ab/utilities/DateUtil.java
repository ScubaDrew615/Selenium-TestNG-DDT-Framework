package com.ab.utilities;

import com.ab.enums.DateFormats;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * <p>The DateUtil class provides methods to manipulate dates and times.
 * It contains a private method to convert Unix time to a specified date format and a public method to get the current time in a human-readable format.
 * It uses the DateFormats enum to specify the date format.
 * </p>
 * Note: The convertUnixTime() method is private because it is only used internally by the class.
 *
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public class DateUtil {

    /**
     * This method converts Unix time to a specified date format.
     *
     * @param unixTime The Unix time to be converted
     * @param format The date format to which the Unix time is to be converted
     * @return The Unix time converted to the specified date format
     */
    private static String convertUnixTime(long unixTime, DateFormats format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format.getFormat());
        return simpleDateFormat.format(new Date(unixTime));
    }

    /**
     * This method returns the current time in a human-readable format.
     * It uses the convertUnixTime() method to convert the Unix time to the specified format.
     *
     * @return The current time in a human-readable format
     */
    public static String humanTime() {
        return convertUnixTime(System.currentTimeMillis(), DateFormats.LONG24H);
    }
}
