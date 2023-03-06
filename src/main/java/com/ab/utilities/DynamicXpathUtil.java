package com.ab.utilities;

public final class DynamicXpathUtil {

    private DynamicXpathUtil() {
    }

    public static String buildDynamicXpath(String originalXpath, String... replaceableValues) {
        return String.format(originalXpath, (Object) replaceableValues);
    }
}

