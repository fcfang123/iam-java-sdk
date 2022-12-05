package com.tencent.bk.sdk.iam.service.v2;

import com.tencent.bk.sdk.iam.dto.grant.ManagerRoleGroupGrantDTO;

public interface V2GrantService {
    /**
     * 用户组授权
     *
     * @param groupId
     * @param managerRoleGroupGrantDTO
     * @return
     */
    public void v2GrantRoleGroup(Integer groupId, ManagerRoleGroupGrantDTO managerRoleGroupGrantDTO);
}
