/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.extensions;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.util.Log;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.JavaScriptFunction;

import elemental.json.JsonArray;
import elemental.json.JsonNull;

public class JavascriptManagerTest extends AbstractTestUI {

    private Log log = new Log(5);

    @Override
    protected void setup(VaadinRequest request) {
        addComponent(log);
        final JavaScript js = JavaScript.getCurrent();
        js.addFunction("testing.doTest", new JavaScriptFunction() {
            @Override
            public void call(JsonArray arguments) {
                log.log("Got " + arguments.length() + " arguments");
                log.log("Argument 1 as a number: "
                        + (int) arguments.getNumber(0));
                log.log("Argument 2 as a string: " + arguments.getString(1));
                log.log("Argument 3.p as a boolean: "
                        + arguments.getObject(2).getBoolean("p"));
                log.log("Argument 4 is JSONObject.NULL: "
                        + (arguments.get(3) instanceof JsonNull));
                js.removeFunction("testing.doTest");
            }
        });
        js.execute("window.testing.doTest(42, 'text', {p: true}, null)");
    }

    @Override
    protected String getTestDescription() {
        return "Test javascript callback handling by adding a callback and invoking the javascript.";
    }

    @Override
    protected Integer getTicketNumber() {
        // TODO Auto-generated method stub
        return null;
    }

}
