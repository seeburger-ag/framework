/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tree;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.vaadin.testbench.By;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class TreeItemDoubleClickTest extends MultiBrowserTest {

    @Test
    public void test() throws InterruptedException {
        openTestURL();
        String caption = "Tree Item 2";
        doubleClick(getTreeNodeByCaption(caption));
        try {
            assertLogText("Double Click " + caption);
        } catch (AssertionError e) {
            // double click is flaky, try again
            doubleClick(getTreeNodeByCaption(caption));
            assertLogText("Double Click " + caption);
        }

        changeImmediate();

        caption = "Tree Item 3";
        doubleClick(getTreeNodeByCaption(caption));
        try {
            assertLogText("Double Click " + caption);
        } catch (AssertionError e) {
            doubleClick(getTreeNodeByCaption(caption));
            assertLogText("Double Click " + caption);
        }
    }

    private void changeImmediate() {
        $(ButtonElement.class).caption("Change immediate flag").first().click();
        assertLogText("tree.isImmediate() is now");
    }

    private WebElement getTreeNodeByCaption(String caption) {
        return getDriver()
                .findElement(By.xpath("//span[text() = '" + caption + "']"));
    }

    private void doubleClick(WebElement element) throws InterruptedException {
        new Actions(getDriver()).doubleClick(element).build().perform();
        sleep(100);
    }

    private void assertLogText(String text) {
        assertThat(String.format("Couldn't find text '%s' from the log.", text),
                logContainsText(text));
    }

}
