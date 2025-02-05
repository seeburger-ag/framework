/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tb3;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.After;

import java.io.IOException;
import com.vaadin.testbench.parallel.TestCategory;

@TestCategory("push")
public abstract class MultiBrowserTestWithProxy extends MultiBrowserTest {

    private static AtomicInteger availablePort = new AtomicInteger(2000);
    private SimpleProxy proxySession;
    private Integer proxyPort = null;

    @Override
    public void setup() throws Exception {
        super.setup();
        connectProxy();
    }

    @After
    public void teardownProxy() {
        disconnectProxy();
    }

    protected Integer getProxyPort() {
        if (proxyPort == null) {
            // Assumes we can use any port >= 2000,
            // except for 2049 in Firefox...
            proxyPort = availablePort.addAndGet(1);
            if (proxyPort == 2049) {
                // Restricted in Firefox, see
                // http://www-archive.mozilla.org/projects/netlib/PortBanning.html#portlist
                proxyPort = availablePort.addAndGet(1);
            }
        }
        return proxyPort;
    }

    /**
     * Disconnects the proxy if active
     */
    protected void disconnectProxy() {
        if (proxySession == null) {
            return;
        }
        proxySession.disconnect();
        proxySession = null;
    }

    /**
     * Ensure the proxy is active. Does nothing if the proxy is already active.
     */
    protected void connectProxy() throws IOException {
        if (proxySession != null) {
            return;
        }
        for (int i = 0; i < 10; i++) {
            // Potential workaround for problem with establishing many ssh
            // connections at the same time
            try {
                createProxy(getProxyPort());
                break;
            } catch (IOException e) {
                try {
                    sleep(500);
                } catch (InterruptedException e1) {
                }
                if (i == 9) {
                    throw new RuntimeException(
                            "All 10 attempts to connect a proxy failed", e);
                }
            }
        }
    }

    private void createProxy(int proxyPort) throws IOException {
        proxySession = new SimpleProxy(proxyPort, getDeploymentHostname(), getDeploymentPort());
        proxySession.start();
    }

    @Override
    protected String getBaseURL() {
        return "http://" + getDeploymentHostname() + ":" + getProxyPort();
    }

}
