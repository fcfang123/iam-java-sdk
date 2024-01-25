package com.tencent.bk.sdk.iam.dto.manager;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubjectTemplateInfo {
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
     * 是否是只读人员模版
     */
    private Boolean readonly;
    /**
     * 来源用户组ID
     */
    @JsonProperty("source_group_id")
    private Integer sourceGroupId;
}
