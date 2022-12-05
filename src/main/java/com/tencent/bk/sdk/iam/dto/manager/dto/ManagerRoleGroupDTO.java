package com.tencent.bk.sdk.iam.dto.manager.dto;

import com.tencent.bk.sdk.iam.dto.manager.ManagerRoleGroup;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ManagerRoleGroupDTO {
    List<ManagerRoleGroup> groups;
}
