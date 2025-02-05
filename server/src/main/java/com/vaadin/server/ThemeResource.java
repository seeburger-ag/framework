/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import com.vaadin.util.FileTypeResolver;

/**
 * <code>ThemeResource</code> is a named theme dependant resource provided and
 * managed by a theme. The actual resource contents are dynamically resolved to
 * comply with the used theme by the terminal adapter. This is commonly used to
 * provide static images, flash, java-applets, etc for the terminals.
 *
 * @author Vaadin Ltd.
 * @since 3.0
 */
@SuppressWarnings("serial")
public class ThemeResource implements Resource {

    /**
     * Id of the terminal managed resource.
     */
    private String resourceID = null;

    /**
     * Creates a resource.
     *
     * @param resourceId
     *            the Id of the resource.
     */
    public ThemeResource(String resourceId) {
        if (resourceId == null) {
            throw new NullPointerException("Resource ID must not be null");
        }
        if (resourceId.length() == 0) {
            throw new IllegalArgumentException("Resource ID can not be empty");
        }
        if (resourceId.charAt(0) == '/') {
            throw new IllegalArgumentException(
                    "Resource ID must be relative (can not begin with /)");
        }

        resourceID = resourceId;
    }

    /**
     * Tests if the given object equals this Resource.
     *
     * @param obj
     *            the object to be tested for equality.
     * @return <code>true</code> if the given object equals this Icon,
     *         <code>false</code> if not.
     * @see java.lang.Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof ThemeResource
                && resourceID.equals(((ThemeResource) obj).resourceID);
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return resourceID.hashCode();
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return resourceID.toString();
    }

    /**
     * Gets the resource id.
     *
     * @return the resource id.
     */
    public String getResourceId() {
        return resourceID;
    }

    /**
     * @see com.vaadin.server.Resource#getMIMEType()
     */
    @Override
    public String getMIMEType() {
        return FileTypeResolver.getMIMEType(getResourceId());
    }
}
