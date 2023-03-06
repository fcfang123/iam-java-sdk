package com.tencent.bk.sdk.iam.dto.manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GroupMemberRenewApplicationDTO {
    /*
     * 用户组id
     */
    @JsonProperty("group_ids")
    private List<Integer> groupIds;
    /*
     * 过期时间
     */
    @JsonProperty("expired_at")
    private Long expiredAt;
    /*
     * 理由
     * */
    private String reason;
    /*
     * 申请人，即 username
     * */
    private String applicant;

}
