/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.vaadin.shared.ApplicationConstants;
import com.vaadin.shared.communication.URLReference;

public class ResourceReference extends URLReference {

    private final Resource resource;
    private final ClientConnector connector;
    private final String key;

    public ResourceReference(Resource resource, ClientConnector connector,
            String key) {
        this.resource = resource;
        this.connector = connector;
        this.key = key;
    }

    public Resource getResource() {
        return resource;
    }

    @Override
    public String getURL() {
        if (resource instanceof ExternalResource) {
            return ((ExternalResource) resource).getURL();
        } else if (resource instanceof ConnectorResource) {
            ConnectorResource connectorResource = (ConnectorResource) resource;

            GlobalResourceHandler globalResourceHandler = connector.getUI()
                    .getSession().getGlobalResourceHandler(false);
            if (globalResourceHandler != null) {
                String uri = globalResourceHandler.getUri(connector,
                        connectorResource);
                if (uri != null && !uri.isEmpty()) {
                    return uri;
                }
            }

            // app://APP/connector/[uiid]/[cid]/[key]/[filename]
            String prefix = key;
            String filename = connectorResource.getFilename();
            if (filename != null && !filename.isEmpty()) {
                prefix += '/' + filename;
            }
            String uri = getConnectorResourceBase(prefix, connector);
            return uri;
        } else if (resource instanceof ThemeResource) {
            final String uri = ApplicationConstants.THEME_PROTOCOL_PREFIX
                    + ((ThemeResource) resource).getResourceId();
            return uri;
        } else if (resource instanceof FontIcon) {
            // fonticon://[font-family]/[codepoint]
            final FontIcon icon = (FontIcon) resource;
            final String uri = ApplicationConstants.FONTICON_PROTOCOL_PREFIX
                    + urlEncode(icon.getFontFamily()) + "/"
                    + Integer.toHexString(icon.getCodepoint());
            return uri;
        } else {
            throw new RuntimeException(getClass().getSimpleName()
                    + " does not support resources of type: "
                    + resource.getClass().getName());
        }

    }

    private static String getConnectorResourceBase(String filename,
            ClientConnector connector) {
        String uri = ApplicationConstants.APP_PROTOCOL_PREFIX
                + ApplicationConstants.APP_PATH + '/'
                + ConnectorResource.CONNECTOR_PATH + '/'
                + connector.getUI().getUIId() + '/' + connector.getConnectorId()
                + '/' + encodeFileName(filename);
        return uri;
    }

    public static String encodeFileName(String filename) {
        // #7738 At least Tomcat and JBoss refuses requests containing
        // encoded slashes or backslashes in URLs. Application resource URLs
        // should really be passed in another way than as part of the path
        // in the future.
        return urlEncode(filename).replace("%2F", "/").replace("%5C", "\\");
    }

    static String urlEncode(String filename) {
        try {
            return URLEncoder.encode(filename, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(
                    "UTF-8 charset not available (\"this should never happen\")",
                    e);
        }
    }

    public static ResourceReference create(Resource resource,
            ClientConnector connector, String key) {
        if (resource == null) {
            return null;
        } else {
            return new ResourceReference(resource, connector, key);
        }
    }

    public static Resource getResource(URLReference reference) {
        if (reference == null) {
            return null;
        }
        assert reference instanceof ResourceReference;
        return ((ResourceReference) reference).getResource();
    }
}
