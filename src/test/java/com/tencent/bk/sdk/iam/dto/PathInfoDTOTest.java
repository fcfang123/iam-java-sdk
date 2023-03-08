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

package com.tencent.bk.sdk.iam.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author citruswang
 * @since 5/6/2020 20:34
 */
class PathInfoDTOTest {

    @Test
    void testToString() {
        PathInfoDTO pathInfo = new PathInfoDTO();
        pathInfo.setType("a");
        pathInfo.setId("1");
        pathInfo.setChild(new PathInfoDTO());
        pathInfo.getChild().setType("b");
        pathInfo.getChild().setId("2");
        assertEquals(pathInfo.toString(), "/a,1/b,2/");
    }

    @Test
    void testSystemPathInfoToString() {
        PathInfoDTO pathInfo = new PathInfoDTO();
        pathInfo.setSystem("bk_ci_rbac");
        pathInfo.setType("a");
        pathInfo.setId("1");
        pathInfo.setChild(new PathInfoDTO());
        pathInfo.getChild().setSystem("bk_ci_rbac");
        pathInfo.getChild().setType("b");
        pathInfo.getChild().setId("2");
        assertEquals(pathInfo.toString(), "/bk_ci_rbac,a,1/bk_ci_rbac,b,2/");
    }
}
