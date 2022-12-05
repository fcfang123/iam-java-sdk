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
