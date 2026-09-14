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

import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;

@Schema(
    description = "An enum representing the format of an asset or custom ruleset. Matching formats determine which rulesets apply to which assets."
)
@RequiredArgsConstructor
public enum Format {
    GRAVITEE_PROXY("gravitee_proxy"),
    GRAVITEE_MESSAGE("gravitee_message"),
    GRAVITEE_FEDERATED("gravitee_federated"),
    GRAVITEE_NATIVE("gravitee_native"),
    GRAVITEE_V2("gravitee_v2"),
    OPENAPI("openapi"),
    ASYNCAPI("asyncapi");

    @JsonValue
    final String value;
}
