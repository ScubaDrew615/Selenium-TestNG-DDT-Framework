package com.ab.enums;

public enum DateFormats {
    DEFAULT24H("yyyy-MM-dd HH:mm:ss z"),
    DEFAULT12H("yyyy-MM-dd hh:mm:ss a z"),
    LONG12H("MMMM dd, yyyy hh:mm:ss a z"),
    LONG24H("MMMM dd, yyyy HH:mm:ss z");

    private final String format;

    DateFormats(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
