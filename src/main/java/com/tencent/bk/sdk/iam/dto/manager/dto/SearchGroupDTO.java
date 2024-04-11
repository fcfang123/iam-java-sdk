package com.tencent.bk.sdk.iam.dto.manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchGroupDTO {
    /*该值若为true,会查询所有的用户组；若为false，只会查询分级管理员级别的用户组，不包含二级管理员的用户组，不填默认true*/
    private Boolean inherit;
    /*该值若为true，会查询所有的用户组，若为false，只会查询二级管理员的用户组的组*/
    @JsonProperty("only_inherit")
    private Boolean onlyInherit;
    /*操作id筛选, 只支持自定义操作*/
    @JsonProperty("action_id")
    private String actionId;
    /*RBAC资源系统筛选*/
    @JsonProperty("resource_type_system_id")
    private String resourceTypeSystemId;
    /*RBAC资源类型筛选*/
    @JsonProperty("resource_type_id")
    private String resourceTypeId;
    /*RBAC资源实例筛选*/
    @JsonProperty("resource_id")
    private String resourceId;
    /*RBAC资源实例筛选, 可选传资源实例的上级路径信息*/
    @JsonProperty("bk_iam_path")
    private String bkIamPath;
    /*用户组名称筛选*/
    private String name;
    /*用户组id筛选*/
    private Integer id;
    /*用户组描述筛选*/
    private String description;
}
