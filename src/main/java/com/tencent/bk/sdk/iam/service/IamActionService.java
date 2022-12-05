package com.tencent.bk.sdk.iam.service;

import com.tencent.bk.sdk.iam.dto.action.ActionDTO;
import com.tencent.bk.sdk.iam.dto.action.ActionGroupDTO;
import com.tencent.bk.sdk.iam.dto.action.ActionUpdateDTO;
import com.tencent.bk.sdk.iam.dto.resource.ResourceCreatorActionsDTO;

import java.util.List;

public interface IamActionService {
    // 获取系统注册的所有的action
    ResourceCreatorActionsDTO getResourceCreatorAction();

    ActionDTO getAction(String actionId);

    Boolean createAction(List<ActionDTO> actionDTO);

    Boolean updateAction(String actionId, ActionUpdateDTO actionDTO);

    /**
     * @param actionId
     * @param checkExistence 默认会检查 id 存在, 不存在将导致删除失败, 设置 false 不检查 id 是否存在, 直接走删除
     * @return
     */
    Boolean deleteAction(String actionId, Boolean checkExistence);

    // 操作组
    ActionGroupDTO getActionGroup(String groupName);

    Boolean createActionGroup(List<ActionGroupDTO> actionGroupDTO);

    Boolean updateActionGroup(List<ActionGroupDTO> actionGroupDTO);


    // 新建关联操作
    Boolean createResourceCreatorAction(ResourceCreatorActionsDTO resourceCreatorActionsDTO);

    // 修改关联操作
    Boolean updateResourceCreatorAction(ResourceCreatorActionsDTO resourceCreatorActionsDTO);
}
