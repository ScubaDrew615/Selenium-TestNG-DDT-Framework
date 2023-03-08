package com.ab.utilities;

/**
 * <p>The DynamicXpathUtil class provides a method to build dynamic XPath expressions.
 * It contains a public method to build a dynamic XPath expression by replacing the placeholders in the original XPath expression with the specified values.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public final class DynamicXpathUtil {

    /**
     * This is a private constructor to prevent instantiation of the class.
     */
    private DynamicXpathUtil() {
    }

    /**
     * This method builds a dynamic XPath expression by replacing the placeholders in the original XPath expression with the specified values.
     *
     * @param originalXpath The original XPath expression with placeholders for the values to be replaced
     * @param replaceableValues The values to replace the placeholders in the original XPath expression
     * @return The dynamic XPath expression with the placeholders replaced by the specified values
     */
    public static String buildDynamicXpath(String originalXpath, String... replaceableValues) {
        return String.format(originalXpath, (Object) replaceableValues);
    }
}

