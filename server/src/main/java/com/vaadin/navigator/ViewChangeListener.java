/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.navigator;

import java.io.Serializable;
import java.util.EventObject;

/**
 * Interface for listening to View changes before and after they occur.
 *
 * Implementations of this interface can also block navigation between views
 * before it is performed.
 *
 * @author Vaadin Ltd
 * @since 7.0
 */
public interface ViewChangeListener extends Serializable {

    /**
     * Event received by the listener for attempted and executed view changes.
     */
    public static class ViewChangeEvent extends EventObject {
        private final View oldView;
        private final View newView;
        private final String viewName;
        private final String parameters;

        /**
         * Create a new view change event.
         *
         * @param navigator
         *            Navigator that triggered the event, not null
         */
        public ViewChangeEvent(Navigator navigator, View oldView, View newView,
                String viewName, String parameters) {
            super(navigator);
            this.oldView = oldView;
            this.newView = newView;
            this.viewName = viewName;
            this.parameters = parameters;
        }

        /**
         * Returns the navigator that triggered this event.
         *
         * @return Navigator (not null)
         */
        public Navigator getNavigator() {
            return (Navigator) getSource();
        }

        /**
         * Returns the view being deactivated.
         *
         * @return old View
         */
        public View getOldView() {
            return oldView;
        }

        /**
         * Returns the view being activated.
         *
         * @return new View
         */
        public View getNewView() {
            return newView;
        }

        /**
         * Returns the view name of the view being activated.
         *
         * @return view name of the new View
         */
        public String getViewName() {
            return viewName;
        }

        /**
         * Returns the parameters for the view being activated.
         *
         * @return navigation parameters (potentially bookmarkable) for the new
         *         view
         */
        public String getParameters() {
            return parameters;
        }
    }

    /**
     * Invoked before the view is changed.
     * <p>
     * This method may e.g. open a "save" dialog or question about the change,
     * which may re-initiate the navigation operation after user action.
     * <p>
     * If this listener does not want to block the view change (e.g. does not
     * know the view in question), it should return true. If any listener
     * returns false, the view change is not allowed and
     * <code>afterViewChange()</code> methods are not called.
     *
     * @param event
     *            view change event
     * @return true if the view change should be allowed or this listener does
     *         not care about the view change, false to block the change
     */
    public boolean beforeViewChange(ViewChangeEvent event);

    /**
     * Invoked after the view is changed. If a <code>beforeViewChange</code>
     * method blocked the view change, this method is not called. Be careful of
     * unbounded recursion if you decide to change the view again in the
     * listener.
     *
     * @param event
     *            view change event
     */
    public void afterViewChange(ViewChangeEvent event);

}
