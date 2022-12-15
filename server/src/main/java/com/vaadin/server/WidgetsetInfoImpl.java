/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

/**
 * Default implementation of {@link WidgetsetInfo} that is used for internal
 * communication between the parts of the framework.
 * <p>
 * Class needs to be static so that it can be easily used in e.g.
 * BootstrapHandler.
 * <p>
 * This class is intended primarily for internal use. It is recommended to
 * implement WidgetsetInfo directly rather than extending or using this class
 * outside the framework, and this class is subject to changes.
 *
 * @since 7.7
 */
class WidgetsetInfoImpl implements WidgetsetInfo {

    private final boolean cdn;
    private final String widgetsetUrl;
    private final String widgetsetName;

    public WidgetsetInfoImpl(boolean cdn, String widgetsetUrl,
            String widgetsetName) {

        this.cdn = cdn;
        this.widgetsetUrl = widgetsetUrl;
        this.widgetsetName = widgetsetName;
    }

    public WidgetsetInfoImpl(String widgetsetName) {
        this(false, null, widgetsetName);
    }

    @Override
    public boolean isCdn() {
        return cdn;
    }

    @Override
    public String getWidgetsetUrl() {
        return widgetsetUrl;
    }

    @Override
    public String getWidgetsetName() {
        return widgetsetName;
    }

}