/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.server.csrf.ui;

import com.vaadin.shared.ApplicationConstants;

/**
 * Test the CSRF Token issue.
 *
 * @since
 * @author Vaadin Ltd
 */
public class CsrfTokenDisabledTest extends AbstractCsrfTokenUITest {

    @Override
    protected boolean compareMessage(TokenGroup tokenGroup1,
            TokenGroup tokenGroup2) {

        return tokenGroup1.clientToken
                .equals(ApplicationConstants.CSRF_TOKEN_DEFAULT_VALUE)
                && isUndefined(tokenGroup1.tokenReceivedFromServer)
                && isUndefined(tokenGroup1.tokenSentToServer)
                && tokenGroup2.clientToken
                        .equals(ApplicationConstants.CSRF_TOKEN_DEFAULT_VALUE)
                && isUndefined(tokenGroup2.tokenReceivedFromServer)
                // This is it actually, no token sent to the server.
                && isNull(tokenGroup2.tokenSentToServer);
    }

}
