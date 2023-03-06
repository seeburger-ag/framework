/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared;

import java.util.List;

import com.vaadin.shared.annotations.NoLayout;
import com.vaadin.shared.communication.SharedState;
import com.vaadin.shared.ui.ErrorLevel;

/**
 * Default shared state implementation for AbstractComponent.
 *
 * State classes of components should typically extend this class.
 *
 * @since 7.0
 */
public class AbstractComponentState extends SharedState {
    public String height = "";
    public String width = "";
    public boolean readOnly = false;
    @NoLayout
    public boolean immediate = false;
    @NoLayout
    public String description = "";
    // Note: for the caption, there is a difference between null and an empty
    // string!
    public String caption = null;
    public List<String> styles = null;
    public String id = null;
    public String primaryStyleName = null;

    /** HTML formatted error message for the component */
    public String errorMessage = null;

    /**
     * Level of error
     * 
     * @since 7.7.11
     */
    public ErrorLevel errorLevel = null;

    public boolean captionAsHtml = false;
}
