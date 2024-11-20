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

import io.gravitee.scoring.api.model.asset.AssetToAnalyze;
import io.gravitee.scoring.api.model.functions.CustomFunction;
import io.gravitee.scoring.api.model.ruleset.CustomRuleset;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author Remi Baptiste (remi.baptiste at graviteesource.com)
 * @author GraviteeSource Team
 */
@Schema(description = "An object that represents a request to score a list of assets.")
public record ScoringRequest(
    List<AssetToAnalyze> assets,
    @Deprecated(since = "0.4", forRemoval = true) List<String> customRulesets,
    Collection<CustomRuleset> rulesets,
    Collection<CustomFunction> functions
)
    implements Serializable {
    public ScoringRequest(List<AssetToAnalyze> assets) {
        this(assets, null, null, null);
    }

    @Deprecated(since = "0.4", forRemoval = true)
    public ScoringRequest(List<AssetToAnalyze> assets, List<String> customRulesets) {
        this(assets, customRulesets, null, null);
    }
}
