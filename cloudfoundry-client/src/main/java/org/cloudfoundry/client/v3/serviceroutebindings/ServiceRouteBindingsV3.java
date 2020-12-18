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

import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * Main entry point to the Cloud Foundry Service Route Bindings V3 Client API
 */
public interface ServiceRouteBindingsV3 {

    Mono<Void> create(CreateServiceRouteBindingRequest request);

    Mono<Void> delete(DeleteServiceRouteBindingRequest request);

    Mono<GetServiceRouteBindingResponse> get(GetServiceRouteBindingRequest request);

    Mono<Map<String, Object>> getParameters(GetServiceRouteBindingParametersRequest request);

    Mono<ListServiceRouteBindingsResponse> list(ListServiceRouteBindingsRequest request);

    Mono<UpdateServiceRouteBindingResponse> update(UpdateServiceRouteBindingRequest request);

}
