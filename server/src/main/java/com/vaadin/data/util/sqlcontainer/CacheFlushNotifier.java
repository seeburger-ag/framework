/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.util.sqlcontainer;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.util.sqlcontainer.query.FreeformQuery;
import com.vaadin.data.util.sqlcontainer.query.QueryDelegate;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;

/**
 * CacheFlushNotifier is a simple static notification mechanism to inform other
 * SQLContainers that the contents of their caches may have become stale.
 */
class CacheFlushNotifier implements Serializable {
    /*
     * SQLContainer instance reference list and dead reference queue. Used for
     * the cache flush notification feature.
     */
    private static List<WeakReference<SQLContainer>> allInstances = new ArrayList<WeakReference<SQLContainer>>();
    private static ReferenceQueue<SQLContainer> deadInstances = new ReferenceQueue<SQLContainer>();

    /**
     * Adds the given SQLContainer to the cache flush notification receiver list
     *
     * @param c
     *            Container to add
     */
    public static void addInstance(SQLContainer c) {
        removeDeadReferences();
        if (c != null) {
            allInstances.add(new WeakReference<SQLContainer>(c, deadInstances));
        }
    }

    /**
     * Removes dead references from instance list
     */
    private static void removeDeadReferences() {
        java.lang.ref.Reference<? extends SQLContainer> dead = deadInstances
                .poll();
        while (dead != null) {
            allInstances.remove(dead);
            dead = deadInstances.poll();
        }
    }

    /**
     * Iterates through the instances and notifies containers which are
     * connected to the same table or are using the same query string.
     *
     * @param c
     *            SQLContainer that issued the cache flush notification
     */
    public static void notifyOfCacheFlush(SQLContainer c) {
        removeDeadReferences();
        for (WeakReference<SQLContainer> wr : allInstances) {
            if (wr.get() != null) {
                SQLContainer wrc = wr.get();
                if (wrc == null) {
                    continue;
                }
                /*
                 * If the reference points to the container sending the
                 * notification, do nothing.
                 */
                if (wrc.equals(c)) {
                    continue;
                }
                /* Compare QueryDelegate types and tableName/queryString */
                QueryDelegate wrQd = wrc.getQueryDelegate();
                QueryDelegate qd = c.getQueryDelegate();
                if (wrQd instanceof TableQuery && qd instanceof TableQuery
                        && ((TableQuery) wrQd).getTableName()
                                .equals(((TableQuery) qd).getTableName())) {
                    wrc.refresh();
                } else if (wrQd instanceof FreeformQuery
                        && qd instanceof FreeformQuery
                        && ((FreeformQuery) wrQd).getQueryString().equals(
                                ((FreeformQuery) qd).getQueryString())) {
                    wrc.refresh();
                }
            }
        }
    }
}
