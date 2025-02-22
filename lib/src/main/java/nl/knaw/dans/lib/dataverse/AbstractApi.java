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
package nl.knaw.dans.lib.dataverse;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
abstract class AbstractApi {

    protected final HttpClientWrapper httpClientWrapper;

    protected AbstractApi(HttpClientWrapper httpClientWrapper) {
        this.httpClientWrapper = httpClientWrapper;
    }

    protected Path buildPath(Path base, String... components) {
        Path p = base;
        for (String c : components) {
            if (StringUtils.isNotBlank(c)) {
                p = p.resolve(c + "/");
            }
        }
        return p;
    }

    protected static final String MDKEY_PARAM_NAME_PREFIX = "mdkey.";

    protected Map<String, List<String>> getQueryParamsFromMetadataKeys(Map<String, String> metadataKeys) {
        return metadataKeys.entrySet().stream()
            .collect(Collectors.toMap(
                e -> MDKEY_PARAM_NAME_PREFIX + e.getKey(),
                e -> Collections.singletonList(e.getValue())
            ));
    }
}
