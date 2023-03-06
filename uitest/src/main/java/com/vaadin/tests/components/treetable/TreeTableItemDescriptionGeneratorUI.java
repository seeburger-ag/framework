/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.treetable;

import com.vaadin.tests.components.table.TableItemDescriptionGeneratorUI;
import com.vaadin.ui.Table;
import com.vaadin.ui.TreeTable;

public class TreeTableItemDescriptionGeneratorUI
        extends TableItemDescriptionGeneratorUI {

    @Override
    protected Table createTable() {
        return new TreeTable();
    }

}
