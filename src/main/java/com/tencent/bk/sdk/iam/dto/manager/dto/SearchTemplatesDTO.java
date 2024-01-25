package com.tencent.bk.sdk.iam.dto.manager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchTemplatesDTO {
    /**
     * 人员模板名称
     */
    String name;
    /**
     * 人员模版id筛选
     */
    String id;
    /**
     * 描述
     */
    String description;
}
