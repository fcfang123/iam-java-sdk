package com.tencent.bk.sdk.iam.service;

import com.tencent.bk.sdk.iam.dto.grant.BatchGrantPolicyDTO;
import com.tencent.bk.sdk.iam.dto.grant.GrantPolicyDTO;
import com.tencent.bk.sdk.iam.dto.grant.GrantResourceDTO;

import java.util.List;

public interface GrantService {
    /**
     * 给用户授予权限
     */
    GrantPolicyDTO grantPermission(String userId, String action, List<GrantResourceDTO> resources);

    /**
     * 收回用户权限
     */
    GrantPolicyDTO revokePermission(String userId, String action, List<GrantResourceDTO> resources);

    /**
     * 给用户批量授予权限
     */
    List<BatchGrantPolicyDTO> batchRevokePermission(String userId, List<String> actions, List<GrantResourceDTO> resources);

    /**
     * 批量收回用户权限
     */
    List<BatchGrantPolicyDTO> batchGrantPermission(String userId, List<String> actions, List<GrantResourceDTO> resources);
}
