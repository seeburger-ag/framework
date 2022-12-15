/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.minitutorials.v7a3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.annotations.JavaScript;
import com.vaadin.shared.Connector;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.UI;

@JavaScript("complex_types_connector.js")
public class ComplexTypesComponent extends AbstractJavaScriptComponent {
    public void sendComplexTypes() {
        List<String> list = new ArrayList<String>();
        list.add("First string");
        list.add(null);
        list.add("Another string");

        Map<String, Integer> stringMap = new HashMap<String, Integer>();
        stringMap.put("one", 1);
        stringMap.put("two", 2);

        Map<Integer, String> otherMap = new HashMap<Integer, String>();
        otherMap.put(3, "3");
        otherMap.put(4, "4");

        Map<Connector, String> connectorMap = new HashMap<Connector, String>();
        connectorMap.put(this, "this");
        connectorMap.put(UI.getCurrent(), "root");

        boolean[] bits = { true, true, false, true };

        List<List<Double>> matrix = Arrays.asList(Arrays.asList(1d, 2d),
                Arrays.asList(3d, 4d));

        ComplexTypesBean innerBean = new ComplexTypesBean();
        innerBean.setInteger(-42);

        ComplexTypesBean bean = new ComplexTypesBean();
        bean.setInteger(42);
        bean.setBean(innerBean);

        getRpcProxy(ComplexTypesRpc.class).sendComplexTypes(list, stringMap,
                otherMap, connectorMap, bits, matrix, bean);
    }
}
