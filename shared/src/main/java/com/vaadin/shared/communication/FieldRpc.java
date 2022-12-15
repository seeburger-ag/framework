/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.communication;

import java.io.Serializable;

public class FieldRpc implements Serializable {
    public interface FocusServerRpc extends ServerRpc {
        public void focus();
    }

    public interface BlurServerRpc extends ServerRpc {
        public void blur();
    }

    public interface FocusAndBlurServerRpc
            extends FocusServerRpc, BlurServerRpc {

    }
}
