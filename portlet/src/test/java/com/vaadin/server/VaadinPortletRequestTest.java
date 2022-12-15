/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server;

import org.junit.Before;
import org.junit.Test;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VaadinPortletRequestTest {

    private PortletRequest request;
    private VaadinPortletRequest sut;
    private VaadinPortletService service;
    private PortletPreferences preferences;

    @Before
    public void setup() {
        request = mock(PortletRequest.class);
        service = mock(VaadinPortletService.class);

        sut = new VaadinPortletRequest(request, service);

        preferences = mock(PortletPreferences.class);
        when(request.getPreferences()).thenReturn(preferences);
    }

    @Test
    public void portletPreferenceIsFetched() {
        when(preferences.getValue(eq("foo"), anyString())).thenReturn("bar");

        String value = sut.getPortletPreference("foo");

        assertThat(value, is("bar"));
    }

    @Test
    public void defaultValueForPortletPreferenceIsNull() {
        when(preferences.getValue(anyString(), isNull(String.class)))
                .thenReturn(null);

        String value = sut.getPortletPreference("foo");

        assertNull(value);
    }

}
