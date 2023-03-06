/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.util;

import java.util.ArrayList;
import java.util.List;

public class Millionaire extends Person {
    private List<Address> secondaryResidences = new ArrayList<Address>();

    public Millionaire() {
    }

    public Millionaire(String firstName, String lastName, String email,
            String phoneNumber, String streetAddress, int postalCode,
            String city) {
        super(firstName, lastName, email, phoneNumber, streetAddress,
                postalCode, city);
    }

    public List<Address> getSecondaryResidences() {
        return secondaryResidences;
    }
}
