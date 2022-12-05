package com.tencent.bk.sdk.iam.service.v2;

import com.tencent.bk.sdk.iam.dto.V2BelongDTO;
import com.tencent.bk.sdk.iam.dto.V2QueryPolicyDTO;

import java.util.Map;

public interface V2PolicyService {
    /**
     * 鉴权
     */
    public Boolean verifyPermissions(V2QueryPolicyDTO queryPolicyDTO);

    /**
     * 校验用户是否某个用户组的有效成员
     */
    public Map<Integer, Boolean> verifyRoleGruopMember(V2BelongDTO V2BelongDTO);
}
