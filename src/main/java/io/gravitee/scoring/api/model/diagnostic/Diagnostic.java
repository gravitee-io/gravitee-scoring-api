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

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Comparator;
import lombok.Builder;

/**
 * @author Remi Baptiste (remi.baptiste at graviteesource.com)
 * @author GraviteeSource Team
 */
@Schema(description = "An object that represents a diagnostic message for a specific rule violation.")
@Builder
public record Diagnostic(
    Range range,
    Severity severity,
    @Schema(
        description = "A string that represents the rule code that has been violated or triggered. This code is unique to each rule defined."
    )
    String rule,
    @Schema(
        description = "A string that contains a human-readable message describing the issue found. This message typically provides information on why the rule was triggered and how to fix the issue."
    )
    String message,
    @Schema(description = "A string that contains the file path of the document that was analyzed.") String asset,
    @Schema(
        description = "A string that indicates the location within the analyzed document where the rule was triggered. It shows the \"path\" in the document structure to the issue."
    )
    String path
) implements Serializable, Comparable<Diagnostic> {
    private static final Comparator<Diagnostic> DIAGNOSTIC_COMPARATOR = Comparator.comparing(Diagnostic::range)
        .thenComparing(Diagnostic::severity)
        .thenComparing(Diagnostic::rule)
        .thenComparing(Diagnostic::message);

    @Override
    public int compareTo(Diagnostic o) {
        return DIAGNOSTIC_COMPARATOR.compare(this, o);
    }
}
