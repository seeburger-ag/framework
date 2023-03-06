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
import com.google.gwt.core.ext.typeinfo.JArrayType;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.user.rebind.SourceWriter;
import com.vaadin.client.communication.JsonDecoder;
import com.vaadin.client.communication.JsonEncoder;
import com.vaadin.server.widgetsetutils.ConnectorBundleLoaderFactory;

import elemental.json.Json;
import elemental.json.JsonArray;

public class ArraySerializer extends JsonSerializer {

    private final JArrayType arrayType;

    public ArraySerializer(JArrayType arrayType) {
        super(arrayType);
        this.arrayType = arrayType;
    }

    @Override
    protected void printDeserializerBody(TreeLogger logger, SourceWriter w,
            String type, String jsonValue, String connection) {
        JType leafType = arrayType.getLeafType();
        int rank = arrayType.getRank();

        w.println(JsonArray.class.getName() + " jsonArray = ("
                + JsonArray.class.getName() + ")" + jsonValue + ";");

        // Type value = new Type[jsonArray.size()][][];
        w.print(arrayType.getQualifiedSourceName() + " value = new "
                + leafType.getQualifiedSourceName() + "[jsonArray.length()]");
        for (int i = 1; i < rank; i++) {
            w.print("[]");
        }
        w.println(";");

        w.println("for(int i = 0 ; i < value.length; i++) {");
        w.indent();

        JType componentType = arrayType.getComponentType();

        w.print("value[i] = ("
                + ConnectorBundleLoaderFactory.getBoxedTypeName(componentType)
                + ") " + JsonDecoder.class.getName() + ".decodeValue(");
        ConnectorBundleLoaderFactory.writeTypeCreator(w, componentType);
        w.print(", jsonArray.get(i), null, " + connection + ")");

        w.println(";");

        w.outdent();
        w.println("}");

        w.println("return value;");
    }

    @Override
    protected void printSerializerBody(TreeLogger logger, SourceWriter w,
            String value, String applicationConnection) {
        JType componentType = arrayType.getComponentType();

        w.println(JsonArray.class.getName() + " values = "
                + Json.class.getName() + ".createArray();");
        // JPrimitiveType primitive = componentType.isPrimitive();
        w.println("for (int i = 0; i < " + value + ".length; i++) {");
        w.indent();
        w.print("values.set(i, ");
        w.print(JsonEncoder.class.getName() + ".encode(" + value + "[i],");
        ConnectorBundleLoaderFactory.writeTypeCreator(w, componentType);
        w.print(", " + applicationConnection + ")");
        w.println(");");
        w.outdent();
        w.println("}");
        w.println("return values;");
    }

}
