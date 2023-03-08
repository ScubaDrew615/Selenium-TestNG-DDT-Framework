package com.ab.exceptions;

/**
 * <p>The ExcelReadException class extends the FrameworkExceptions class to represent an exception that occurs when an error occurs while reading an Excel file.
 * It contains a constructor that takes a message as input and passes it to the constructor of the FrameworkExceptions class.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public class ExcelReadException extends FrameworkExceptions {

    /**
     * This constructor takes a message as input and passes it to the constructor of the FrameworkExceptions class.
     *
     * @param message The message to be passed to the constructor of the FrameworkExceptions class
     */
    public ExcelReadException(String message) {
        super(message);
    }

}
