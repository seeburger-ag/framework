/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.grid;

/**
 * Enumeration, specifying the destinations that are supported when scrolling
 * rows or columns into view.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public enum ScrollDestination {

    /**
     * Scroll as little as possible to show the target element. If the element
     * fits into view, this works as START or END depending on the current
     * scroll position. If the element does not fit into view, this works as
     * START.
     */
    ANY,

    /**
     * Scrolls so that the element is shown at the start of the viewport. The
     * viewport will, however, not scroll beyond its contents.
     */
    START,

    /**
     * Scrolls so that the element is shown in the middle of the viewport. The
     * viewport will, however, not scroll beyond its contents, given more
     * elements than what the viewport is able to show at once. Under no
     * circumstances will the viewport scroll before its first element.
     */
    MIDDLE,

    /**
     * Scrolls so that the element is shown at the end of the viewport. The
     * viewport will, however, not scroll before its first element.
     */
    END

}
