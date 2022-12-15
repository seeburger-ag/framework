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
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.data.util.sqlcontainer.query.generator.StatementHelper;

public class SimpleStringTranslator implements FilterTranslator {

    @Override
    public boolean translatesFilter(Filter filter) {
        return filter instanceof SimpleStringFilter;
    }

    @Override
    public String getWhereStringForFilter(Filter filter, StatementHelper sh) {
        SimpleStringFilter ssf = (SimpleStringFilter) filter;
        // Create a Like filter based on the SimpleStringFilter and execute the
        // LikeTranslator
        String likeStr = ssf.isOnlyMatchPrefix() ? ssf.getFilterString() + "%"
                : "%" + ssf.getFilterString() + "%";
        Like like = new Like(ssf.getPropertyId().toString(), likeStr);
        like.setCaseSensitive(!ssf.isIgnoreCase());
        return new LikeTranslator().getWhereStringForFilter(like, sh);
    }

}
