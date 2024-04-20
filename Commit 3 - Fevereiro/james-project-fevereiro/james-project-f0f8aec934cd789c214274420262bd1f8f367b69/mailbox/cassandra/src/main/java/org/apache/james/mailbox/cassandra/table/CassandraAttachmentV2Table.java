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

package org.apache.james.mailbox.cassandra.table;

import com.datastax.oss.driver.api.core.CqlIdentifier;

public interface CassandraAttachmentV2Table {

    String TABLE_NAME = "attachmentV2";
    CqlIdentifier ID_AS_UUID = CqlIdentifier.fromCql("idAsUUID");
    CqlIdentifier ID = CqlIdentifier.fromCql("id");
    CqlIdentifier BLOB_ID = CqlIdentifier.fromCql("blobId");
    CqlIdentifier MESSAGE_ID = CqlIdentifier.fromCql("message_id");
    CqlIdentifier TYPE = CqlIdentifier.fromCql("type");
    CqlIdentifier SIZE = CqlIdentifier.fromCql("size");
    CqlIdentifier[] FIELDS = { ID, BLOB_ID, MESSAGE_ID, TYPE, SIZE };

}
