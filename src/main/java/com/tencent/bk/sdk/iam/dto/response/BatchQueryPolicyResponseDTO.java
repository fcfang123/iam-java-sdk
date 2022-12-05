package com.tencent.bk.sdk.iam.dto.response;

import java.util.List;

import com.tencent.bk.sdk.iam.dto.action.ActionPolicyDTO;

import lombok.ToString;

/**
 * @author citruswang
 * @since 18/3/2020 17:38
 */
@ToString(callSuper = true)
public class BatchQueryPolicyResponseDTO extends ResponseDTO<List<ActionPolicyDTO>> {
}
