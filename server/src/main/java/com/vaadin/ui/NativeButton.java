/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui;

@SuppressWarnings("serial")
public class NativeButton extends Button {

    public NativeButton() {
        super();
    }

    public NativeButton(String caption) {
        super(caption);
    }

    public NativeButton(String caption, ClickListener listener) {
        super(caption, listener);
    }

}
