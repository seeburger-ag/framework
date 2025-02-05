/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server.communication;

import java.io.IOException;

import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;

import com.vaadin.server.BootstrapHandler;
import com.vaadin.server.VaadinPortlet;
import com.vaadin.server.VaadinPortlet.VaadinLiferayRequest;
import com.vaadin.server.VaadinPortletRequest;
import com.vaadin.server.VaadinPortletResponse;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ApplicationConstants;

import elemental.json.JsonObject;

public class PortletBootstrapHandler extends BootstrapHandler {
    @Override
    public boolean handleRequest(VaadinSession session, VaadinRequest request,
            VaadinResponse response) throws IOException {
        PortletRequest portletRequest = ((VaadinPortletRequest) request)
                .getPortletRequest();
        if (portletRequest instanceof RenderRequest) {
            return super.handleRequest(session, request, response);
        } else {
            return false;
        }
    }

    @Override
    protected String getServiceUrl(BootstrapContext context) {
        ResourceURL portletResourceUrl = getRenderResponse(context)
                .createResourceURL();
        portletResourceUrl.setResourceID(VaadinPortlet.RESOURCE_URL_ID);
        return portletResourceUrl.toString();
    }

    private RenderResponse getRenderResponse(BootstrapContext context) {
        PortletResponse response = ((VaadinPortletResponse) context
                .getResponse()).getPortletResponse();

        RenderResponse renderResponse = (RenderResponse) response;
        return renderResponse;
    }

    @Override
    protected void appendMainScriptTagContents(BootstrapContext context,
            StringBuilder builder) throws IOException {
        // fixed base theme to use - all portal pages with Vaadin
        // applications will load this exactly once
        String portalTheme = ((VaadinPortletRequest) context.getRequest())
                .getPortalProperty(VaadinPortlet.PORTAL_PARAMETER_VAADIN_THEME);
        if (portalTheme != null
                && !portalTheme.equals(context.getThemeName())) {
            String portalThemeUri = getThemeUri(context, portalTheme);
            // XSS safe - originates from portal properties
            builder.append("vaadin.loadTheme('" + portalThemeUri + "');");
        }

        super.appendMainScriptTagContents(context, builder);
    }

    @Override
    protected String getMainDivStyle(BootstrapContext context) {
        VaadinService vaadinService = context.getRequest().getService();
        return vaadinService.getDeploymentConfiguration()
                .getApplicationOrSystemProperty(
                        VaadinPortlet.PORTLET_PARAMETER_STYLE, null);
    }

    @Override
    protected JsonObject getApplicationParameters(BootstrapContext context) {
        JsonObject parameters = super.getApplicationParameters(context);
        VaadinPortletResponse response = (VaadinPortletResponse) context
                .getResponse();
        VaadinPortletRequest request = (VaadinPortletRequest) context
                .getRequest();
        MimeResponse portletResponse = (MimeResponse) response
                .getPortletResponse();
        ResourceURL resourceURL = portletResponse.createResourceURL();
        resourceURL.setResourceID("v-browserDetails");
        parameters.put("browserDetailsUrl", resourceURL.toString());

        String serviceUrlParameterName = ApplicationConstants.V_RESOURCE_PATH;

        // If we are running in Liferay then we need to prefix all parameters
        // with the portlet namespace
        if (request instanceof VaadinLiferayRequest) {
            serviceUrlParameterName = response.getPortletResponse()
                    .getNamespace() + serviceUrlParameterName;
        }
        parameters.put(ApplicationConstants.SERVICE_URL_PARAMETER_NAME,
                serviceUrlParameterName);

        return parameters;
    }
}
