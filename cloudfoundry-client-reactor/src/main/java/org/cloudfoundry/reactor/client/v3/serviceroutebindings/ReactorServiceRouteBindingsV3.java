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

package org.cloudfoundry.reactor.client.v3.serviceroutebindings;

import com.fasterxml.jackson.core.type.TypeReference;
import org.cloudfoundry.client.v3.serviceroutebindings.CreateServiceRouteBindingRequest;
import org.cloudfoundry.client.v3.serviceroutebindings.DeleteServiceRouteBindingRequest;
import org.cloudfoundry.client.v3.serviceroutebindings.GetServiceRouteBindingParametersRequest;
import org.cloudfoundry.client.v3.serviceroutebindings.GetServiceRouteBindingRequest;
import org.cloudfoundry.client.v3.serviceroutebindings.GetServiceRouteBindingResponse;
import org.cloudfoundry.client.v3.serviceroutebindings.ListServiceRouteBindingsRequest;
import org.cloudfoundry.client.v3.serviceroutebindings.ListServiceRouteBindingsResponse;
import org.cloudfoundry.client.v3.serviceroutebindings.ServiceRouteBindingsV3;
import org.cloudfoundry.client.v3.serviceroutebindings.UpdateServiceRouteBindingRequest;
import org.cloudfoundry.client.v3.serviceroutebindings.UpdateServiceRouteBindingResponse;
import org.cloudfoundry.reactor.ConnectionContext;
import org.cloudfoundry.reactor.TokenProvider;
import org.cloudfoundry.reactor.client.v3.AbstractClientV3Operations;
import reactor.core.publisher.Mono;

import java.util.Map;

public final class ReactorServiceRouteBindingsV3 extends AbstractClientV3Operations implements ServiceRouteBindingsV3 {

    /**
     * Creates an instance
     *
     * @param connectionContext the {@link ConnectionContext} to use when communicating with the server
     * @param root              the root URI of the server. Typically something like {@code https://api.run.pivotal.io}.
     * @param tokenProvider     the {@link TokenProvider} to use when communicating with the server
     * @param requestTags       map with custom http headers which will be added to web request
     */
    public ReactorServiceRouteBindingsV3(ConnectionContext connectionContext, Mono<String> root, TokenProvider tokenProvider, Map<String, String> requestTags) {
        super(connectionContext, root, tokenProvider, requestTags);
    }

    @Override
    public Mono<Void> create(CreateServiceRouteBindingRequest request) {
        return post(request, Void.class, uriComponentsBuilder -> uriComponentsBuilder.pathSegment("service_route_bindings"))
            .checkpoint();
    }

    @Override
    public Mono<Void> delete(DeleteServiceRouteBindingRequest request) {
        return delete(request, Void.class, uriComponentsBuilder -> uriComponentsBuilder.pathSegment("service_route_bindings", request.getServiceRouteBindingId()))
            .checkpoint();
    }

    @Override
    public Mono<GetServiceRouteBindingResponse> get(GetServiceRouteBindingRequest request) {
        return get(request, GetServiceRouteBindingResponse.class, uriComponentsBuilder -> uriComponentsBuilder.pathSegment("service_route_bindings", request.getServiceRouteBindingId()))
            .checkpoint();
    }

    @Override
    public Mono<Map<String, Object>> getParameters(GetServiceRouteBindingParametersRequest request) {
        TypeReference<Map<String, Object>> type = new TypeReference<Map<String, Object>>() {
        };
        @SuppressWarnings("unchecked")
        Class<Map<String, Object>> cls = (Class<Map<String, Object>>) type.getType();
        return get(request, cls, uriComponentsBuilder -> uriComponentsBuilder.pathSegment("service_route_bindings", request.getServiceRouteBindingId(), "parameters"))
            .checkpoint();
    }

    @Override
    public Mono<ListServiceRouteBindingsResponse> list(ListServiceRouteBindingsRequest request) {
        return get(request, ListServiceRouteBindingsResponse.class, uriComponentsBuilder -> uriComponentsBuilder.pathSegment("service_route_bindings"))
            .checkpoint();
    }

    @Override
    public Mono<UpdateServiceRouteBindingResponse> update(UpdateServiceRouteBindingRequest request) {
        return patch(request, UpdateServiceRouteBindingResponse.class, uriComponentsBuilder -> uriComponentsBuilder.pathSegment("service_route_bindings", request.getServiceRouteBindingId()))
            .checkpoint();
    }

}
