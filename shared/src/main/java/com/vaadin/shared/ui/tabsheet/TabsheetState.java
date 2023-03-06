/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.tabsheet;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.shared.annotations.NoLayout;

public class TabsheetState extends AbstractComponentState {
    public static final String PRIMARY_STYLE_NAME = "v-tabsheet";

    {
        primaryStyleName = PRIMARY_STYLE_NAME;
    }

    /**
     * Index of the component when switching focus - not related to Tabsheet
     * tabs.
     */
    @NoLayout
    public int tabIndex;

    public List<TabState> tabs = new ArrayList<TabState>();

    /** true to show the tab bar, false to only show the contained component */
    public boolean tabsVisible = true;

    /** the key of the currently selected tab */
    public String selected;

    @DelegateToWidget
    public boolean tabCaptionsAsHtml = false;

}
