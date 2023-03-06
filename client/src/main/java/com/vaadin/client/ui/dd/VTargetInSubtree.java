/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
/**
 *
 */
package com.vaadin.client.ui.dd;

import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.UIDL;
import com.vaadin.client.ui.VTree;
import com.vaadin.client.ui.VTree.TreeNode;
import com.vaadin.shared.ui.dd.AcceptCriterion;
import com.vaadin.ui.Tree;

@AcceptCriterion(Tree.TargetInSubtree.class)
final public class VTargetInSubtree extends VAcceptCriterion {

    @Override
    protected boolean accept(VDragEvent drag, UIDL configuration) {

        VTree tree = (VTree) VDragAndDropManager.get().getCurrentDropHandler()
                .getConnector().getWidget();
        TreeNode treeNode = tree
                .getNodeByKey((String) drag.getDropDetails().get("itemIdOver"));
        if (treeNode != null) {
            Widget parent2 = treeNode;
            int depth = configuration.getIntAttribute("depth");
            if (depth < 0) {
                depth = Integer.MAX_VALUE;
            }
            final String searchedKey = configuration.getStringAttribute("key");
            for (int i = 0; i <= depth && parent2 instanceof TreeNode; i++) {
                if (searchedKey.equals(((TreeNode) parent2).key)) {
                    return true;
                }
                // panel -> next level node
                parent2 = parent2.getParent().getParent();
            }
        }

        return false;
    }
}
