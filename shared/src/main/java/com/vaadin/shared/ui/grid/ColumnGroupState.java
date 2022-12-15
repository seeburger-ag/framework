/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared.ui.grid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The column group data shared between the server and the client
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class ColumnGroupState implements Serializable {

    /**
     * The columns that is included in the group
     */
    public List<String> columns = new ArrayList<String>();

    /**
     * The header text of the group
     */
    public String header;

    /**
     * The footer text of the group
     */
    public String footer;
}
