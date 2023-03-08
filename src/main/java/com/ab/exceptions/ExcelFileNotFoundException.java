package com.ab.exceptions;

/**
 * <p>The ExcelFileNotFoundException class extends the InvalidFilePathException class to represent an exception that occurs when the Excel file is not found at the specified path.
 * It contains a constructor that takes a message as input and passes it to the constructor of the InvalidFilePathException class.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public class ExcelFileNotFoundException extends InvalidFilePathException {

    /**
     * This constructor takes a message as input and passes it to the constructor of the InvalidFilePathException class.
     *
     * @param message The message to be passed to the constructor of the InvalidFilePathException class
     */
    public ExcelFileNotFoundException(String message) {
        super(message);
    }

}

