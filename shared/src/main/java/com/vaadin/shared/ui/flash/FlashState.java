/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.flash;

import java.util.Map;

import com.vaadin.shared.ui.AbstractEmbeddedState;

public class FlashState extends AbstractEmbeddedState {
    {
        primaryStyleName = "v-flash";
    }

    public String classId;

    public String codebase;

    public String codetype;

    public String archive;

    public String standby;

    public Map<String, String> embedParams;
}
