/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.upload;

import org.junit.Test;

import com.vaadin.tests.design.DeclarativeTestBase;
import com.vaadin.ui.Upload;

/**
 * Tests the declarative support for implementations of {@link Upload}.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class UploadDeclarativeTest extends DeclarativeTestBase<Upload> {

    @Test
    public void testReadBasic() {
        testRead(getBasicDesign(), getBasicExpected());
    }

    @Test
    public void testWriteBasic() {
        testWrite(getBasicDesign(), getBasicExpected());
    }

    private String getBasicDesign() {
        return "<vaadin-upload button-caption='Send the file' tabindex=5 />";
    }

    private Upload getBasicExpected() {
        Upload u = new Upload();
        u.setButtonCaption("Send the file");
        u.setTabIndex(5);
        return u;
    }

    @Test
    public void testReadEmpty() {
        testRead("<vaadin-upload />", new Upload());
    }

    @Test
    public void testWriteEmpty() {
        testWrite("<vaadin-upload />", new Upload());
    }
}
