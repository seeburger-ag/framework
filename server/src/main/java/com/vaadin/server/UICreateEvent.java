/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import com.vaadin.ui.UI;

/**
 * Contains data used by various methods in {@link UIProvider} for determining
 * information about a new UI that is about to be created.
 *
 * @author Vaadin Ltd
 * @since 7.0.0
 */
public class UICreateEvent extends UIProviderEvent {

    private final Class<? extends UI> uiClass;
    private final Integer uiId;

    /**
     * Creates a new UI create event for a given VaadinRequest and UI class but
     * without a UI id.
     *
     * @param request
     *            the request for which the UI will be created
     * @param uiClass
     *            the UI class that will be created
     */
    public UICreateEvent(VaadinRequest request, Class<? extends UI> uiClass) {
        this(request, uiClass, null);
    }

    /**
     * Creates a new UI create event for a given VaadinRequest, UI class and UI
     * id
     *
     * @param request
     *            the request for which the UI will be created
     * @param uiClass
     *            the UI class that will be created
     * @param uiId
     *            the id reserved for the UI; or <code>null</code> if no id has
     *            yet been allocated.
     */
    public UICreateEvent(VaadinRequest request, Class<? extends UI> uiClass,
            Integer uiId) {
        super(request);
        this.uiClass = uiClass;
        this.uiId = uiId;
    }

    /**
     * Gets the UI class that will be created.
     *
     * @return the UI class
     */
    public Class<? extends UI> getUIClass() {
        return uiClass;
    }

    /**
     * Gets the id of the UI about to be created. This might be
     * <code>null</code> if the id has not yet been determined.
     * <p>
     * The UI id is generally only available in
     * {@link UIProvider#createInstance(UICreateEvent)}
     *
     * @return the UI id; or <code>null</code> if the UI id is not yet known.
     */
    public Integer getUiId() {
        return uiId;
    }

}
