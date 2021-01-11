/*
 * Copyright 2000-2020 Vaadin Ltd.
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

package com.vaadin.client;

/**
 * An interface used by client-side widgets or paintable parts to receive
 * updates from the corresponding server-side components in the form of
 * {@link UIDL}.
 *
 * Updates can be sent back to the server using the
 * {@link ApplicationConnection#updateVariable()} methods.
 */
@Deprecated
public interface Paintable {

    public void updateFromUIDL(UIDL uidl, ApplicationConnection client);
}
