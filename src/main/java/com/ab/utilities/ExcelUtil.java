package com.ab.utilities;

import com.ab.constants.FrameworkConstants;
import com.ab.exceptions.ExcelFileNotFoundException;
import com.ab.exceptions.ExcelReadException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * <p>The ExcelUtil class provides methods to read data from an Excel file.
 * It contains a public method to get test data from the specified sheet in the Excel file.
 * </p>
 * Note: The class has a private constructor to prevent instantiation of the class.
 *       It uses the FrameworkConstants class to get the path of the Excel file.
 *       It uses the ExcelFileNotFoundException and ExcelReadException classes to throw custom exceptions.
 *
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public final class ExcelUtil {

    /**
     * This is a private constructor to prevent instantiation of the class.
     */
    private ExcelUtil() {
    }

    /**
     * This method reads the test data from the specified sheet in the Excel file.
     * It returns the test data as a List of Maps, where each Map represents a row in the Excel sheet and the keys represent the column headers.
     * <p>
     * Note: The first row of the Excel sheet is considered as the header row.
     *
     * @param sheetName The name of the sheet from which the test data is to be read
     * @return The test data as a List of Maps
     * @throws ExcelFileNotFoundException If the Excel file is not found at the path specified in the FrameworkConstants class
     * @throws ExcelReadException If an exception occurs while reading the Excel file
     */
    public static List<Map<String, String>> getTestData(String sheetName) {
        List<Map<String, String>> data = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(FrameworkConstants.getExcelPath());
             Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            int lastRowNum = sheet.getLastRowNum();


            List<String> headers = new ArrayList<>();
            for (Cell headerCell : headerRow) {
                headers.add(headerCell.getStringCellValue());
            }

            for (int i = 1; i <= lastRowNum; i++) {
                Map<String, String> rowMap = new HashMap<>();
                Row row = sheet.getRow(i);
                if (Objects.isNull(row)) continue;

                for (int j = 0; j < headers.size(); j++) {
                    String header = headers.get(j);
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    String value = Objects.nonNull(cell) ? cell.getStringCellValue() : "";
                    rowMap.put(header, value);
                }
                data.add(rowMap);
            }
        } catch (FileNotFoundException e) {
            throw new ExcelFileNotFoundException("Please check the path of the Excel file in 'FrameworkConstants'");
        } catch (IOException e) {
            throw new ExcelReadException("An exception occurred while reading the Excel file");
        }
        return data;
    }
}



