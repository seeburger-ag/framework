/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.util;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class FileSystemContainerTest {

    @Test
    public void nonExistingDirectory() {
        FilesystemContainer fsc = new FilesystemContainer(
                new File("/non/existing"));
        Assert.assertTrue(fsc.getItemIds().isEmpty());
    }
}
