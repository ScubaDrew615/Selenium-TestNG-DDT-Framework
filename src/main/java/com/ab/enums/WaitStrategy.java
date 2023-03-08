package com.ab.enums;

/**
 * <p>The WaitStrategy enum represents the different types of wait strategies that can be used in a test automation framework.
 * </p>
 * @author Andrew Bakheet
 * @version 1.0
 * @project Selenium-Framework
 */
public enum WaitStrategy {

    /**
     * The CLICKABLE wait strategy represents a wait for an element to be clickable.
     */
    CLICKABLE,

    /**
     * The VISIBLE wait strategy represents a wait for an element to be visible.
     */
    VISIBLE,

    /**
     * The PRESENCE wait strategy represents a wait for an element to be present.
     */
    PRESENCE,

    /**
     * The NONE wait strategy represents no wait for an element.
     */
    NONE

}
