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
package org.apache.james.server.core;

import org.apache.james.filesystem.api.JamesDirectoriesProvider;

import com.google.common.base.MoreObjects;

public class JamesServerResourceLoader implements JamesDirectoriesProvider {

    private final String rootDirectory;

    public JamesServerResourceLoader(String rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    @Override
    public String getAbsoluteDirectory() {
        return "/";
    }

    @Override
    public String getConfDirectory() {
        return getRootDirectory() + "/conf/";
    }

    @Override
    public String getVarDirectory() {
        return getRootDirectory() + "/var/";
    }

    /**
     * Return the directory where the external jar libraries must be placed
     * by the administrator. The jars may contain mailets, jdbc drivers,...
     * 
     * @return externalLibraryDirectory
     */
    public String getExternalLibraryDirectory() {
        return getRootDirectory() + "/conf/lib/";
    }

    @Override
    public String getRootDirectory() {
        return rootDirectory;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("rootDirectory", rootDirectory)
            .add("varDirectory", getVarDirectory())
            .add("confDirectory", getConfDirectory())
            .toString();
    }
}