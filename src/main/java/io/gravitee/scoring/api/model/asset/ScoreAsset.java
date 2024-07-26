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

/**
 * @author Remi Baptiste (remi.baptiste at graviteesource.com)
 * @author GraviteeSource Team
 */
@Schema(description = "An object that represents an asset to be scored.")
public record ScoreAsset(
    AssetType type,
    @Schema(description = "A string that contains the file name of the document to be analyzed.") String filename,
    @Schema(description = "A string that contains the content of the document to be analyzed.") String content,
    ContentType contentType
)
    implements Serializable {}
