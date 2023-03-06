/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.tabsheet;

import java.io.Serializable;

import com.vaadin.shared.ui.ErrorLevel;

/**
 * Shared state of a single tab in a Tabsheet or an Accordion.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public class TabState implements Serializable {

    public String caption = "";
    public boolean enabled = true;
    public boolean visible = true;
    public boolean closable = false;
    public String description = null;
    public String styleName;
    public String key;
    public String componentError;
    /**
     * The error level of the component.
     * 
     * @since 7.7.11
     */
    public ErrorLevel componentErrorLevel;
    public String id;
    public String iconAltText;

}
