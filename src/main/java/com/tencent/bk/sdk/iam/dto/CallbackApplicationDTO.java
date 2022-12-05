package com.tencent.bk.sdk.iam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CallbackApplicationDTO {
    /*
     * 申请单itsm返回的sn
     * */
    private String sn;
    /*
     * itsm返回的回调状态
     * */
    @JsonProperty("current_status")
    private String currentStatus;
    /*
     * itsm返回的审批结果
     * */
    @JsonProperty("approve_result")
    private Boolean approveResult;
}
