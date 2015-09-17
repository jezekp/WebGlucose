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
 * FileUploadPage, 2015/09/16 11:47 petr-jezek
 **********************************************************************************************************************/

import cz.zcu.kiv.glucose.services.Converter;
import jdk.internal.util.xml.impl.Input;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.io.File;
import java.io.InputStream;

public class FileUploadPage extends WebPage {

    @SpringBean
    private Converter converter;
    private FileUploadField fileUpload;

    public FileUploadPage(final PageParameters parameters) {

        add(new FeedbackPanel("feedback"));

        Form<?> form = new Form<Void>("form") {
            @Override
            protected void onSubmit() {

                final FileUpload uploadedFile = fileUpload.getFileUpload();
                if (uploadedFile != null) {

                    try {
                        InputStream stream = uploadedFile.getInputStream();
                        converter.convert(stream);
                        stream.close();
                        info("saved file: " + uploadedFile.getClientFileName());
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }

            }

        };

        // Enable multipart mode (need for uploads file)
        form.setMultiPart(true);

        form.add(fileUpload = new FileUploadField("fileUpload"));

        add(form);

    }

}