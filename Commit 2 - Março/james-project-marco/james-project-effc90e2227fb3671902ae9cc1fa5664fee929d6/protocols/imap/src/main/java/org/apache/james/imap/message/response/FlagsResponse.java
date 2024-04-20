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

package org.apache.james.imap.message.response;

import java.util.Objects;

import jakarta.mail.Flags;

import org.apache.james.imap.api.message.response.ImapResponseMessage;

/**
 * Carries a RFC3501 <code>Flags</code> response.
 */
public class FlagsResponse implements ImapResponseMessage {
    private final Flags flags;

    public FlagsResponse(Flags flags) {
        this.flags = flags;
    }

    public Flags getFlags() {
        return flags;
    }

    @Override
    public final boolean equals(Object o) {
        if (o instanceof FlagsResponse) {
            FlagsResponse that = (FlagsResponse) o;

            return Objects.equals(this.flags, that.flags);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(flags);
    }

    @Override
    public String toString() {
        return "Flags: " + flags;
    }
}
