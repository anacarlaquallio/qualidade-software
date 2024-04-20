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

package org.apache.james.quota.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OffsetTest {
    @Test
    public void shouldMatchBeanContract() {
        EqualsVerifier.forClass(Offset.class)
            .verify();
    }

    @Test
    public void getValueShouldReturnZeroWhenNone() {
        assertThat(Offset.none()
            .getValue())
            .isEqualTo(0);
    }

    @Test
    public void getValueShouldReturnZeroWhenZero() {
        assertThat(Offset.of(0)
            .getValue())
            .isEqualTo(0);
    }

    @Test
    public void getValueShouldReturnSuppliedValue() {
        assertThat(Offset.of(3)
            .getValue())
            .isEqualTo(3);
    }

    @Test
    public void ofShouldThrowOnNegativeValue() {
        assertThatThrownBy(() -> Offset.of(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}