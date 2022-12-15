/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.event.dd;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.shared.MouseEventDetails;

/**
 * A HashMap backed implementation of {@link TargetDetails} for terminal
 * implementation and for extension.
 *
 * @since 6.3
 *
 */
@SuppressWarnings("serial")
public class TargetDetailsImpl implements TargetDetails {

    private HashMap<String, Object> data = new HashMap<String, Object>();
    private DropTarget dropTarget;

    protected TargetDetailsImpl(Map<String, Object> rawDropData) {
        data.putAll(rawDropData);
    }

    public TargetDetailsImpl(Map<String, Object> rawDropData,
            DropTarget dropTarget) {
        this(rawDropData);
        this.dropTarget = dropTarget;
    }

    /**
     * @return details about the actual event that caused the event details.
     *         Practically mouse move or mouse up.
     */
    public MouseEventDetails getMouseEvent() {
        return MouseEventDetails.deSerialize((String) getData("mouseEvent"));
    }

    @Override
    public Object getData(String key) {
        return data.get(key);
    }

    public Object setData(String key, Object value) {
        return data.put(key, value);
    }

    @Override
    public DropTarget getTarget() {
        return dropTarget;
    }

}
