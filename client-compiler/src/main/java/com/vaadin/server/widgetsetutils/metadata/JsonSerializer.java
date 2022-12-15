/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server.widgetsetutils.metadata;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.user.rebind.SourceWriter;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.communication.JSONSerializer;
import elemental.json.JsonValue;

public abstract class JsonSerializer implements GeneratedSerializer {

    private final JType type;

    public JsonSerializer(JType type) {
        this.type = type;
    }

    @Override
    public void writeSerializerInstantiator(TreeLogger logger, SourceWriter w)
            throws UnableToCompleteException {

        w.print("return new ");
        w.print(JSONSerializer.class.getCanonicalName());
        w.print("<");
        w.print(type.getQualifiedSourceName());
        w.println(">() {");
        w.indent();

        writeSerializerBody(logger, w);

        w.outdent();
        w.println("};");
    }

    protected void writeSerializerBody(TreeLogger logger, SourceWriter w) {
        String qualifiedSourceName = type.getQualifiedSourceName();
        w.println("public " + JsonValue.class.getName() + " serialize("
                + qualifiedSourceName + " value, "
                + ApplicationConnection.class.getName() + " connection) {");
        w.indent();
        // MouseEventDetails castedValue = (MouseEventDetails) value;
        w.println(qualifiedSourceName + " castedValue = (" + qualifiedSourceName
                + ") value;");

        printSerializerBody(logger, w, "castedValue", "connection");

        // End of serializer method
        w.outdent();
        w.println("}");

        // Deserializer
        // T deserialize(Type type, JSONValue jsonValue, ApplicationConnection
        // connection);
        w.println("public " + qualifiedSourceName + " deserialize(Type type, "
                + JsonValue.class.getName() + " jsonValue, "
                + ApplicationConnection.class.getName() + " connection) {");
        w.indent();

        printDeserializerBody(logger, w, "type", "jsonValue", "connection");

        w.outdent();
        w.println("}");
    }

    protected abstract void printDeserializerBody(TreeLogger logger,
            SourceWriter w, String type, String jsonValue, String connection);

    protected abstract void printSerializerBody(TreeLogger logger,
            SourceWriter w, String value, String applicationConnection);

}
