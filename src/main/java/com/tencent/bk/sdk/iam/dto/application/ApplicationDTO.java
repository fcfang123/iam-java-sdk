package com.tencent.bk.sdk.iam.dto.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ApplicationDTO {
    @JsonProperty("group_ids")
    private List<Integer> groupId;
    @JsonProperty("expired_at")
    private Long expiredAt;
    /*申请人，即username*/
    private String applicant;
    private String reason;
}
