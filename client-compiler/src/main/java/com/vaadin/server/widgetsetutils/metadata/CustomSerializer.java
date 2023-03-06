/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server.widgetsetutils.metadata;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.user.rebind.SourceWriter;
import com.vaadin.server.widgetsetutils.ConnectorBundleLoaderFactory;

public class CustomSerializer implements GeneratedSerializer {

    private final JClassType serializerType;

    public CustomSerializer(JClassType serializerType) {
        this.serializerType = serializerType;
    }

    @Override
    public void writeSerializerInstantiator(TreeLogger logger, SourceWriter w)
            throws UnableToCompleteException {
        w.print("return ");
        w.print(GWT.class.getCanonicalName());
        w.print(".create(");
        ConnectorBundleLoaderFactory.writeClassLiteral(w, serializerType);
        w.println(");");
    }
}
