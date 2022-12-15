/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid;

/**
 * {@link DetailsGenerator} that is aware of content heights.
 * <p>
 * <b>FOR INTERNAL USE ONLY!</b> This class exists only for the sake of a
 * temporary workaround and might be removed or renamed at any time.
 * </p>
 *
 * @since 7.6.1
 * @author Vaadin Ltd
 */
@Deprecated
public interface HeightAwareDetailsGenerator extends DetailsGenerator {

    /**
     * This method is called for whenever a details row's height needs to be
     * calculated.
     * <p>
     * <b>FOR INTERNAL USE ONLY!</b> This method exists only for the sake of a
     * temporary workaround and might be removed or renamed at any time.
     * </p>
     *
     * @since 7.6.1
     * @param rowIndex
     *            the index of the row for which to calculate details row height
     * @return height of the details row
     */
    public double getDetailsHeight(int rowIndex);
}
