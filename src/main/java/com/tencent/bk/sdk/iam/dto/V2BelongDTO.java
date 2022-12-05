package com.tencent.bk.sdk.iam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class V2BelongDTO {
    private String userId;
    /*用户组ID列表,多个以英文逗号分隔*/
    private String groupIds;
    /*对于用户，是否会包括其继承来着部门的，默认为false，即默认只查询直接关联的，不会包括继承的*/
    private Boolean inherit;
}
