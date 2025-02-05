/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.ui.HTML;
import com.vaadin.client.WidgetUtil;

public class VFlash extends HTML {

    public static final String CLASSNAME = "v-flash";

    protected String source;
    protected String altText;
    protected String classId;
    protected String codebase;
    protected String codetype;
    protected String standby;
    protected String archive;
    protected Map<String, String> embedParams = new HashMap<String, String>();
    protected boolean needsRebuild = false;
    protected String width;
    protected String height;

    private int slotOffsetHeight = -1;
    private int slotOffsetWidth = -1;

    public VFlash() {
        setStyleName(CLASSNAME);
    }

    public void setSource(String source) {
        if (this.source != source) {
            this.source = source;
            needsRebuild = true;
        }
    }

    public void setAlternateText(String altText) {
        if (this.altText != altText) {
            this.altText = altText;
            needsRebuild = true;
        }
    }

    public void setClassId(String classId) {
        if (this.classId != classId) {
            this.classId = classId;
            needsRebuild = true;
        }
    }

    public void setCodebase(String codebase) {
        if (this.codebase != codebase) {
            this.codebase = codebase;
            needsRebuild = true;
        }
    }

    public void setCodetype(String codetype) {
        if (this.codetype != codetype) {
            this.codetype = codetype;
            needsRebuild = true;
        }
    }

    public void setStandby(String standby) {
        if (this.standby != standby) {
            this.standby = standby;
            needsRebuild = true;
        }
    }

    public void setArchive(String archive) {
        if (this.archive != archive) {
            this.archive = archive;
            needsRebuild = true;
        }
    }

    /**
     * Call this after changing values of widget. It will rebuild embedding
     * structure if needed.
     */
    public void rebuildIfNeeded() {
        if (needsRebuild) {
            needsRebuild = false;
            this.setHTML(createFlashEmbed());
        }
    }

    @Override
    public void setWidth(String width) {
        // explicitly not calling super here
        if (this.width != width) {
            this.width = width;
            needsRebuild = true;
        }
    }

    @Override
    public void setHeight(String height) {
        // explicitly not calling super here
        if (this.height != height) {
            this.height = height;
            needsRebuild = true;
        }
    }

    public void setEmbedParams(Map<String, String> params) {
        if (params == null) {
            if (!embedParams.isEmpty()) {
                embedParams.clear();
                needsRebuild = true;
            }
            return;
        }

        if (!embedParams.equals(params)) {
            embedParams = new HashMap<String, String>(params);
            needsRebuild = true;
        }
    }

    /**
     * Set dimensions of the containing layout slot so that the size of the
     * embed object can be calculated from percentages if needed.
     *
     * Triggers embed resizing if percentage sizes are in use.
     *
     * @param slotOffsetHeight
     *            offset height of the layout slot
     * @param slotOffsetWidth
     *            offset width of the layout slot
     * @since 7.7.8
     */
    public void setSlotHeightAndWidth(int slotOffsetHeight,
            int slotOffsetWidth) {
        this.slotOffsetHeight = slotOffsetHeight;
        this.slotOffsetWidth = slotOffsetWidth;
        if (hasPercentageHeight() || hasPercentageWidth()) {
            resizeEmbedElement();
        }

    }

    protected String createFlashEmbed() {
        /*
         * To ensure cross-browser compatibility we are using the twice-cooked
         * method to embed flash i.e. we add a OBJECT tag for IE ActiveX and
         * inside it a EMBED for all other browsers.
         */
        StringBuilder html = new StringBuilder();

        // Start the object tag
        html.append("<object ");

        /*
         * Add classid required for ActiveX to recognize the flash. This is a
         * predefined value which ActiveX recognizes and must be the given
         * value. More info can be found on
         * http://kb2.adobe.com/cps/415/tn_4150.html. Allow user to override
         * this by setting his own classid.
         */
        if (classId != null) {
            html.append(
                    "classid=\"" + WidgetUtil.escapeAttribute(classId) + "\" ");
        } else {
            html.append(
                    "classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" ");
        }

        /*
         * Add codebase required for ActiveX and must be exactly this according
         * to http://kb2.adobe.com/cps/415/tn_4150.html to work with the above
         * given classid. Again, see more info on
         * http://kb2.adobe.com/cps/415/tn_4150.html. Limiting Flash version to
         * 6.0.0.0 and above. Allow user to override this by setting his own
         * codebase
         */
        if (codebase != null) {
            html.append("codebase=\"" + WidgetUtil.escapeAttribute(codebase)
                    + "\" ");
        } else {
            html.append(
                    "codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0\" ");
        }

        // Add width and height
        html.append("width=\"" + WidgetUtil.escapeAttribute(width) + "\" ");
        html.append("height=\"" + WidgetUtil.escapeAttribute(height) + "\" ");
        html.append("type=\"application/x-shockwave-flash\" ");

        // Codetype
        if (codetype != null) {
            html.append("codetype=\"" + WidgetUtil.escapeAttribute(codetype)
                    + "\" ");
        }

        // Standby
        if (standby != null) {
            html.append(
                    "standby=\"" + WidgetUtil.escapeAttribute(standby) + "\" ");
        }

        // Archive
        if (archive != null) {
            html.append(
                    "archive=\"" + WidgetUtil.escapeAttribute(archive) + "\" ");
        }

        // End object tag
        html.append(">");

        // Ensure we have an movie parameter
        if (embedParams.get("movie") == null) {
            embedParams.put("movie", source);
        }

        // Add parameters to OBJECT
        for (String name : embedParams.keySet()) {
            html.append("<param ");
            html.append("name=\"" + WidgetUtil.escapeAttribute(name) + "\" ");
            html.append("value=\""
                    + WidgetUtil.escapeAttribute(embedParams.get(name))
                    + "\" ");
            html.append("/>");
        }

        // Build inner EMBED tag
        html.append("<embed ");
        html.append("src=\"" + WidgetUtil.escapeAttribute(source) + "\" ");
        if (hasPercentageWidth() && slotOffsetWidth >= 0) {
            html.append("width=\"" + getRelativePixelWidth() + "\" ");
        } else {
            html.append("width=\"" + WidgetUtil.escapeAttribute(width) + "\" ");
        }

        if (hasPercentageHeight() && slotOffsetHeight >= 0) {
            html.append("height=\"" + getRelativePixelHeight() + "px\" ");
        } else {
            html.append(
                    "height=\"" + WidgetUtil.escapeAttribute(height) + "\" ");
        }

        html.append("type=\"application/x-shockwave-flash\" ");

        // Add the parameters to the Embed
        for (String name : embedParams.keySet()) {
            html.append(WidgetUtil.escapeAttribute(name));
            html.append("=");
            html.append("\"" + WidgetUtil.escapeAttribute(embedParams.get(name))
                    + "\"");
        }

        // End embed tag
        html.append("></embed>");

        if (altText != null) {
            html.append("<noembed>");
            html.append(altText);
            html.append("</noembed>");
        }

        // End object tag
        html.append("</object>");

        return html.toString();
    }

    private void resizeEmbedElement() {
        // find <embed> element
        com.google.gwt.dom.client.Element objectElem = getElement()
                .getFirstChildElement();
        com.google.gwt.dom.client.Element objectChild = objectElem
                .getFirstChildElement();
        while (!"EMBED".equalsIgnoreCase(objectChild.getTagName())) {
            objectChild = objectChild.getNextSiblingElement();
            if (objectChild == null) {
                return;
            }
        }
        // update height & width from slot offset, if percentage size is given
        if (hasPercentageHeight() && slotOffsetHeight >= 0) {
            objectChild.setAttribute("height", getRelativePixelHeight());
        }
        if (hasPercentageWidth() && slotOffsetWidth >= 0) {
            objectChild.setAttribute("width", getRelativePixelWidth());
        }

    }

    private String getRelativePixelWidth() {
        float relative = WidgetUtil.parseRelativeSize(width);
        int widthInPixels = (int) (relative / 100) * slotOffsetWidth;
        return widthInPixels + "px";
    }

    private String getRelativePixelHeight() {
        float relative = WidgetUtil.parseRelativeSize(height);
        int heightInPixels = (int) (relative / 100) * slotOffsetHeight;
        return heightInPixels + "px";
    }

    private boolean hasPercentageHeight() {
        return ((height != null) && (height.indexOf('%') > 0));
    }

    private boolean hasPercentageWidth() {
        return ((width != null) && (width.indexOf('%') > 0));
    }

}
