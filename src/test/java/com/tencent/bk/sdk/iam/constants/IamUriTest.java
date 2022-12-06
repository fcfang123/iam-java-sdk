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

package com.tencent.bk.sdk.iam.constants;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.sdk.iam.dto.grant.GrantPolicyDTO;
import com.tencent.bk.sdk.iam.dto.response.ResponseDTO;
import com.tencent.bk.sdk.iam.util.JsonUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IamUriTest {

    @Test
    public void test() {
        String roleId = "27";
        String type = ManagerScopesEnum.getType(ManagerScopesEnum.USER);
        String members = "zhangsan,lisi";
        String url = String.format(IamUri.MANAGER_ROLE_GROUP_MEMBER_DEL, roleId, type, members);
        System.out.println(url);
    }

    @Test
    public void test1() {
        String str = "{\"data\":{\"policy_id\":468,\"statistics\":{\"instance_count\":1}},\"result\":true,\"code\":0,\"message\":\"OK\"}";
        ResponseDTO<GrantPolicyDTO> responseInfo;
        try {
            responseInfo = JsonUtil.fromJson(str,
                new TypeReference<ResponseDTO<GrantPolicyDTO>>() {
                });
            System.out.println(responseInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
