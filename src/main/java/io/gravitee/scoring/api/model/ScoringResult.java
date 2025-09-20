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
package io.gravitee.scoring.api.model;

import io.gravitee.scoring.api.model.diagnostic.AssetDiagnostic;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.List;

/**
 * @author Remi Baptiste (remi.baptiste at graviteesource.com)
 * @author GraviteeSource Team
 */
@Schema(description = "An object that represents the result of the scoring operation.")
public record ScoringResult(
    List<AssetDiagnostic> assetDiagnostics,
    @Schema(description = "A boolean that indicates whether the scoring operation was successful.") boolean success,
    @Schema(description = "A string that contains an error message if the scoring operation failed.") String error
) implements Serializable {
    public ScoringResult(List<AssetDiagnostic> assetDiagnostics) {
        this(assetDiagnostics, true, null);
    }

    public ScoringResult(String error) {
        this(List.of(), false, error);
    }
}
