/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.minitutorials.v7a2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Component;

public class WidgetContainer extends AbstractComponentContainer {

    List<Component> children = new ArrayList<Component>();

    @Override
    public void addComponent(Component c) {
        children.add(c);
        super.addComponent(c);
    }

    @Override
    public void removeComponent(Component c) {
        children.remove(c);
        super.removeComponent(c);
    }

    @Override
    public void replaceComponent(Component oldComponent,
            Component newComponent) {
        int index = children.indexOf(oldComponent);
        if (index != -1) {
            children.remove(index);
            children.add(index, newComponent);
            fireComponentDetachEvent(oldComponent);
            fireComponentAttachEvent(newComponent);
            markAsDirty();
        }
    }

    @Override
    public int getComponentCount() {
        return children.size();
    }

    @Override
    public Iterator<Component> iterator() {
        return children.iterator();
    }
}
