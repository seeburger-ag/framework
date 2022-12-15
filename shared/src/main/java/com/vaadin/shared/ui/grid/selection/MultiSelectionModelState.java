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
 * SharedState object for MultiSelectionModel.
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
public class MultiSelectionModelState extends SharedState {

    /* Select All -checkbox status */
    public boolean allSelected;
    public boolean userSelectionAllowed = true;

}
