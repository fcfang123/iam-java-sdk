package com.tencent.bk.sdk.iam.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CallbackApplicationResponese {
    /*
    * 权限中心申请单id
    * */
    private Integer id;
    /*
    * 申请单创建的分级管理员id
    * */
    @JsonProperty("role_id")
    private Integer roleId;
}
