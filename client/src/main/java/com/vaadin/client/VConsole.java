/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.logging.client.LogConfiguration;
import com.vaadin.client.debug.internal.VDebugWindow;

/**
 * A helper class to do some client side logging.
 *
 * @deprecated as of 7.1, use {@link Logger} from java.util.logging instead.
 */
@Deprecated
public class VConsole {
    private static VDebugWindow impl;

    /**
     * Used by ApplicationConfiguration to initialize VConsole.
     *
     * @param console
     */
    static void setImplementation(VDebugWindow console) {
        impl = console;
    }

    public static void log(String msg) {
        if (LogConfiguration.loggingIsEnabled(Level.INFO)) {
            // Check for null, so no NullPointerException is generated when
            // formatting (#12588)
            getLogger().log(Level.INFO, msg == null ? "null" : msg);
        }
    }

    public static void log(Throwable e) {
        if (LogConfiguration.loggingIsEnabled(Level.INFO)) {
            // Check for null, so no NullPointerException is generated when
            // formatting (#12588)
            getLogger().log(Level.INFO,
                    e.getMessage() == null ? "" : e.getMessage(), e);
        }
    }

    public static void error(Throwable e) {
        if (LogConfiguration.loggingIsEnabled(Level.SEVERE)) {
            // Check for null, so no NullPointerException is generated when
            // formatting (#12588)
            getLogger().log(Level.SEVERE,
                    e.getMessage() == null ? "" : e.getMessage(), e);
        }
    }

    public static void error(String msg) {
        if (LogConfiguration.loggingIsEnabled(Level.SEVERE)) {
            // Check for null, so no NullPointerException is generated when
            // formatting (#12588)
            getLogger().log(Level.SEVERE, msg == null ? "null" : msg);
        }
    }

    public static void printObject(Object msg) {
        String str;
        if (msg == null) {
            str = "null";
        } else {
            str = msg.toString();
        }
        log(str);
    }

    public static void dirUIDL(ValueMap u, ApplicationConnection client) {
        if (impl != null) {
            impl.uidl(client, u);
        }
    }

    public static void printLayoutProblems(ValueMap meta,
            ApplicationConnection applicationConnection) {
        if (impl != null) {
            impl.meta(applicationConnection, meta);
        }
    }

    private static Logger getLogger() {
        return Logger.getLogger(VConsole.class.getName());
    }

}
