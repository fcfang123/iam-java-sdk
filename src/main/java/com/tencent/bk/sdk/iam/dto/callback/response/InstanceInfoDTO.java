package com.tencent.bk.sdk.iam.dto.callback.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.PathInfoDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author citruswang
 * @since 20/3/2020 18:13
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class InstanceInfoDTO extends BaseInfoDTO {

    private List<PathInfoDTO> path;

    @JsonProperty("_bk_iam_approver_")
    private List<String> iamApprover;
}
