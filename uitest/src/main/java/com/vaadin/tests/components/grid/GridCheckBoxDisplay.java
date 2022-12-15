/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import java.io.Serializable;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Grid;

public class GridCheckBoxDisplay extends AbstractTestUI {

    private static final long serialVersionUID = -5575892909354637168L;
    private BeanItemContainer<Todo> todoContainer = new BeanItemContainer<Todo>(
            Todo.class);

    @Override
    protected void setup(VaadinRequest request) {
        todoContainer.addBean(new Todo("Done task", true));
        todoContainer.addBean(new Todo("Not done", false));

        Grid grid = new Grid(todoContainer);
        grid.setSizeFull();

        grid.setColumnOrder("done", "task");
        grid.getColumn("done").setWidth(75);
        grid.getColumn("task").setExpandRatio(1);

        grid.setSelectionMode(Grid.SelectionMode.SINGLE);

        grid.setEditorEnabled(true);
        grid.setImmediate(true);

        getLayout().addComponent(grid);
        getLayout().setExpandRatio(grid, 1);

    }

    @Override
    protected Integer getTicketNumber() {
        return 16976;
    }

    @Override
    public String getDescription() {
        return "Verify that checkbox state is correct for all items in editor";
    }

    public class Todo implements Serializable {
        private static final long serialVersionUID = -5961103142478316018L;

        private boolean done;
        private String task = "";

        public Todo(String task, boolean done) {
            this.task = task;
            this.done = done;
        }

        public boolean isDone() {
            return done;
        }

        public void setDone(boolean done) {
            this.done = done;
        }

        public String getTask() {
            return task;
        }

        public void setTask(String task) {
            this.task = task;
        }
    }

}
