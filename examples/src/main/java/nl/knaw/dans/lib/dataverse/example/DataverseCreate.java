/*
 * Copyright (C) 2021 DANS - Data Archiving and Networked Services (info@dans.knaw.nl)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.knaw.dans.lib.dataverse.example;

import lombok.extern.slf4j.Slf4j;
import nl.knaw.dans.lib.dataverse.DataverseHttpResponse;
import nl.knaw.dans.lib.dataverse.ExampleBase;
import nl.knaw.dans.lib.dataverse.model.dataverse.Dataverse;
import nl.knaw.dans.lib.dataverse.model.dataverse.DataverseContact;
import nl.knaw.dans.lib.dataverse.model.dataverse.DataverseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Slf4j
public class DataverseCreate extends ExampleBase {

    public static void main(String[] args) throws Exception {
        Dataverse dataverse = new Dataverse();
        dataverse.setDataverseType(DataverseType.JOURNALS);
        dataverse.setName("A Test Dataverse");
        dataverse.setAlias("test");
        dataverse.setDescription("This is a longer description than 'name' and 'alias'");
        dataverse.setDataverseContacts(
            Arrays.asList(
                new DataverseContact(0, "dummy@email.com"),
                new DataverseContact(1, "dummier@email.com")));
        log.info("--- BEGIN JSON OBJECT ---");
        log.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataverse));
        DataverseHttpResponse<Dataverse> r = client.dataverse("root").create(dataverse);
        log.info("--- END JSON OBJECT ---");
        log.info("Status Line: {}", r.getHttpResponse().getStatusLine());
        log.info("Created: {}", r.getData().getDescription());
        log.info("Creation Date: {}", r.getData().getCreationDate());
    }
}
