/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.renderers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.vaadin.ui.Grid.AbstractRenderer;

import elemental.json.JsonValue;

/**
 * A renderer for presenting date values.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class DateRenderer extends AbstractRenderer<Date> {
    private final Locale locale;
    private final String formatString;
    private final DateFormat dateFormat;

    /**
     * Creates a new date renderer.
     * <p>
     * The renderer is configured to render with the {@link Date#toString()}
     * representation for the default locale.
     */
    public DateRenderer() {
        this(Locale.getDefault(), "");
    }

    /**
     * Creates a new date renderer.
     * <p>
     * The renderer is configured to render with the {@link Date#toString()}
     * representation for the given locale.
     *
     * @param locale
     *            the locale in which to present dates
     * @throws IllegalArgumentException
     *             if {@code locale} is {@code null}
     */
    public DateRenderer(Locale locale) throws IllegalArgumentException {
        this("%s", locale, "");
    }

    /**
     * Creates a new date renderer.
     * <p>
     * The renderer is configured to render with the {@link Date#toString()}
     * representation for the given locale.
     *
     * @param locale
     *            the locale in which to present dates
     * @param nullRepresentation
     *            the textual representation of {@code null} value
     * @throws IllegalArgumentException
     *             if {@code locale} is {@code null}
     */
    public DateRenderer(Locale locale, String nullRepresentation)
            throws IllegalArgumentException {
        this("%s", locale, nullRepresentation);
    }

    /**
     * Creates a new date renderer.
     * <p>
     * The renderer is configured to render with the given string format, as
     * displayed in the default locale.
     *
     * @param formatString
     *            the format string with which to format the date
     * @throws IllegalArgumentException
     *             if {@code formatString} is {@code null}
     * @see <a href=
     *      "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">Format
     *      String Syntax</a>
     */
    public DateRenderer(String formatString) throws IllegalArgumentException {
        this(formatString, "");
    }

    /**
     * Creates a new date renderer.
     * <p>
     * The renderer is configured to render with the given string format, as
     * displayed in the default locale.
     *
     * @param formatString
     *            the format string with which to format the date
     * @param nullRepresentation
     *            the textual representation of {@code null} value
     * @throws IllegalArgumentException
     *             if {@code formatString} is {@code null}
     * @see <a href=
     *      "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">Format
     *      String Syntax</a>
     */
    public DateRenderer(String formatString, String nullRepresentation)
            throws IllegalArgumentException {
        this(formatString, Locale.getDefault(), nullRepresentation);
    }

    /**
     * Creates a new date renderer.
     * <p>
     * The renderer is configured to render with the given string format, as
     * displayed in the given locale.
     *
     * @param formatString
     *            the format string to format the date with
     * @param locale
     *            the locale to use
     * @throws IllegalArgumentException
     *             if either argument is {@code null}
     * @see <a href=
     *      "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">Format
     *      String Syntax</a>
     */
    public DateRenderer(String formatString, Locale locale)
            throws IllegalArgumentException {
        this(formatString, locale, "");
    }

    /**
     * Creates a new date renderer.
     * <p>
     * The renderer is configured to render with the given string format, as
     * displayed in the given locale.
     *
     * @param formatString
     *            the format string to format the date with
     * @param locale
     *            the locale to use
     * @param nullRepresentation
     *            the textual representation of {@code null} value
     * @throws IllegalArgumentException
     *             if either argument is {@code null}
     * @see <a href=
     *      "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">Format
     *      String Syntax</a>
     */
    public DateRenderer(String formatString, Locale locale,
            String nullRepresentation) throws IllegalArgumentException {
        super(Date.class, nullRepresentation);

        if (formatString == null) {
            throw new IllegalArgumentException("format string may not be null");
        }

        if (locale == null) {
            throw new IllegalArgumentException("locale may not be null");
        }

        this.locale = locale;
        this.formatString = formatString;
        dateFormat = null;
    }

    /**
     * Creates a new date renderer.
     * <p>
     * The renderer is configured to render with he given date format.
     *
     * @param dateFormat
     *            the date format to use when rendering dates
     * @throws IllegalArgumentException
     *             if {@code dateFormat} is {@code null}
     */
    public DateRenderer(DateFormat dateFormat) throws IllegalArgumentException {
        this(dateFormat, "");
    }

    /**
     * Creates a new date renderer.
     * <p>
     * The renderer is configured to render with he given date format.
     *
     * @param dateFormat
     *            the date format to use when rendering dates
     * @throws IllegalArgumentException
     *             if {@code dateFormat} is {@code null}
     */
    public DateRenderer(DateFormat dateFormat, String nullRepresentation)
            throws IllegalArgumentException {
        super(Date.class, nullRepresentation);
        if (dateFormat == null) {
            throw new IllegalArgumentException("date format may not be null");
        }

        locale = null;
        formatString = null;
        this.dateFormat = dateFormat;
    }

    @Override
    public String getNullRepresentation() {
        return super.getNullRepresentation();
    }

    @Override
    public JsonValue encode(Date value) {
        String dateString;
        if (value == null) {
            dateString = getNullRepresentation();
        } else if (dateFormat != null) {
            dateString = dateFormat.format(value);
        } else {
            dateString = String.format(locale, formatString, value);
        }
        return encode(dateString, String.class);
    }

    @Override
    public String toString() {
        final String fieldInfo;
        if (dateFormat != null) {
            fieldInfo = "dateFormat: " + dateFormat.toString();
        } else {
            fieldInfo = "locale: " + locale + ", formatString: " + formatString;
        }

        return String.format("%s [%s]", getClass().getSimpleName(), fieldInfo);
    }
}
