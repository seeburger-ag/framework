/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.fieldgroup;

import java.util.Random;

import com.vaadin.tests.util.TestDataGenerator;

public class ComplexAddress {

    private String streetAddress = "";
    private String postalCode = "";
    private String city = "";
    private Country country = null;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static ComplexAddress create(Random r) {
        ComplexAddress ca = new ComplexAddress();
        ca.setCity(TestDataGenerator.getCity(r));
        ca.setCountry(TestDataGenerator.getEnum(Country.class, r));
        ca.setPostalCode(TestDataGenerator.getPostalCode(r) + "");
        ca.setStreetAddress(TestDataGenerator.getStreetAddress(r));
        return ca;
    }

}
