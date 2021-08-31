/*
 * Copyright 2000-2021 Vaadin Ltd.
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
package com.vaadin.tests.widgetset.client;

import com.vaadin.client.ui.label.LabelConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.MediaControl;
import com.vaadin.tests.widgetset.server.ClientRpcClassComponent;

@Connect(ClientRpcClassComponent.class)
public class ClientRpcClassConnector extends LabelConnector {

    @Override
    protected void init() {
        super.init();
        registerRpc(MediaControl.class, getWidget());
    }

    @Override
    public ClientRpcClassWidget getWidget() {
        return (ClientRpcClassWidget) super.getWidget();
    }
}
