/*
 * TencentBlueKing is pleased to support the open source community by making
 * 蓝鲸智云-权限中心Java SDK(iam-java-sdk) available.
 * Copyright (C) 2017-2021 THL A29 Limited, a Tencent company. All rights reserved.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://opensource.org/licenses/MIT
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.tencent.bk.sdk.iam.util;

import com.tencent.bk.sdk.iam.dto.PathInfoDTO;

public class PathBuilder {

    private final String id;

    private final String type;

    private PathBuilder child;

    private PathBuilder head;

    private PathBuilder(String type, String id) {
        this.type = type;
        this.id = id;
        this.head = this;
    }

    private PathBuilder(String type, String id, PathBuilder head) {
        this.type = type;
        this.id = id;
        this.head = head;
    }

    public static PathBuilder newBuilder(String type, String id) {
        return new PathBuilder(type, id);
    }

    public PathBuilder head(PathBuilder head) {
        this.head = head;
        return this;
    }

    public PathBuilder child(String type, String id) {
        this.child = new PathBuilder(type, id, this.head);
        return child;
    }

    public PathInfoDTO build() {
        if (this.head == this) {
            PathInfoDTO pathInfo = new PathInfoDTO();
            pathInfo.setType(type);
            pathInfo.setId(id);
            if (this.child != null) {
                pathInfo.setChild(this.child.head(this.child).build());
            }
            return pathInfo;
        } else {
            return this.head.build();
        }
    }
}
