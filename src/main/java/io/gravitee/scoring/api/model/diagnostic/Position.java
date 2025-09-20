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

/**
 * @author Remi Baptiste (remi.baptiste at graviteesource.com)
 * @author GraviteeSource Team
 */
@Schema(description = "An object that represents a position within a file. The position is defined by a line and a character.")
public record Position(
    @Schema(
        description = "An integer that represents the character position within the line where the issue starts or ends. The value is zero indexed.",
        minimum = "0"
    )
    int line,
    @Schema(
        description = "An integer that represents the character position within the line where the issue starts or ends. The value is zero indexed.",
        minimum = "0"
    )
    int character
) implements Serializable, Comparable<Position> {
    private static final Comparator<Position> POSITION_COMPARATOR = Comparator.comparing(Position::line).thenComparing(Position::character);

    @Override
    public int compareTo(Position other) {
        return POSITION_COMPARATOR.compare(this, other);
    }
}
