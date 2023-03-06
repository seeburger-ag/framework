/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared.extension.javascriptmanager;

import java.util.HashSet;
import java.util.Set;

import com.vaadin.shared.communication.SharedState;

public class JavaScriptManagerState extends SharedState {
    public Set<String> names = new HashSet<String>();
}
