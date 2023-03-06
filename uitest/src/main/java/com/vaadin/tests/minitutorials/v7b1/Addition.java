/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.minitutorials.v7b1;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.ui.AbstractComponent;

public class Addition extends AbstractComponent {
    private int term1;
    private int term2;
    private boolean needsRecalculation = false;

    public void setTerm1(int value1) {
        term1 = value1;
        needsRecalculation = true;

        // Mark the component as dirty to ensure beforeClientResponse will be
        // invoked
        markAsDirty();
    }

    public void setTerm2(int value2) {
        term2 = value2;
        needsRecalculation = true;

        // Mark the component as dirty to ensure beforeClientResponse will be
        // invoked
        markAsDirty();
    }

    private int calculateSum() {
        return term1 + term2;
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        super.beforeClientResponse(initial);
        if (needsRecalculation) {
            needsRecalculation = false;
            // This could be an expensive operation that we don't want to do
            // every time setTerm1 or setTerm2 is invoked.
            getState().sum = calculateSum();
        }
    }

    @Override
    protected AddResultState getState() {
        return (AddResultState) super.getState();
    }
}

class AddResultState extends AbstractComponentState {
    public int sum;
}
