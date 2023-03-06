/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.minitutorials.v7a3;

import java.util.List;
import java.util.Map;

import com.vaadin.shared.Connector;
import com.vaadin.shared.communication.ClientRpc;

public interface ComplexTypesRpc extends ClientRpc {
    public void sendComplexTypes(List<String> list,
            Map<String, Integer> stringMap, Map<Integer, String> otherMap,
            Map<Connector, String> connectorMap, boolean[] bits,
            List<List<Double>> matrix, ComplexTypesBean bean);
}
