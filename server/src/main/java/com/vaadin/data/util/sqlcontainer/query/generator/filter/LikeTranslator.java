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
import com.vaadin.data.util.filter.Like;
import com.vaadin.data.util.sqlcontainer.query.generator.StatementHelper;

public class LikeTranslator implements FilterTranslator {

    @Override
    public boolean translatesFilter(Filter filter) {
        return filter instanceof Like;
    }

    @Override
    public String getWhereStringForFilter(Filter filter, StatementHelper sh) {
        Like like = (Like) filter;
        if (like.isCaseSensitive()) {
            sh.addParameterValue(like.getValue());
            return QueryBuilder.quote(like.getPropertyId()) + " LIKE ?";
        } else {
            sh.addParameterValue(like.getValue().toUpperCase());
            return "UPPER(" + QueryBuilder.quote(like.getPropertyId())
                    + ") LIKE ?";
        }
    }

}
