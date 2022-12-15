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
import com.vaadin.data.util.filter.Compare;
import com.vaadin.data.util.sqlcontainer.query.generator.StatementHelper;

public class CompareTranslator implements FilterTranslator {

    @Override
    public boolean translatesFilter(Filter filter) {
        return filter instanceof Compare;
    }

    @Override
    public String getWhereStringForFilter(Filter filter, StatementHelper sh) {
        Compare compare = (Compare) filter;
        sh.addParameterValue(compare.getValue());
        String prop = QueryBuilder.quote(compare.getPropertyId());
        switch (compare.getOperation()) {
        case EQUAL:
            return prop + " = ?";
        case GREATER:
            return prop + " > ?";
        case GREATER_OR_EQUAL:
            return prop + " >= ?";
        case LESS:
            return prop + " < ?";
        case LESS_OR_EQUAL:
            return prop + " <= ?";
        default:
            return "";
        }
    }

}
