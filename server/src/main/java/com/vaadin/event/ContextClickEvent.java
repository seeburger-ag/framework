/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.event;

import java.io.Serializable;
import java.lang.reflect.Method;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.Component;
import com.vaadin.util.ReflectTools;

/**
 * Context click event fired by a {@link Component}. ContextClickEvent happens
 * when context click happens on the client-side inside the Component.
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
public class ContextClickEvent extends ClickEvent {

    public static final Method CONTEXT_CLICK_METHOD = ReflectTools.findMethod(
            ContextClickListener.class, "contextClick",
            ContextClickEvent.class);

    public ContextClickEvent(Component source,
            MouseEventDetails mouseEventDetails) {
        super(source, mouseEventDetails);
    }

    /**
     * Listener for {@link ContextClickEvent ContextClickEvents}.
     */
    public interface ContextClickListener extends Serializable {

        /**
         * Called when the context click happens.
         *
         * @param event
         *            the context click event
         */
        public void contextClick(ContextClickEvent event);
    }

    /**
     * The interface for adding and removing listeners for
     * {@link ContextClickEvent ContextClickEvents}.
     */
    public interface ContextClickNotifier extends Serializable {
        /**
         * Adds a context click listener that gets notified when a context click
         * happens.
         *
         * @param listener
         *            the context click listener to add
         */
        public void addContextClickListener(ContextClickListener listener);

        /**
         * Removes a context click listener that was previously added with
         * {@link #addContextClickListener(ContextClickListener)}.
         *
         * @param listener
         *            the context click listener to remove
         */
        public void removeContextClickListener(ContextClickListener listener);
    }

}
