package com.ab.utilities;

import com.ab.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A utility class that provides a TestNG data provider for retrieving test data from an Excel file.
 *
 * <p>
 * This class contains a TestNG data provider method that reads test data from an Excel file and returns it as an
 * array of maps, where each map represents a single test case and contains the test case's data in the form of key-value
 * pairs.
 * </p><p>
 *
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 * @see ExcelUtil
 * @see FrameworkConstants
 * @since 2022-07-13
 */

@SuppressWarnings("DataProviderReturnType")
public final class DataProviderUtil {
    private static List<Map<String, String>> dataList = new ArrayList<>();

    /**
     * Provides test data for a TestNG test method from an Excel file.
     *
     * <p>
     * This method reads test data from an Excel file and returns it as an array of maps, where each map represents a
     * single test case and contains the test case's data in the form of key-value pairs.
     * </p>
     *
     * @param method the test method for which to retrieve test data.
     * @return an array of maps, where each map represents a single test case and contains the test case's data in the
     * form of key-value pairs.*/
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
