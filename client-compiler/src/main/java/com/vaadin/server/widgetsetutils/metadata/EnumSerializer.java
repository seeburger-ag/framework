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
import com.google.gwt.core.ext.typeinfo.JEnumConstant;
import com.google.gwt.core.ext.typeinfo.JEnumType;
import com.google.gwt.user.rebind.SourceWriter;

import elemental.json.Json;

public class EnumSerializer extends JsonSerializer {

    private final JEnumType enumType;

    public EnumSerializer(JEnumType type) {
        super(type);
        enumType = type;
    }

    @Override
    protected void printDeserializerBody(TreeLogger logger, SourceWriter w,
            String type, String jsonValue, String connection) {
        w.println("String enumIdentifier = " + jsonValue + ".asString();");
        for (JEnumConstant e : enumType.getEnumConstants()) {
            w.println("if (\"" + e.getName() + "\".equals(enumIdentifier)) {");
            w.indent();
            w.println("return " + enumType.getQualifiedSourceName() + "."
                    + e.getName() + ";");
            w.outdent();
            w.println("}");
        }
        w.println("return null;");
    }

    @Override
    protected void printSerializerBody(TreeLogger logger, SourceWriter w,
            String value, String applicationConnection) {
        // return Json.create(castedValue.name());
        w.println("return " + Json.class.getName() + ".create(" + value
                + ".name());");
    }

}
