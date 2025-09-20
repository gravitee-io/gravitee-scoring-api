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
package io.gravitee.scoring.api.model.diagnostic;

import io.gravitee.scoring.api.model.asset.AssetAnalyzed;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Collection;

@Schema(description = "An object that represents the diagnostics for a specific asset.")
public record AssetDiagnostic(
    @Schema(description = "The document that was analyzed.") AssetAnalyzed asset,
    @Schema(description = "An array of diagnostic messages that represent the issues found in the asset.")
    Collection<Diagnostic> diagnostics,
    @Schema(description = "An array of errors.") Collection<ScoringError> errors
) implements Serializable {}
