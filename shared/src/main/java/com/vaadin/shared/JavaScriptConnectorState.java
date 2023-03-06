/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public interface JavaScriptConnectorState extends Serializable {
    public Set<String> getCallbackNames();

    public Map<String, Set<String>> getRpcInterfaces();
}
