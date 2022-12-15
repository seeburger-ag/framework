/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.util;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vaadin.data.Property;
import com.vaadin.server.Constants;
import com.vaadin.server.DeploymentConfiguration.LegacyProperyToStringMode;
import com.vaadin.server.VaadinService;

/**
 * Helper class which provides methods for handling Property.toString in a
 * Vaadin 6 compatible way
 *
 * @author Vaadin Ltd
 * @since 7.1
 * @deprecated This is only used internally for backwards compatibility
 */
@Deprecated
public class LegacyPropertyHelper implements Serializable {

    /**
     * Returns the property value converted to a String.
     *
     * @param p
     *            The property
     * @return A string representation of the property value, compatible with
     *         how Property implementations in Vaadin 6 do it
     */
    public static String legacyPropertyToString(Property p) {
        maybeLogLegacyPropertyToStringWarning(p);
        Object value = p.getValue();
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    public static void maybeLogLegacyPropertyToStringWarning(Property p) {
        if (!logLegacyToStringWarning()) {
            return;
        }

        getLogger().log(Level.WARNING,
                Constants.WARNING_LEGACY_PROPERTY_TOSTRING,
                p.getClass().getName());
        if (getLogger().isLoggable(Level.FINE)) {
            getLogger().log(Level.FINE,
                    "Strack trace for legacy toString to ease debugging",
                    new Throwable());
        }
    }

    /**
     * Checks if legacy Property.toString() implementation is enabled. The
     * legacy Property.toString() will return the value of the property somehow
     * converted to a String. If the legacy mode is disabled, toString() will
     * return super.toString().
     * <p>
     * The legacy toString mode can be toggled using the
     * "legacyPropertyToString" init parameter
     * </p>
     *
     * @return true if legacy Property.toString() mode is enabled, false
     *         otherwise
     */
    public static boolean isLegacyToStringEnabled() {
        if (VaadinService.getCurrent() == null) {
            // This will happen at least in JUnit tests. We do not what the real
            // value should be but it seems more safe to use the legacy mode.
            return true;
        }
        return VaadinService.getCurrent().getDeploymentConfiguration()
                .getLegacyPropertyToStringMode().useLegacyMode();
    }

    private static boolean logLegacyToStringWarning() {
        if (VaadinService.getCurrent() == null) {
            // This will happen at least in JUnit tests. We do not want to spam
            // the log with these messages in this case.
            return false;
        }
        return VaadinService.getCurrent().getDeploymentConfiguration()
                .getLegacyPropertyToStringMode() == LegacyProperyToStringMode.WARNING;

    }

    private static Logger getLogger() {
        return Logger.getLogger(LegacyPropertyHelper.class.getName());
    }

}
