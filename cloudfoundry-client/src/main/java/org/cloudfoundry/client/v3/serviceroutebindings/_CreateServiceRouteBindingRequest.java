/*
 * Copyright 2013-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.client.v3.serviceroutebindings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.cloudfoundry.AllowNulls;
import org.cloudfoundry.Nullable;
import org.cloudfoundry.client.v3.Metadata;
import org.immutables.value.Value;

import java.util.Map;

/**
 * The request payload for the Create Service Route Binding operation
 */
@JsonSerialize
@Value.Immutable
abstract class _CreateServiceRouteBindingRequest {

    /**
     * The relationships
     */
    @JsonProperty("relationships")
    abstract ServiceRouteBindingRelationships getRelationships();

    /**
     * The parameters passed to the service broker
     */
    @AllowNulls
    @JsonProperty("parameters")
    @Nullable
    abstract Map<String, Object> getParameters();

    /**
     * The metadata
     */
    @JsonProperty("metadata")
    @Nullable
    abstract Metadata getMetadata();

}