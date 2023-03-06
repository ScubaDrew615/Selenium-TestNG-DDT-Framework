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

public final class ExcelUtils {

    private ExcelUtils() {
    }

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

            throw new ExcelFileNotFoundException("The Excel file you're trying to read is not found");
        } catch (IOException e) {
            throw new ExcelReadException("An exception occurred while reading the Excel file");
        }
        return data;
    }
}



