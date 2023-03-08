package com.ab.utilities;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The StringsUtil class contains utility methods for working with strings.
 * It contains a private constructor to prevent object instantiation and two static methods: addSpacesAndCapitalize and getCleanEnumName.
 *
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public final class StringsUtil {

    /**
     * Private constructor to prevent object instantiation
     */
    private StringsUtil() {
    }

    /**
     * This static method adds spaces and capitalizes the words in a camelCase string.
     *
     * @param methodName The camelCase string to be formatted
     * @return The formatted string with spaces and capitalized words
     */
    public static String addSpacesAndCapitalize(String methodName) {
        return Arrays.stream(methodName.split("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])"))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
    }

    /**
     * This static method removes all non-alphanumeric characters from an enum name.
     *
     * @param enumValue The enum value whose name is to be cleaned
     * @return The cleaned enum name with only alphanumeric characters
     */
    public static String getCleanEnumName(Enum<?> enumValue) {
        String enumName = enumValue.name();
        return enumName.replaceAll("[^a-zA-Z0-9]", "");
    }
}
