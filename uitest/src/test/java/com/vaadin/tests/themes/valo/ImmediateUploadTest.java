/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.valo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.elements.UploadElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test to see if upload immediate mode hides the native file input.
 *
 * @author Vaadin Ltd
 */
public class ImmediateUploadTest extends MultiBrowserTest {

    @Override
    public void setup() throws Exception {
        super.setup();
        openTestURL();
    }

    private WebElement getUploadButton(String id) {
        UploadElement normalUpload = $(UploadElement.class).id(id);

        return normalUpload.findElement(By.tagName("div"));
    }

    private WebElement getUploadFileInput(String id) {
        UploadElement normalUpload = $(UploadElement.class).id(id);

        return normalUpload.findElement(By.cssSelector("input[type='file']"));
    }

    @Test
    public void normalUploadButtonIsVisible() {
        WebElement button = getUploadButton("upload");

        assertThat(button.getCssValue("display"), is("block"));
    }

    @Test
    public void fileInputIsVisibleForNormalUpload() {
        WebElement input = getUploadFileInput("upload");

        assertThat(input.getCssValue("position"), is("static"));
    }

    @Test
    public void immediateUploadButtonIsVisible() {
        WebElement button = getUploadButton("immediateupload");

        assertThat(button.getCssValue("display"), is("block"));
    }

    @Test
    public void fileInputIsNotVisibleForImmediateUpload() {
        WebElement input = getUploadFileInput("immediateupload");

        assertThat(input.getCssValue("position"), is("absolute"));
    }

    @Test
    public void fileInputIsNotClickableForImmediateUpload() throws IOException {
        WebElement input = getUploadFileInput("immediateupload");

        // input.click() and then verifying if the upload window is opened
        // would be better but couldn't figure a way to do that. screenshots
        // don't show the upload window, not at least in firefox.
        assertThat(input.getCssValue("z-index"), is("-1"));
    }
}
