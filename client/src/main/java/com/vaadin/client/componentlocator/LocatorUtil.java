/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.componentlocator;

import com.google.gwt.regexp.shared.RegExp;

/**
 * Common String manipulator utilities used in VaadinFinderLocatorStrategy and
 * SelectorPredicates.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public class LocatorUtil {

    /**
     * Find first occurrence of character that's not inside quotes starting from
     * specified index.
     *
     * @param str
     *            Full string for searching
     * @param find
     *            Character we want to find
     * @param startingAt
     *            Index where we start
     * @return Index of character. -1 if character not found
     */
    protected static int indexOfIgnoringQuoted(String str, char find,
            int startingAt) {
        boolean quote = false;
        String quoteChars = "'\"";
        char currentQuote = '"';
        for (int i = startingAt; i < str.length(); ++i) {
            char cur = str.charAt(i);
            if (quote) {
                if (cur == currentQuote) {
                    quote = !quote;
                }
                continue;
            } else if (cur == find) {
                return i;
            } else {
                if (quoteChars.indexOf(cur) >= 0) {
                    currentQuote = cur;
                    quote = !quote;
                }
            }
        }
        return -1;
    }

    /**
     * Find first occurrence of character that's not inside quotes starting from
     * the beginning of string.
     *
     * @param str
     *            Full string for searching
     * @param find
     *            Character we want to find
     * @return Index of character. -1 if character not found
     */
    protected static int indexOfIgnoringQuoted(String str, char find) {
        return indexOfIgnoringQuoted(str, find, 0);
    }

    /**
     * Checks if path refers to vaadin UI element com.vaadin.ui.UI.
     *
     * @param path
     *            to vaadin element
     * @return true if path refers to UI element, false otherwise
     */
    public static boolean isUIElement(String path) {
        String regex = "^\\/{0,2}(com\\.vaadin\\.ui\\.)?V?UI[\\/\\[]?";
        RegExp regexp = RegExp.compile(regex);
        return regexp.test(path);
    }

    /**
     * Checks if path refers to vaadin Notification element
     * com.vaadin.ui.Notification.
     *
     * @param path
     *            to vaadin element
     * @return true if path refers to Notification element, false otherwise
     */
    public static boolean isNotificationElement(String path) {
        String regex = "^\\/{0,2}(com\\.vaadin\\.ui\\.)?V?Notification[\\/\\[]?";
        RegExp regexp = RegExp.compile(regex);
        return regexp.test(path);
    }
}
