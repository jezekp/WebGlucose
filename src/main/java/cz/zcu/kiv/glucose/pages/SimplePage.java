package cz.zcu.kiv.glucose.pages;

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
 * SimplePage, 2015/09/16 11:47 petr-jezek
 **********************************************************************************************************************/
import cz.zcu.kiv.glucose.services.Welcome;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class SimplePage extends WebPage {

    @SpringBean
    private Welcome helloService;

    public SimplePage(final PageParameters parameters) {

        add(new Label("msg", helloService.getWelcomeMsg()));

    }

}