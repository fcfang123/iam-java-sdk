package com.tencent.bk.sdk.iam.dto.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GroupMemberVerifyInfo {
    /*
     *是否属于用户组
     * */
    private Boolean belong;
    /*
     *过期时间戳
     * */
    @JsonProperty("expired_at")
    private Long expiredAt;
}
