/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.draganddropwrapper;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.AbstractTextFieldElement;
import com.vaadin.tests.tb3.MultiBrowserTest;
import com.vaadin.ui.DragAndDropWrapper;

/**
 * Test for text area inside {@link DragAndDropWrapper}: text area should obtain
 * focus on click.
 *
 * @since
 * @author Vaadin Ltd
 */
public class DragAndDropFocusObtainTest extends MultiBrowserTest {

    @Test
    public void testTextAreaDndImage() {
        openTestURL();
        int index = 1;
        for (AbstractTextFieldElement ta : $(AbstractTextFieldElement.class)
                .all()) {
            String caption = ta.getCaption();
            ta.click();
            Assert.assertEquals(index + ". Field '" + caption + "' focused",
                    getLogRow(0));
            index++;
        }

        // Make sure we checked all fields
        Assert.assertEquals(8 + 1, index);

    }

}
