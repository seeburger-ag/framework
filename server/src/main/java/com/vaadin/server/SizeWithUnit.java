/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.util.SharedUtil;

/**
 * A class for representing a value-unit pair. Also contains utility methods for
 * parsing such pairs from a string.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class SizeWithUnit implements Serializable {
    private float size;
    private Unit unit;
    private static final Pattern sizePattern = Pattern
            .compile(SharedUtil.SIZE_PATTERN);

    /**
     * Constructs a new SizeWithUnit object representing the pair (size, unit).
     *
     * @param size
     *            a numeric value
     * @param unit
     *            a unit
     */
    public SizeWithUnit(float size, Unit unit) {
        this.size = size;
        this.unit = unit;
    }

    /**
     * Returns the numeric value stored in this object.
     *
     * @return the value of this (value, unit) pair
     */
    public float getSize() {
        return size;
    }

    /**
     * Returns the unit stored in this object.
     *
     * @return the unit of this (value, unit) pair
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * Returns an object whose numeric value and unit are taken from the string
     * s. If s does not specify a unit and defaultUnit is not null, defaultUnit
     * is used as the unit. If defaultUnit is null and s is a nonempty string
     * representing a unitless number, an exception is thrown. Null or empty
     * string will produce {-1,Unit#PIXELS}.
     *
     * @param s
     *            the string to be parsed
     * @param defaultUnit
     *            The unit to be used if s does not contain any unit. Use null
     *            for no default unit.
     * @return an object containing the parsed value and unit
     */
    public static SizeWithUnit parseStringSize(String s, Unit defaultUnit) {
        if (s == null) {
            return null;
        }
        s = s.trim();
        if ("".equals(s)) {
            return null;
        }
        float size = 0;
        Unit unit = null;
        Matcher matcher = sizePattern.matcher(s);
        if (matcher.find()) {
            size = Float.parseFloat(matcher.group(1));
            if (size < 0) {
                size = -1;
                unit = Unit.PIXELS;
            } else {
                String symbol = matcher.group(2);
                if ((symbol != null && symbol.length() > 0)
                        || defaultUnit == null) {
                    unit = Unit.getUnitFromSymbol(symbol);
                } else {
                    unit = defaultUnit;
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid size argument: \"" + s
                    + "\" (should match " + sizePattern.pattern() + ")");
        }
        return new SizeWithUnit(size, unit);
    }

    /**
     * Returns an object whose numeric value and unit are taken from the string
     * s. Null or empty string will produce {-1,Unit#PIXELS}. An exception is
     * thrown if s specifies a number without a unit.
     *
     * @param s
     *            the string to be parsed
     * @return an object containing the parsed value and unit
     */
    public static SizeWithUnit parseStringSize(String s) {
        return parseStringSize(s, null);
    }
}