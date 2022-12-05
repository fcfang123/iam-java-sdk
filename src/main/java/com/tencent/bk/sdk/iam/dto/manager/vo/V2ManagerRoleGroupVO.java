package com.tencent.bk.sdk.iam.dto.manager.vo;

import com.tencent.bk.sdk.iam.dto.manager.V2ManagerRoleGroupInfo;
import lombok.Data;

import java.util.List;

@Data
public class V2ManagerRoleGroupVO {
    private Integer count;
    private List<V2ManagerRoleGroupInfo> results;
}
