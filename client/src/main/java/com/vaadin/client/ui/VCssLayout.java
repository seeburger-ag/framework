/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.Profiler;
import com.vaadin.client.StyleConstants;

/**
 * VCCSlayout is a layout which supports configuring it's children with CSS
 * selectors
 */
public class VCssLayout extends FlowPanel {

    public static final String CLASSNAME = "v-csslayout";

    /**
     * Default constructor
     */
    public VCssLayout() {
        super();
        setStyleName(CLASSNAME);
        addStyleName(StyleConstants.UI_LAYOUT);
    }

    /**
     * For internal use only. May be removed or replaced in the future.
     */
    public void addOrMove(Widget child, int index) {
        Profiler.enter("VCssLayout.addOrMove");
        if (child.getParent() == this) {
            Profiler.enter("VCssLayout.addOrMove getWidgetIndex");
            int currentIndex = getWidgetIndex(child);
            Profiler.leave("VCssLayout.addOrMove getWidgetIndex");
            if (index == currentIndex) {
                Profiler.leave("VCssLayout.addOrMove");
                return;
            }
        } else if (index == getWidgetCount()) {
            // optimized path for appending components - faster especially for
            // initial rendering
            Profiler.enter("VCssLayout.addOrMove add");
            add(child);
            Profiler.leave("VCssLayout.addOrMove add");
            Profiler.leave("VCssLayout.addOrMove");
            return;
        }
        Profiler.enter("VCssLayout.addOrMove insert");
        insert(child, index);
        Profiler.leave("VCssLayout.addOrMove insert");
        Profiler.leave("VCssLayout.addOrMove");
    }
}
