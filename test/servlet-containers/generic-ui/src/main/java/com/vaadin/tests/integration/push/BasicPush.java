/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.integration.push;

import java.util.Timer;
import java.util.TimerTask;

import com.vaadin.annotations.Push;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;

@Push
public class BasicPush extends AbstractTestUI {

    public static final String CLIENT_COUNTER_ID = "clientCounter";

    public static final String STOP_TIMER_ID = "stopTimer";

    public static final String START_TIMER_ID = "startTimer";

    public static final String SERVER_COUNTER_ID = "serverCounter";

    public static final String INCREMENT_BUTTON_ID = "incrementCounter";

    private int clientCounter = 0;
    private int serverCounter = 0;
    private final Timer timer = new Timer(true);

    private TimerTask task;

    @Override
    protected void setup(VaadinRequest request) {
        getReconnectDialogConfiguration().setDialogModal(false);
        spacer();

        /*
         * Client initiated push.
         */
        final Label lbl = new Label("0");
        lbl.setCaption("Client counter (click 'increment' to update):");
        lbl.setId(CLIENT_COUNTER_ID);
        addComponent(lbl);

        Button incrementButton = new Button("Increment",
                new Button.ClickListener() {
                    public void buttonClick(Button.ClickEvent clickEvent) {
                        clientCounter++;
                        lbl.setValue(String.valueOf(clientCounter));
                    }
                });
        incrementButton.setId(INCREMENT_BUTTON_ID);
        addComponent(incrementButton);

        spacer();

        /*
         * Server initiated push.
         */
        final Label serverCounterLabel = new Label("0");
        serverCounterLabel.setCaption(
                "Server counter (updates each 3s by server thread) :");
        serverCounterLabel.setId(SERVER_COUNTER_ID);
        addComponent(serverCounterLabel);

        Button startTimer = new Button("Start timer", new Button.ClickListener() {

            public void buttonClick(Button.ClickEvent clickEvent) {
                serverCounter = 0;
                serverCounterLabel.setValue(String.valueOf(serverCounter));
                if (task != null) {
                    task.cancel();
                }
                task = new TimerTask() {

                    @Override
                    public void run() {
                        access(new Runnable() {
                            public void run() {
                                serverCounter++;
                                serverCounterLabel
                                        .setValue(String.valueOf(serverCounter));
                            }
                        });
                    }
                };
                timer.scheduleAtFixedRate(task, 3000, 3000);
            }
        });
        startTimer.setId(START_TIMER_ID);
        addComponent(startTimer);

        Button stopTimer = new Button("Stop timer", new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent clickEvent) {
                if (task != null) {
                    task.cancel();
                    task = null;
                }
            }
        });
        stopTimer.setId(STOP_TIMER_ID);
        addComponent(stopTimer);
    }

    @Override
    protected String getTestDescription() {
        return "This test tests the very basic operations of push. "
                + "It tests that client initiated changes are "
                + "recieved back to the client as well as server "
                + "initiated changes are correctly updated to the client.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 11494;
    }

    private void spacer() {
        addComponent(new Label("<hr/>", ContentMode.HTML));
    }

    @Override
    public void attach() {
        super.attach();
    }

    @Override
    public void detach() {
        super.detach();
        timer.cancel();
    }
}
