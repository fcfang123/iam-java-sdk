package com.tencent.bk.sdk.iam.dto.manager.vo;

import com.tencent.bk.sdk.iam.dto.manager.RoleGroupMemberInfo;
import lombok.Data;

import java.util.List;

@Data
public class ManagerGroupMemberVo {
    Integer count;
    List<RoleGroupMemberInfo> results;
}
