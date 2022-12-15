/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.contextclick;

import org.junit.Test;

public class ListenerAddAndRemoveTest extends TableContextClickTestBase {

    @Test
    public void testAddAndRemoveListeners() {
        // Add typed listener
        addOrRemoveTypedListener();

        // Add default listener
        addOrRemoveDefaultListener();

        // Remove the default listener
        addOrRemoveDefaultListener();

        // Check that typed listener is still working
        assertTypedContextClickListener(1);

        // Re-add the default listener
        addOrRemoveDefaultListener();

        // Remove typed listener
        addOrRemoveTypedListener();

        // Check that default listener still works
        assertDefaultContextClickListener(3);

        // Remove default listener
        addOrRemoveDefaultListener();

        // Assert no listeners present.
        assertNoContextClickHandler();

        // Re-add typed listener
        addOrRemoveTypedListener();

        assertTypedContextClickListener(4);
    }
}
