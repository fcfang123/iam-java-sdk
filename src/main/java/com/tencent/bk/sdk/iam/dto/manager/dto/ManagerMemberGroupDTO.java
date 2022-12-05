package com.tencent.bk.sdk.iam.dto.manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.manager.ManagerMember;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ManagerMemberGroupDTO {

    /**
     * 成员
     */
    List<ManagerMember> members;
    /**
     * 过期时间
     */
    @JsonProperty("expired_at")
    Long expiredAt;
}
