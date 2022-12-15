/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.fieldgroup;

import com.vaadin.tests.components.TestBase;

public class FormManyToMany extends TestBase {

    @Override
    protected void setup() {
        // TODO implement

        // TODO note that in one direction, a setter is used and automatically
        // updates the other direction (setting the Roles of a User updates
        // Roles), whereas in the other direction (updating the list of Users
        // for a Role), manual updates are needed at commit time to keep the
        // Users consistent with Roles
    }

    @Override
    protected String getDescription() {
        return "Forms which allow editing of a many-to-many mapping between users and roles";
    }

    @Override
    protected Integer getTicketNumber() {
        return null;
    }

}
