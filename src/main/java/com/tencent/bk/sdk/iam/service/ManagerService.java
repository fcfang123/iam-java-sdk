package com.tencent.bk.sdk.iam.service;

import com.tencent.bk.sdk.iam.dto.CreateRelationDTO;
import com.tencent.bk.sdk.iam.dto.PageInfoDTO;
import com.tencent.bk.sdk.iam.dto.PermissionUrlDTO;
import com.tencent.bk.sdk.iam.dto.manager.AuthorizationScopes;
import com.tencent.bk.sdk.iam.dto.manager.ManagerRoleGroup;
import com.tencent.bk.sdk.iam.dto.manager.ManagerRoleGroupInfo;
import com.tencent.bk.sdk.iam.dto.manager.dto.CreateManagerDTO;
import com.tencent.bk.sdk.iam.dto.manager.dto.ManagerMemberGroupDTO;
import com.tencent.bk.sdk.iam.dto.manager.dto.ManagerRoleGroupDTO;
import com.tencent.bk.sdk.iam.dto.manager.dto.ManagerRoleMemberDTO;
import com.tencent.bk.sdk.iam.dto.manager.vo.CreateVo;
import com.tencent.bk.sdk.iam.dto.manager.vo.ManagerGroupMemberVo;
import com.tencent.bk.sdk.iam.dto.manager.vo.ManagerRoleGroupVO;

import java.io.IOException;
import java.util.List;

public interface ManagerService {
    /**
     * 创建分级管理员
     *
     * @return
     */
    public Integer createManager(CreateManagerDTO createManagerDTO) throws IOException;

    /**
     * 分级管理员下用户组列表
     *
     * @param projectId
     * @return
     */
    public ManagerRoleGroupVO getGradeManagerRoleGroup(Integer projectId, PageInfoDTO pageInfoDTO);

    /**
     * 批量创建用户组
     *
     * @param managerRoleGroupDTO
     * @return
     */
    public Integer batchCreateRoleGroup(Integer projectId, ManagerRoleGroupDTO managerRoleGroupDTO);

    /**
     * 修改用户组
     *
     * @param roleId
     * @param managerRoleGroup
     * @return
     */
    public void updateRoleGroup(Integer roleId, ManagerRoleGroup managerRoleGroup);

    /**
     * 删除用户组
     *
     * @param roleId
     */
    public void deleteRoleGroup(Integer roleId);

    /**
     * 获取项目下分级管理员成员列表
     *
     * @param projectId
     * @param pageInfoDTO
     * @return
     */
    public List<String> getGradeManagerRoleMember(Integer projectId, PageInfoDTO pageInfoDTO);

    /**
     * 批量添加分级管理员成员
     *
     * @param members
     * @param projectId
     * @return
     */
    public void batchCreateGradeManagerRoleMember(ManagerRoleMemberDTO members, Integer projectId);

    /**
     * 批量删除分级管理员成员
     *
     * @param members   多个用“，”分割
     * @param projectId
     * @return
     */
    public void deleteGradeManagerRoleMember(String members, Integer projectId);

    /**
     * 用户组成员列表
     *
     * @param roleId
     * @param pageInfoDTO
     * @return
     */
    public ManagerGroupMemberVo getRoleGroupMember(Integer roleId, PageInfoDTO pageInfoDTO);

    /**
     * 用户组添加成员
     *
     * @param roleId
     * @param managerMemberGroupDTO
     * @return
     */
    public void createRoleGroupMember(Integer roleId, ManagerMemberGroupDTO managerMemberGroupDTO);

    /**
     * 用户组删除成员
     *
     * @param roleId
     * @param type
     * @param members
     */
    public void deleteRoleGroupMember(Integer roleId, String type, String members);

    /**
     * 用户加入的分级管理员列表
     *
     * @param userId
     * @param pageInfoDTO
     * @return
     */
    public List<CreateVo> getUserRole(String userId, PageInfoDTO pageInfoDTO);

    /**
     * 用户组授权
     */
    public Boolean createRolePermission(Integer roleId, AuthorizationScopes permission);

    /**
     * 用户在某个分级管理员下加入的用户组列表
     *
     * @param projectId
     * @param userId
     * @return
     */
    public List<ManagerRoleGroupInfo> getUserGroup(Integer projectId, String userId);

    /**
     * 新建关联
     *
     * @param createRelationDTO
     */
    public void createResourceRelation(CreateRelationDTO createRelationDTO);

    /**
     * 无权限跳转
     */
    public String getPermissionUrl(PermissionUrlDTO permissionUrlDTO);
}
