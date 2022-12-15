/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui;

import com.google.gwt.dom.client.AudioElement;
import com.google.gwt.dom.client.Document;

public class VAudio extends VMediaBase {
    private static String CLASSNAME = "v-audio";

    private AudioElement audio;

    public VAudio() {
        audio = Document.get().createAudioElement();
        setMediaElement(audio);
        setStyleName(CLASSNAME);
    }

}
