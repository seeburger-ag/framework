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
package com.vaadin.tests.applicationservlet;

import com.vaadin.launcher.CustomDeploymentConfiguration;
import com.vaadin.launcher.CustomDeploymentConfiguration.Conf;
import com.vaadin.server.Constants;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;

@CustomDeploymentConfiguration({
        @Conf(name = Constants.SERVLET_PARAMETER_SENDURLSASPARAMETERS, value = "false") })
public class DisableSendUrlAsParameters extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        try {
            log("Init location: " + getPage().getLocation());
        } catch (IllegalStateException e) {
            log("Init location exception: " + e.getMessage());
        }
    }

}
