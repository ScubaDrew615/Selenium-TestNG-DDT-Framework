package com.ab.exceptions;

/**
 * <p>The InvalidFilePathException class extends the FrameworkExceptions class to represent an exception that occurs when an invalid file path is provided.
 * It contains a constructor that takes a message as input and passes it to the constructor of the FrameworkExceptions class.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public class InvalidFilePathException extends FrameworkExceptions {

    /**
     * This constructor takes a message as input and passes it to the constructor of the FrameworkExceptions class.
     *
     * @param message The message to be passed to the constructor of the FrameworkExceptions class
     */
    public InvalidFilePathException(String message) {
        super(message);
    }
}
