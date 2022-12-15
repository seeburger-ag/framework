/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.util.sqlcontainer.query.generator.filter;

import com.vaadin.data.Container.Filter;
import com.vaadin.data.util.filter.Or;
import com.vaadin.data.util.sqlcontainer.query.generator.StatementHelper;

public class OrTranslator implements FilterTranslator {

    @Override
    public boolean translatesFilter(Filter filter) {
        return filter instanceof Or;
    }

    @Override
    public String getWhereStringForFilter(Filter filter, StatementHelper sh) {
        return QueryBuilder.group(QueryBuilder
                .getJoinedFilterString(((Or) filter).getFilters(), "OR", sh));
    }

}
