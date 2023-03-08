package com.ab.exceptions;

/**
 * The PropertyNotFoundException class extends the FrameworkExceptions class to represent an exception that occurs when a property is not found.
 * It contains a constructor that takes a message as input and passes it to the constructor of the FrameworkExceptions class.
 *
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public class PropertyNotFoundException extends FrameworkExceptions{

    /**
     * This constructor takes a message as input and passes it to the constructor of the FrameworkExceptions class.
     *
     * @param message The message to be passed to the constructor of the FrameworkExceptions class
     */
    public PropertyNotFoundException(String message) {
        super(message);
    }
}
