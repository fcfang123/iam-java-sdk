package com.tencent.bk.sdk.iam.service;

import java.util.List;

import com.tencent.bk.sdk.iam.dto.ExpressionWithResourceDTO;
import com.tencent.bk.sdk.iam.dto.UserGroupDTO;
import com.tencent.bk.sdk.iam.dto.action.ActionDTO;
import com.tencent.bk.sdk.iam.dto.action.ActionPolicyDTO;
import com.tencent.bk.sdk.iam.dto.expression.ExpressionDTO;
import com.tencent.bk.sdk.iam.dto.resource.ResourceDTO;

/**
 * @author citruswang
 * @since 18/3/2020 17:08
 */
public interface PolicyService {

    /**
     * 根据操作拉取权限表达式
     *
     * @param username     用户名
     * @param action       操作
     * @param resourceList 相关资源列表
     * @return 权限表达式
     */
    ExpressionDTO getPolicyByAction(String username, ActionDTO action,
                                    List<ResourceDTO> resourceList);

    /**
     * 根据操作列表批量拉取权限表达式
     *
     * @param username     用户名
     * @param actionList   操作列表
     * @param resourceList 相关资源列表
     * @return 操作关联的权限表达式列表
     */
    List<ActionPolicyDTO> batchGetPolicyByActionList(String username, List<ActionDTO> actionList,
                                                     List<ResourceDTO> resourceList);

    /**
     * 批量第三方依赖鉴权策略查询
     */
    ExpressionWithResourceDTO batchGetPolicyAndAttribute(String username, ActionDTO actionDTO, ResourceDTO selfResource, List<ResourceDTO> dependencyResource);
    /**
     * 获取用户加入的用户组
     */
    List<UserGroupDTO> getUserGroup(String username, Boolean inherit);
}
