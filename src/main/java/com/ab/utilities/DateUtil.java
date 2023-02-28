package com.ab.utilities;

import com.ab.enums.DateFormats;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String convertUnixTime(long unixTime, DateFormats format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format.getFormat());
        return simpleDateFormat.format(new Date(unixTime));
    }
}
