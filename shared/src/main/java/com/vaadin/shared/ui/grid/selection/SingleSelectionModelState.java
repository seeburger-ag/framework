/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.grid.selection;

import com.vaadin.shared.communication.SharedState;

/**
 * SharedState object for SingleSelectionModel.
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
public class SingleSelectionModelState extends SharedState {

    /* Allow deselecting rows */
    public boolean deselectAllowed = true;
    public boolean userSelectionAllowed = true;
}
