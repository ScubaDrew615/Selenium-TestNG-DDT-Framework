package com.ab.exceptions;

/**
 * <p>A custom exception class that represents an exception that occurred while launching a web browser.
 * Extends the FrameworkExceptions class.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-TestNG-DDT-Framework
 * @since 1.0
 */
public class BrowserLaunchException extends FrameworkExceptions{

    /**
     * This constructor takes a message as input and passes it to the constructor of the RuntimeException class.
     *
     * @param message The message to be passed to the constructor of the RuntimeException class
     */
    public BrowserLaunchException(String message) {
        super(message);
    }
}
