package com.tencent.bk.sdk.iam.dto.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class V2ManagerRoleGroupInfo {
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 是否是只读用户组
     */
    private Boolean readonly;
    /**
     * 用户组成员user数量
     */
    @JsonProperty("user_count")
    private Integer userCount;
    /**
     * 用户组成员department数量
     */
    @JsonProperty("department_count")
    private Integer departmentCount;
}
