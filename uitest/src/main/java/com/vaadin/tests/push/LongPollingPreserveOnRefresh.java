/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import java.time.ZonedDateTime;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Push;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.communication.PushMode;
import com.vaadin.shared.ui.ui.Transport;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;

@Push(transport = Transport.LONG_POLLING, value = PushMode.MANUAL)
@PreserveOnRefresh
public class LongPollingPreserveOnRefresh extends AbstractTestUI {

    private Thread bt;
    private int updating = 0;

    @Override
    protected void setup(VaadinRequest request) {
        final Button time = new Button("Test");

        bt = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (updating <= 10000) {
                            access(new Runnable() {
                                @Override
                                public void run() {
                                    time.setCaption(
                                            ZonedDateTime.now().toString());
                                    push();
                                }
                            });
                        }
                        updating += 50;
                        Thread.sleep(50);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        bt.setName("time-" + request.getWrappedSession().getId());
        bt.start();

        addComponent(time);
    }

    @Override
    public void doRefresh(VaadinRequest request) {
        updating = 0;
        super.doRefresh(request);
    }

    @Override
    public void detach() {
        super.detach();
        bt.interrupt();
    }

    @Override
    protected Integer getTicketNumber() {
        return 12577;
    }

    @Override
    protected String getTestDescription() {
        return "The button gets renamed frequently for ~10 seconds. The count "
                + "restarts when you refresh the page. The page shoudn't get "
                + "stuck loading after refresh. Try several times."
                + "<br>Do not use ?restartApplication, the point is to test "
                + "the @PreserveOnRefresh handling.";
    }
}
