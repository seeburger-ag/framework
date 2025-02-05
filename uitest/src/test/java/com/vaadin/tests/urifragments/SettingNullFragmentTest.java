/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.urifragments;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * UI test: setting null as URI fragment clear (remove) the fragment in the
 * browser
 *
 * @author Vaadin Ltd
 */
public class SettingNullFragmentTest extends MultiBrowserTest {

    @Test
    public void testSettingNullURIFragment() throws Exception {
        openTestURL();

        navigateToFrag1();
        assertFragment(SettingNullFragment.FRAG_1_URI);

        navigateToNull();
        assertFragment(SettingNullFragment.NULL_FRAGMENT_URI);
    }

    private void assertFragment(String fragment) {
        final String expectedText = fragment;

        waitUntil(new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver input) {
                String currentURL = getDriver().getCurrentUrl();
                String currentURIFragment = "";
                if (currentURL.contains("#") && !currentURL.endsWith("#")) {
                    currentURIFragment = currentURL.split("#")[1];
                }
                return expectedText.equals(currentURIFragment);
            }
        });
    }

    private void navigateToFrag1() {
        hitButton(SettingNullFragment.BUTTON_FRAG_1_ID);
    }

    private void navigateToNull() {
        hitButton(SettingNullFragment.BUTTON_NULL_FRAGMENT_ID);
    }

}
