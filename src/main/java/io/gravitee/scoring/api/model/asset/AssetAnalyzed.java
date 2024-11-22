/*
 * Copyright © 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.scoring.api.model.asset;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

@Schema(description = "An object that represents an analyzed asset.")
public record AssetAnalyzed(
    @Schema(description = "Id of the document to be analyzed.") String assetId,
    @Schema(description = "Type of the document to be analyzed.") AssetType type,
    @Schema(description = "A string that contains the file name of the document to be analyzed.") String filename,
    ContentType contentType,
    @Schema(description = "The format of the asset content. Required only to analyze Gravitee API using custom rulesets") Format format
)
    implements Serializable {
    public AssetAnalyzed(String assetId, AssetType type, String filename, ContentType contentType) {
        this(assetId, type, filename, contentType, null);
    }
}
