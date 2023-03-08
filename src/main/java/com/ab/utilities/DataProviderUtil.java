package com.ab.utilities;

import com.ab.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The DataProviderUtil class is a utility class that provides test data for TestNG tests using the @DataProvider annotation.
 * It reads the test data from the specified Excel file and filters the data based on the "execute" column value.
 * <p>
 * Note: This class uses ExcelUtil class to read the test data from the Excel file.
 *
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */

@SuppressWarnings("DataProviderReturnType")
public final class DataProviderUtil {
    private static List<Map<String, String>> dataList = new ArrayList<>();

    /**
     * This method provides the test data for TestNG tests using the @DataProvider annotation.
     * It reads the test data from the specified Excel file and filters the data based on the "execute" column value.
     * <p>
     * Note: The name of the test method and the name of the sheet in the Excel file should be the same.
     *
     * @param method The test method for which the data is to be provided
     * @return An array of test data filtered based on the "execute" column value
     */
    @DataProvider
    public static Object[] getData(Method method) {
        String testName = method.getName();
        if (dataList.isEmpty()) {
            dataList = ExcelUtil.getTestData(FrameworkConstants.getExcelDataSheet());
        }

        List<Map<String, String>> executedTests = new ArrayList<>();
        for (Map<String, String> stringStringMap : dataList) {
            if (stringStringMap.get("testname").equalsIgnoreCase(testName)) {
                if (stringStringMap.get("execute").equalsIgnoreCase("yes")) {
                    executedTests.add(stringStringMap);
                }
            }
        }
        return executedTests.toArray();
    }
}
