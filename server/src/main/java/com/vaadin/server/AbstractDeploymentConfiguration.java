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
 * An abstract base class for DeploymentConfiguration implementations. This
 * class provides default implementation for common config properties.
 *
 * @since 7.4
 *
 * @author Vaadin Ltd
 */
public abstract class AbstractDeploymentConfiguration
        implements DeploymentConfiguration {

    @Override
    public String getUIClassName() {
        return getApplicationOrSystemProperty(VaadinSession.UI_PARAMETER, null);
    }

    @Override
    public String getUIProviderClassName() {
        return getApplicationOrSystemProperty(
                Constants.SERVLET_PARAMETER_UI_PROVIDER, null);
    }

    @Override
    public String getWidgetset(String defaultValue) {
        return getApplicationOrSystemProperty(Constants.PARAMETER_WIDGETSET,
                defaultValue);
    }

    @Override
    public String getResourcesPath() {
        return getApplicationOrSystemProperty(
                Constants.PARAMETER_VAADIN_RESOURCES, null);
    }

    @Override
    public String getClassLoaderName() {
        return getApplicationOrSystemProperty("ClassLoader", null);
    }
}
