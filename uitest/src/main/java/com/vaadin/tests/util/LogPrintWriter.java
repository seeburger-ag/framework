/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.util;

import java.io.PrintWriter;
import java.io.Writer;

/**
 * Use for collecting HTTP response.
 *
 */
public class LogPrintWriter extends PrintWriter {

    private final StringBuffer result = new StringBuffer(256);

    public LogPrintWriter(Writer out) {
        super(out);
    }

    @Override
    public void print(String s) {
        result.append(s);
        super.print(s);
    }

    @Override
    public void write(String s) {
        result.append(s);
        super.write(s);
    }

    public String getResult() {
        return result.toString();
    }

}
