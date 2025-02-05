/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAbstractApplicationServletStaticFilesLocation {

    VaadinServlet servlet;

    // private Method getStaticFilesLocationMethod;

    @Before
    public void setUp() throws Exception {
        servlet = new VaadinServlet();
        servlet.init(new MockServletConfig());
    }

    @Test
    public void testWidgetSetLocation() throws Exception {
        String location;

        /* SERVLETS */
        // http://dummy.host:8080/contextpath/servlet
        // should return . (relative url resolving to /contextpath)
        location = testLocation("http://dummy.host:8080", "/contextpath",
                "/servlet", "");
        Assert.assertEquals(".", location);

        // http://dummy.host:8080/contextpath/servlet/
        // should return ./.. (relative url resolving to /contextpath)
        location = testLocation("http://dummy.host:8080", "/contextpath",
                "/servlet", "/");
        Assert.assertEquals("./..", location);

        // http://dummy.host:8080/servlet
        // should return "."
        location = testLocation("http://dummy.host:8080", "", "/servlet", "");
        Assert.assertEquals(".", location);

        // http://dummy.host/contextpath/servlet/extra/stuff
        // should return ./../.. (relative url resolving to /contextpath)
        location = testLocation("http://dummy.host", "/contextpath", "/servlet",
                "/extra/stuff");
        Assert.assertEquals("./../..", location);

        // http://dummy.host/context/path/servlet/extra/stuff
        // should return ./../.. (relative url resolving to /context/path)
        location = testLocation("http://dummy.host", "/context/path",
                "/servlet", "/extra/stuff");
        Assert.assertEquals("./../..", location);

        /* Include requests */
        // Include request support dropped with support for portlet1
        // Might reconsider when JSP integration support is implemented
        // location = testIncludedLocation("http://my.portlet.server", "/user",
        // "/tmpservletlocation1", "");
        // assertEquals("Wrong widgetset location", "/user", location);

    }

    private String testLocation(String base, String contextPath,
            String servletPath, String pathInfo) throws Exception {

        HttpServletRequest request = createNonIncludeRequest(base, contextPath,
                servletPath, pathInfo);
        // Set request into replay mode
        replay(request);

        String location = servlet.getService()
                .getStaticFileLocation(servlet.createVaadinRequest(request));
        return location;
    }

    private String testIncludedLocation(String base, String portletContextPath,
            String servletPath, String pathInfo) throws Exception {

        HttpServletRequest request = createIncludeRequest(base,
                portletContextPath, servletPath, pathInfo);
        // Set request into replay mode
        replay(request);

        String location = servlet.getService()
                .getStaticFileLocation(servlet.createVaadinRequest(request));
        return location;
    }

    private HttpServletRequest createIncludeRequest(String base,
            String realContextPath, String realServletPath, String pathInfo)
            throws Exception {
        HttpServletRequest request = createRequest(base, "", "", pathInfo);
        expect(request.getAttribute("javax.servlet.include.context_path"))
                .andReturn(realContextPath).anyTimes();
        expect(request.getAttribute("javax.servlet.include.servlet_path"))
                .andReturn(realServletPath).anyTimes();

        return request;
    }

    private HttpServletRequest createNonIncludeRequest(String base,
            String realContextPath, String realServletPath, String pathInfo)
            throws Exception {
        HttpServletRequest request = createRequest(base, realContextPath,
                realServletPath, pathInfo);
        expect(request.getAttribute("javax.servlet.include.context_path"))
                .andReturn(null).anyTimes();
        expect(request.getAttribute("javax.servlet.include.servlet_path"))
                .andReturn(null).anyTimes();

        return request;
    }

    /**
     * Creates a HttpServletRequest mock using the supplied parameters.
     *
     * @param base
     *            The base url, e.g. http://localhost:8080
     * @param contextPath
     *            The context path where the application is deployed, e.g.
     *            /mycontext
     * @param servletPath
     *            The servlet path to the servlet we are testing, e.g. /myapp
     * @param pathInfo
     *            Any text following the servlet path in the request, not
     *            including query parameters, e.g. /UIDL/
     * @return A mock HttpServletRequest object useful for testing
     * @throws MalformedURLException
     */
    private HttpServletRequest createRequest(String base, String contextPath,
            String servletPath, String pathInfo) throws MalformedURLException {
        URL url = new URL(base + contextPath + pathInfo);
        HttpServletRequest request = createMock(HttpServletRequest.class);
        expect(request.isSecure())
                .andReturn(url.getProtocol().equalsIgnoreCase("https"))
                .anyTimes();
        expect(request.getServerName()).andReturn(url.getHost()).anyTimes();
        expect(request.getServerPort()).andReturn(url.getPort()).anyTimes();
        expect(request.getRequestURI()).andReturn(url.getPath()).anyTimes();
        expect(request.getContextPath()).andReturn(contextPath).anyTimes();
        expect(request.getPathInfo()).andReturn(pathInfo).anyTimes();
        expect(request.getServletPath()).andReturn(servletPath).anyTimes();

        return request;
    }

}
