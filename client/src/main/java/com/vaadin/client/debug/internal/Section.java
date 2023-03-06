/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.debug.internal;

import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.ValueMap;

/**
 * A Section is displayed as a tab in the {@link VDebugWindow}.
 *
 * @since 7.1
 * @author Vaadin Ltd
 */
public interface Section {

    /**
     * Returns a button that will be used to activate this section, displayed as
     * a tab in {@link VDebugWindow}.
     * <p>
     * <em>The same instance <b>must</b> be returned each time this method is
     * called.</em>
     * </p>
     * <p>
     * The button should preferably only have an icon (no caption), and should
     * have a longer description as title (tooltip).
     * </p>
     *
     * @return section id
     */
    public DebugButton getTabButton();

    /**
     * Returns a widget that is placed on top of the Section content when the
     * Section (tab) is active in the {@link VDebugWindow}.
     *
     * @return section controls
     */
    public Widget getControls();

    /**
     * Returns a widget that is the main content of the section, displayed when
     * the section is active in the {@link VDebugWindow}.
     *
     * @return
     */
    public Widget getContent();

    /**
     * Called when the section is activated in {@link VDebugWindow}. Provides an
     * opportunity to e.g start timers, add listeners etc.
     */
    public void show();

    /**
     * Called when the section is deactivated in {@link VDebugWindow}. Provides
     * an opportunity to e.g stop timers, remove listeners etc.
     */
    public void hide();

    public void meta(ApplicationConnection ac, ValueMap meta);

    public void uidl(ApplicationConnection ac, ValueMap uidl);
}
