package com.tencent.bk.sdk.iam.dto.manager.vo;

import com.tencent.bk.sdk.iam.dto.manager.ManagerRoleGroupInfo;
import lombok.Data;

import java.util.List;

@Data
public class ManagerRoleGroupVO {
    int count;
    List<ManagerRoleGroupInfo> results;
}
