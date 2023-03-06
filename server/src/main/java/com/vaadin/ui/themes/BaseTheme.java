/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.themes;

/**
 * <p>
 * The Base theme is the foundation for all Vaadin themes. Although it is not
 * necessary to use it as the starting point for all other themes, it is heavily
 * encouraged, since it abstracts and hides away many necessary style properties
 * that the Vaadin terminal expects and needs.
 * </p>
 * <p>
 * When creating your own theme, either extend this class and specify the styles
 * implemented in your theme here, or extend some other theme that has a class
 * file specified (e.g. Reindeer or Runo).
 * </p>
 * <p>
 * All theme class files should follow the convention of specifying the theme
 * name as a string constant <code>THEME_NAME</code>.
 *
 * @since 6.3.0
 *
 */
public class BaseTheme {

    public static final String THEME_NAME = "base";

    /**
     * Creates a button that looks like a regular hypertext link but still acts
     * like a normal button.
     */
    public static final String BUTTON_LINK = "link";

    /**
     * Adds the connector lines between a parent node and its child nodes to
     * indicate the tree hierarchy better.
     */
    public static final String TREE_CONNECTORS = "connectors";

    /**
     * Clips the component so it will be constrained to its given size and not
     * overflow.
     */
    public static final String CLIP = "v-clip";
}
