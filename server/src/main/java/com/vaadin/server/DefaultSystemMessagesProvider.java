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

package com.vaadin.server;

/**
 * System messages provider using the built-in default system messages. This
 * singleton is accessed using {@link #get()}.
 *
 * @author Vaadin Ltd
 * @since 7.0.0
 */
public class DefaultSystemMessagesProvider implements SystemMessagesProvider {

    private static final DefaultSystemMessagesProvider instance = new DefaultSystemMessagesProvider();

    private DefaultSystemMessagesProvider() {
        // Singleton
    }

    @Override
    public SystemMessages getSystemMessages(
            SystemMessagesInfo systemMessagesInfo) {
        return ServletPortletHelper.DEFAULT_SYSTEM_MESSAGES;
    }

    /**
     * Gets the instance.
     *
     * @return the default system messages provider.
     */
    public static SystemMessagesProvider get() {
        return instance;
    }

}
