/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.table;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.communication.ServerRpc;
import com.vaadin.shared.ui.table.TableConstants.Section;

/**
 * Client-to-server RPC interface for the Table component
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
public interface TableServerRpc extends ServerRpc {

    /**
     * Informs the server that a context click happened inside of Table
     */
    public void contextClick(String rowKey, String colKey, Section section,
            MouseEventDetails details);

}
