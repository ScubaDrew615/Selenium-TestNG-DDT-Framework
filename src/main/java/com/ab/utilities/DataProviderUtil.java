package com.ab.utilities;

import com.ab.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtil {
    private static List<Map<String, String>> dataList = new ArrayList<>();

    @DataProvider
    public static Object[] getData(Method method) {
        String testName = method.getName();
        if (dataList.isEmpty()) {
            dataList = ExcelUtils.getTestData(FrameworkConstants.getExcelDataSheet());
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
