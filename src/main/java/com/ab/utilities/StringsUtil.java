package com.ab.utilities;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class StringsUtil {
    private StringsUtil() {
    }

    public static String addSpacesAndCapitalize(String methodName) {
        return Arrays.stream(methodName.split("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])"))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
    }

    public static String getCleanEnumName(Enum<?> enumValue) {
        String enumName = enumValue.name();
        return enumName.replaceAll("[^a-zA-Z0-9]", "");
    }
}
