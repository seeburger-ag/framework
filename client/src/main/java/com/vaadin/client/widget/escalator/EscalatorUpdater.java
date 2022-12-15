/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.widget.escalator;

import com.vaadin.client.widgets.Escalator;

/**
 * An interface that allows client code to define how a certain row in Escalator
 * will be displayed. The contents of an escalator's header, body and footer are
 * rendered by their respective updaters.
 * <p>
 * The updater is responsible for internally handling all remote communication,
 * should the displayed data need to be fetched remotely.
 * <p>
 * This has a similar function to {@link Grid Grid's} {@link Renderer Renderers}
 * , although they operate on different abstraction levels.
 *
 * @since 7.4
 * @author Vaadin Ltd
 * @see RowContainer#setEscalatorUpdater(EscalatorUpdater)
 * @see Escalator#getHeader()
 * @see Escalator#getBody()
 * @see Escalator#getFooter()
 * @see Renderer
 */
public interface EscalatorUpdater {

    /**
     * An {@link EscalatorUpdater} that doesn't render anything.
     */
    public static final EscalatorUpdater NULL = new EscalatorUpdater() {
        @Override
        public void update(final Row row,
                final Iterable<FlyweightCell> cellsToUpdate) {
            // NOOP
        }

        @Override
        public void preAttach(final Row row,
                final Iterable<FlyweightCell> cellsToAttach) {
            // NOOP

        }

        @Override
        public void postAttach(final Row row,
                final Iterable<FlyweightCell> attachedCells) {
            // NOOP
        }

        @Override
        public void preDetach(final Row row,
                final Iterable<FlyweightCell> cellsToDetach) {
            // NOOP
        }

        @Override
        public void postDetach(final Row row,
                final Iterable<FlyweightCell> detachedCells) {
            // NOOP
        }
    };

    /**
     * Renders a row contained in a row container.
     * <p>
     * <em>Note:</em> If rendering of cells is deferred (e.g. because
     * asynchronous data retrieval), this method is responsible for explicitly
     * displaying some placeholder data (empty content is valid). Because the
     * cells (and rows) in an escalator are recycled, failing to reset a cell's
     * presentation will lead to wrong data being displayed in the escalator.
     * <p>
     * For performance reasons, the escalator will never autonomously clear any
     * data in a cell.
     *
     * @param row
     *            Information about the row that is being updated.
     *            <em>Note:</em> You should not store nor reuse this reference.
     * @param cellsToUpdate
     *            A collection of cells that need to be updated. <em>Note:</em>
     *            You should neither store nor reuse the reference to the
     *            iterable, nor to the individual cells.
     */
    public void update(Row row, Iterable<FlyweightCell> cellsToUpdate);

    /**
     * Called before attaching new cells to the escalator.
     *
     * @param row
     *            Information about the row to which the cells will be added.
     *            <em>Note:</em> You should not store nor reuse this reference.
     * @param cellsToAttach
     *            A collection of cells that are about to be attached.
     *            <em>Note:</em> You should neither store nor reuse the
     *            reference to the iterable, nor to the individual cells.
     *
     */
    public void preAttach(Row row, Iterable<FlyweightCell> cellsToAttach);

    /**
     * Called after attaching new cells to the escalator.
     *
     * @param row
     *            Information about the row to which the cells were added.
     *            <em>Note:</em> You should not store nor reuse this reference.
     * @param attachedCells
     *            A collection of cells that were attached. <em>Note:</em> You
     *            should neither store nor reuse the reference to the iterable,
     *            nor to the individual cells.
     *
     */
    public void postAttach(Row row, Iterable<FlyweightCell> attachedCells);

    /**
     * Called before detaching cells from the escalator.
     *
     * @param row
     *            Information about the row from which the cells will be
     *            removed. <em>Note:</em> You should not store nor reuse this
     *            reference.
     * @param cellsToAttach
     *            A collection of cells that are about to be detached.
     *            <em>Note:</em> You should neither store nor reuse the
     *            reference to the iterable, nor to the individual cells.
     *
     */
    public void preDetach(Row row, Iterable<FlyweightCell> cellsToDetach);

    /**
     * Called after detaching cells from the escalator.
     *
     * @param row
     *            Information about the row from which the cells were removed.
     *            <em>Note:</em> You should not store nor reuse this reference.
     * @param attachedCells
     *            A collection of cells that were detached. <em>Note:</em> You
     *            should neither store nor reuse the reference to the iterable,
     *            nor to the individual cells.
     *
     */
    public void postDetach(Row row, Iterable<FlyweightCell> detachedCells);

}
