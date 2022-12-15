/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.components.calendar.event;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Interface for querying events. The Vaadin Calendar always has a
 * CalendarEventProvider set.
 *
 * @since 7.1.0
 * @author Vaadin Ltd.
 */
public interface CalendarEventProvider extends Serializable {
    /**
     * <p>
     * Gets all available events in the target date range between startDate and
     * endDate. The Vaadin Calendar queries the events from the range that is
     * shown, which is not guaranteed to be the same as the date range that is
     * set.
     * </p>
     *
     * <p>
     * For example, if you set the date range to be monday 22.2.2010 - wednesday
     * 24.2.2010, the used Event Provider will be queried for events between
     * monday 22.2.2010 00:00 and sunday 28.2.2010 23:59. Generally you can
     * expect the date range to be expanded to whole days and whole weeks.
     * </p>
     *
     * @param startDate
     *            Start date
     * @param endDate
     *            End date
     * @return List of events
     */
    public List<CalendarEvent> getEvents(Date startDate, Date endDate);

    /**
     * Event to signal that the set of events has changed and the calendar
     * should refresh its view from the
     * {@link com.vaadin.addon.calendar.event.CalendarEventProvider
     * CalendarEventProvider} .
     *
     */
    @SuppressWarnings("serial")
    public class EventSetChangeEvent implements Serializable {

        private CalendarEventProvider source;

        public EventSetChangeEvent(CalendarEventProvider source) {
            this.source = source;
        }

        /**
         * @return the
         *         {@link com.vaadin.addon.calendar.event.CalendarEventProvider
         *         CalendarEventProvider} that has changed
         */
        public CalendarEventProvider getProvider() {
            return source;
        }
    }

    /**
     * Listener for EventSetChange events.
     */
    public interface EventSetChangeListener extends Serializable {

        /**
         * Called when the set of Events has changed.
         */
        public void eventSetChange(EventSetChangeEvent changeEvent);
    }

    /**
     * Notifier interface for EventSetChange events.
     */
    public interface EventSetChangeNotifier extends Serializable {

        /**
         * Add a listener for listening to when new events are adding or removed
         * from the event provider.
         *
         * @param listener
         *            The listener to add
         */
        void addEventSetChangeListener(EventSetChangeListener listener);

        /**
         * Remove a listener which listens to {@link EventSetChangeEvent}-events
         *
         * @param listener
         *            The listener to remove
         */
        void removeEventSetChangeListener(EventSetChangeListener listener);
    }
}
