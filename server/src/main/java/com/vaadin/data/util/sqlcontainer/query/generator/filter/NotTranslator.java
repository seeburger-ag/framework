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
import com.vaadin.data.util.filter.IsNull;
import com.vaadin.data.util.filter.Not;
import com.vaadin.data.util.sqlcontainer.query.generator.StatementHelper;

public class NotTranslator implements FilterTranslator {

    @Override
    public boolean translatesFilter(Filter filter) {
        return filter instanceof Not;
    }

    @Override
    public String getWhereStringForFilter(Filter filter, StatementHelper sh) {
        Not not = (Not) filter;
        if (not.getFilter() instanceof IsNull) {
            IsNull in = (IsNull) not.getFilter();
            return QueryBuilder.quote(in.getPropertyId()) + " IS NOT NULL";
        }
        return "NOT "
                + QueryBuilder.getWhereStringForFilter(not.getFilter(), sh);
    }

}
