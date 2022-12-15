/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.valo;

import com.vaadin.shared.util.SharedUtil;

public class StringGenerator {
    static String[] strings = new String[] { "lorem", "ipsum", "dolor", "sit",
            "amet", "consectetur", "quid", "securi", "etiam", "tamquam", "eu",
            "fugiat", "nulla", "pariatur" };
    int stringCount = -1;

    String nextString(boolean capitalize) {
        if (++stringCount >= strings.length) {
            stringCount = 0;
        }
        return capitalize ? SharedUtil.capitalize(strings[stringCount])
                : strings[stringCount];
    }

}
