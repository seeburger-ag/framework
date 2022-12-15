/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.event;

import com.vaadin.event.Action.Listener;
import com.vaadin.server.Resource;

public abstract class ShortcutListener extends ShortcutAction
        implements Listener {

    private static final long serialVersionUID = 1L;

    public ShortcutListener(String caption, int keyCode, int... modifierKeys) {
        super(caption, keyCode, modifierKeys);
    }

    public ShortcutListener(String shorthandCaption, int... modifierKeys) {
        super(shorthandCaption, modifierKeys);
    }

    public ShortcutListener(String caption, Resource icon, int keyCode,
            int... modifierKeys) {
        super(caption, icon, keyCode, modifierKeys);
    }

    public ShortcutListener(String shorthandCaption) {
        super(shorthandCaption);
    }

    @Override
    abstract public void handleAction(Object sender, Object target);
}
