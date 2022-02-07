/*
 * Copyright 2000-2022 Vaadin Ltd.
 *
 * Licensed under the Commercial Vaadin Developer License version 4.0 (CVDLv4);
 * you may not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 * https://vaadin.com/license/cvdl-4.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.shared.ui.tabsheet;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.shared.annotations.NoLayout;

public class TabsheetState extends AbstractComponentState {
    public static final String PRIMARY_STYLE_NAME = "v-tabsheet";

    {
        primaryStyleName = PRIMARY_STYLE_NAME;
    }

    /**
     * Index of the component when switching focus - not related to Tabsheet
     * tabs.
     */
    @NoLayout
    public int tabIndex;

    public List<TabState> tabs = new ArrayList<TabState>();

    /** true to show the tab bar, false to only show the contained component */
    public boolean tabsVisible = true;

    /** the key of the currently selected tab */
    public String selected;

    @DelegateToWidget
    public boolean tabCaptionsAsHtml = false;

}
