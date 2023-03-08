package com.ab.listeners;

import com.ab.constants.FrameworkConstants;
import com.ab.utilities.ExcelUtil;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>The MethodInterceptor class is used to intercept and modify the list of test methods to be executed.
 * It implements the IMethodInterceptor interface provided by TestNG.
 * It reads the test data from the Run Manager sheet in the specified Excel file and filters the methods to be executed based on the "execute" column value.
 * It also sets the description, invocation count, and priority for each test method based on the corresponding values in the Run Manager sheet.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */

public class MethodInterceptor implements IMethodInterceptor {

    /**
     * This method intercepts and modifies the list of test methods to be executed.
     * It reads the test data from the Run Manager sheet in the specified Excel file and filters the methods to be executed based on the "execute" column value.
     * It also sets the description, invocation count, and priority for each test method based on the corresponding values in the Run Manager sheet.
     *
     * @param methods The list of test methods to be executed
     * @param iTestContext The TestNG context
     * @return The modified list of test methods to be executed
     */
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {
        List<Map<String, String>> list = ExcelUtil.getTestData(FrameworkConstants.getExcelRunManager());
        List<IMethodInstance> result = new ArrayList<>();

        for (IMethodInstance method : methods) {
            for (Map<String, String> stringStringMap : list) {
                if (method.getMethod().getMethodName().equalsIgnoreCase(stringStringMap.get("testname"))
                        && stringStringMap.get("execute").equalsIgnoreCase("yes")) {
                    method.getMethod().setDescription(stringStringMap.get("testdescription"));
                    method.getMethod().setInvocationCount(Integer.parseInt(stringStringMap.get("count")));
                    method.getMethod().setPriority(Integer.parseInt(stringStringMap.get("priority")));
                    result.add(method);
                }
            }
        }
        return result;
    }
}

