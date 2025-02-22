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
package nl.knaw.dans.lib.dataverse.model.file;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties({ "md5" }) // The optional "md5" property is redundant and only there for backward compatibility. 
public class DataFile {
    private int id;
    private String persistentId;
    private String pidURL;
    private String filename;
    private String contentType;
    private long filesize;
    private String description;
    private Embargo embargo;
    private String storageIdentifier;
    private String originalFileFormat;
    private String originalFormatLabel;
    private Long originalFileSize;
    private String originalFileName;
    @JsonProperty("UNF")
    private String unf;
    private int rootDataFileId;
    private Checksum checksum;
    private String creationDate;
    private int previousDataFileId;
}
