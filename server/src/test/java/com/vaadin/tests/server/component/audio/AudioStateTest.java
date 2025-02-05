/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.audio;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.shared.ui.audio.AudioState;
import com.vaadin.ui.Audio;

/**
 * Tests for Audio state.
 *
 */
public class AudioStateTest {
    @Test
    public void getState_audioHasCustomState() {
        TestAudio audio = new TestAudio();
        AudioState state = audio.getState();
        Assert.assertEquals("Unexpected state class", AudioState.class,
                state.getClass());
    }

    @Test
    public void getPrimaryStyleName_audioHasCustomPrimaryStyleName() {
        Audio audio = new Audio();
        AudioState state = new AudioState();
        Assert.assertEquals("Unexpected primary style name",
                state.primaryStyleName, audio.getPrimaryStyleName());
    }

    @Test
    public void audioStateHasCustomPrimaryStyleName() {
        AudioState state = new AudioState();
        Assert.assertEquals("Unexpected primary style name", "v-audio",
                state.primaryStyleName);
    }

    private static class TestAudio extends Audio {

        @Override
        public AudioState getState() {
            return super.getState();
        }
    }
}
