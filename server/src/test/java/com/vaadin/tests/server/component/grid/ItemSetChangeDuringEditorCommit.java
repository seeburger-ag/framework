/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.grid;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.ServerRpcManager.RpcInvocationException;
import com.vaadin.server.ServerRpcMethodInvocation;
import com.vaadin.shared.ui.grid.EditorServerRpc;
import com.vaadin.tests.util.MockUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class ItemSetChangeDuringEditorCommit {

    private static class IndexedContainerImpl extends IndexedContainer {

        public IndexedContainerImpl() {
        }

        @Override
        public void fireItemSetChange() {
            super.fireItemSetChange();
        }
    }

    @Test
    public void itemSetChangeDoesNotInterruptCommit()
            throws RpcInvocationException, CommitException {
        UI ui = new MockUI();
        final IndexedContainerImpl indexedContainer = new IndexedContainerImpl();
        indexedContainer.addContainerProperty("firstName", String.class,
                "first");
        indexedContainer.addContainerProperty("lastName", String.class, "last");
        indexedContainer.addItem();
        indexedContainer.addItem();

        Grid grid = new Grid();
        ui.setContent(grid);
        grid.setContainerDataSource(indexedContainer);
        grid.setEditorEnabled(true);
        grid.getEditorFieldGroup()
                .addCommitHandler(new FieldGroup.CommitHandler() {
                    @Override
                    public void preCommit(FieldGroup.CommitEvent commitEvent)
                            throws FieldGroup.CommitException {
                    }

                    @Override
                    public void postCommit(FieldGroup.CommitEvent commitEvent)
                            throws FieldGroup.CommitException {
                        indexedContainer.fireItemSetChange();
                    }
                });

        editItem(grid, 0);
        ((TextField) grid.getEditorFieldGroup().getField("firstName"))
                .setValue("New first");
        ((TextField) grid.getEditorFieldGroup().getField("lastName"))
                .setValue("New last");
        grid.saveEditor();

        Assert.assertEquals("New first", indexedContainer
                .getContainerProperty(grid.getEditedItemId(), "firstName")
                .getValue());
        Assert.assertEquals("New last", indexedContainer
                .getContainerProperty(grid.getEditedItemId(), "lastName")
                .getValue());

        grid.cancelEditor();
        Assert.assertFalse(grid.isEditorActive());

        editItem(grid, 0);
        Assert.assertEquals("New first",
                ((TextField) grid.getEditorFieldGroup().getField("firstName"))
                        .getValue());
        Assert.assertEquals("New last",
                ((TextField) grid.getEditorFieldGroup().getField("lastName"))
                        .getValue());
        saveEditor(grid, 0);
    }

    private void editItem(Grid grid, int itemIndex)
            throws RpcInvocationException {
        ServerRpcMethodInvocation invocation = new ServerRpcMethodInvocation(
                grid.getConnectorId(), EditorServerRpc.class, "bind", 1);
        invocation.setParameters(new Object[] { itemIndex });
        grid.getRpcManager(EditorServerRpc.class.getName())
                .applyInvocation(invocation);
        Assert.assertTrue(grid.isEditorActive());

    }

    private void saveEditor(Grid grid, int itemIndex)
            throws RpcInvocationException {
        ServerRpcMethodInvocation invocation = new ServerRpcMethodInvocation(
                grid.getConnectorId(), EditorServerRpc.class, "save", 1);
        invocation.setParameters(new Object[] { itemIndex });
        grid.getRpcManager(EditorServerRpc.class.getName())
                .applyInvocation(invocation);

    }
}
