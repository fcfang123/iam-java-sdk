package com.tencent.bk.sdk.iam.dto.grant;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class GrantPolicyDTO {
	@JsonProperty("policy_id")
	private Long policyId;

	private Map<String, Object> statistics;
}
