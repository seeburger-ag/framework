/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.vaadin.server.LegacyCommunicationManager;
import com.vaadin.server.MockServletConfig;
import com.vaadin.server.StreamVariable;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinServletService;
import com.vaadin.server.VaadinSession;
import com.vaadin.tests.util.AlwaysLockedVaadinSession;
import com.vaadin.tests.util.MockDeploymentConfiguration;
import com.vaadin.ui.ConnectorTracker;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;

public class StreamVariableMappingTest {
    private static final String variableName = "myName";

    private Upload owner;
    private StreamVariable streamVariable;

    private LegacyCommunicationManager cm;

    @Before
    public void setUp() throws Exception {
        final VaadinSession application = new AlwaysLockedVaadinSession(null);
        final UI uI = new UI() {
            @Override
            protected void init(VaadinRequest request) {
            }

            @Override
            public VaadinSession getSession() {
                return application;
            }
        };
        owner = new Upload() {
            @Override
            public UI getUI() {
                return uI;
            }
        };
        streamVariable = EasyMock.createMock(StreamVariable.class);
        cm = createCommunicationManager();
    }

    @Test
    public void testAddStreamVariable() {
        owner.getUI().getConnectorTracker().registerConnector(owner);
        String targetUrl = cm.getStreamVariableTargetUrl(owner, variableName,
                streamVariable);
        assertTrue(targetUrl.startsWith(
                "app://APP/UPLOAD/-1/" + owner.getConnectorId() + "/myName/"));

        ConnectorTracker tracker = owner.getUI().getConnectorTracker();
        StreamVariable streamVariable2 = tracker
                .getStreamVariable(owner.getConnectorId(), variableName);
        assertSame(streamVariable, streamVariable2);
    }

    @Test
    public void testRemoveVariable() {
        ConnectorTracker tracker = owner.getUI().getConnectorTracker();
        tracker.registerConnector(owner);
        cm.getStreamVariableTargetUrl(owner, variableName, streamVariable);
        assertNotNull(tracker.getStreamVariable(owner.getConnectorId(),
                variableName));

        tracker.cleanStreamVariable(owner.getConnectorId(), variableName);
        assertNull(tracker.getStreamVariable(owner.getConnectorId(),
                variableName));
    }

    private LegacyCommunicationManager createCommunicationManager()
            throws Exception {
        VaadinServlet servlet = new VaadinServlet();
        servlet.init(new MockServletConfig());
        VaadinServletService vss = new VaadinServletService(servlet,
                new MockDeploymentConfiguration());
        servlet.init(new MockServletConfig());
        return new LegacyCommunicationManager(
                new AlwaysLockedVaadinSession(vss));
    }
}
