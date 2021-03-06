package cz.zcu.kiv.glucose;

import cz.zcu.kiv.glucose.pages.FileUploadPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

/***********************************************************************************************************************
 * This file is part of the Glucose project
 * <p>
 * ==========================================
 * <p>
 * Copyright (C) 2015 by University of West Bohemia (http://www.zcu.cz/en/)
 * <p>
 * **********************************************************************************************************************
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * <p>
 * **********************************************************************************************************************
 * <p>
 * WicketApplication, 2015/09/16 11:47 petr-jezek
 **********************************************************************************************************************/
public class WicketApplication extends WebApplication {

    @Override
    public Class<FileUploadPage> getHomePage() {

        return FileUploadPage.class; // return default page
    }

    @Override
    protected void init() {

        super.init();
        addComponentInstantiationListener(new SpringComponentInjector(this));

    }

}
