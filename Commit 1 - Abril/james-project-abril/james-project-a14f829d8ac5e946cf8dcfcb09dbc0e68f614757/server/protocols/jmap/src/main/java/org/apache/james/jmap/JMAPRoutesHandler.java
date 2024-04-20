/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james.jmap;

import java.util.Set;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableSet;

public class JMAPRoutesHandler {
    private final Version version;
    private final Set<JMAPRoutes> routes;

    public JMAPRoutesHandler(Version version, JMAPRoutes... routes) {
        this.version = version;
        this.routes = ImmutableSet.copyOf(routes);
    }

    public JMAPRoutesHandler(Version version, Set<JMAPRoutes> routes) {
        this.version = version;
        this.routes = routes;
    }

    Stream<JMAPRoute> routes(Version versionRequest) {
        if (version.equals(versionRequest)) {
            return routes.stream()
                .flatMap(JMAPRoutes::routes);
        }
        return Stream.of();
    }
}
