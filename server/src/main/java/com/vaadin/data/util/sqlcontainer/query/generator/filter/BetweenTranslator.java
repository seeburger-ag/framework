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
import com.vaadin.data.util.filter.Between;
import com.vaadin.data.util.sqlcontainer.query.generator.StatementHelper;

public class BetweenTranslator implements FilterTranslator {

    @Override
    public boolean translatesFilter(Filter filter) {
        return filter instanceof Between;
    }

    @Override
    public String getWhereStringForFilter(Filter filter, StatementHelper sh) {
        Between between = (Between) filter;
        sh.addParameterValue(between.getStartValue());
        sh.addParameterValue(between.getEndValue());
        return QueryBuilder.quote(between.getPropertyId()) + " BETWEEN ? AND ?";
    }

}
