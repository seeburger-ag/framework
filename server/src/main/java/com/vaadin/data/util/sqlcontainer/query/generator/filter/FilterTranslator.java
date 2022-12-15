/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.util.sqlcontainer.query.generator.filter;

import java.io.Serializable;

import com.vaadin.data.Container.Filter;
import com.vaadin.data.util.sqlcontainer.query.generator.StatementHelper;

public interface FilterTranslator extends Serializable {
    public boolean translatesFilter(Filter filter);

    public String getWhereStringForFilter(Filter filter, StatementHelper sh);

}
