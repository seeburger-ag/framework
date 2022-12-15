/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server;

import java.io.Serializable;

import com.vaadin.server.PaintTarget.PaintStatus;
import com.vaadin.ui.Component;
import com.vaadin.ui.LegacyComponent;

public class LegacyPaint implements Serializable {
    /**
     *
     * <p>
     * Paints the Paintable into a UIDL stream. This method creates the UIDL
     * sequence describing it and outputs it to the given UIDL stream.
     * </p>
     *
     * <p>
     * It is called when the contents of the component should be painted in
     * response to the component first being shown or having been altered so
     * that its visual representation is changed.
     * </p>
     *
     * <p>
     * <b>Do not override this to paint your component.</b> Override
     * {@link #paintContent(PaintTarget)} instead.
     * </p>
     *
     *
     * @param target
     *            the target UIDL stream where the component should paint itself
     *            to.
     * @throws PaintException
     *             if the paint operation failed.
     */
    public static void paint(Component component, PaintTarget target)
            throws PaintException {
        // Only paint content of visible components.
        if (!LegacyCommunicationManager.isComponentVisibleToClient(component)) {
            return;
        }

        final String tag = target.getTag(component);
        final PaintStatus status = target.startPaintable(component, tag);
        if (PaintStatus.CACHED == status) {
            // nothing to do but flag as cached and close the paintable tag
            target.addAttribute("cached", true);
        } else {
            // Paint the contents of the component
            if (component instanceof LegacyComponent) {
                ((LegacyComponent) component).paintContent(target);
            }
        }
        target.endPaintable(component);

    }

}
