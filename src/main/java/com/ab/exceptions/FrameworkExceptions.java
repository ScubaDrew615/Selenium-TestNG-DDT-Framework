package com.ab.exceptions;
/**
 * <p>The FrameworkExceptions class extends the RuntimeException class to represent exceptions that occur in the framework.
 * It contains a constructor that takes a message as input and passes it to the constructor of the RuntimeException class.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public class FrameworkExceptions extends RuntimeException {

    /**
     * This constructor takes a message as input and passes it to the constructor of the RuntimeException class.
     *
     * @param message The message to be passed to the constructor of the RuntimeException class
     */
    public FrameworkExceptions(String message) {
        super(message);
    }

}
