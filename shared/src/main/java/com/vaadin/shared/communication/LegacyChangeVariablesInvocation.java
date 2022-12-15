/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.communication;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.shared.ApplicationConstants;

public class LegacyChangeVariablesInvocation extends MethodInvocation {
    private Map<String, Object> variableChanges = new HashMap<String, Object>();

    public LegacyChangeVariablesInvocation(String connectorId,
            String variableName, Object value) {
        super(connectorId, ApplicationConstants.UPDATE_VARIABLE_INTERFACE,
                ApplicationConstants.UPDATE_VARIABLE_METHOD,
                new Object[] { variableName, new UidlValue(value) });
        setVariableChange(variableName, value);
    }

    public static boolean isLegacyVariableChange(String interfaceName,
            String methodName) {
        return ApplicationConstants.UPDATE_VARIABLE_METHOD.equals(interfaceName)
                && ApplicationConstants.UPDATE_VARIABLE_METHOD
                        .equals(methodName);
    }

    public void setVariableChange(String name, Object value) {
        variableChanges.put(name, value);
    }

    public Map<String, Object> getVariableChanges() {
        return variableChanges;
    }

    @Override
    public String getLastOnlyTag() {
        assert variableChanges.size() == 1;
        return super.getLastOnlyTag()
                + variableChanges.keySet().iterator().next();
    }

}
