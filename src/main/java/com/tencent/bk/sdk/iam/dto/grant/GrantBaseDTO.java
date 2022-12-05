package com.tencent.bk.sdk.iam.dto.grant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.constants.GrantType;
import com.tencent.bk.sdk.iam.dto.SubjectDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GrantBaseDTO {
	/* 授权方式 默认为false同步 当前只支持同步 */
	private Boolean asynchronous;
	/* grant 授权 revoke 回收*/
	private String operate;
	private String system;
	/* 资源拓扑, 资源类型的顺序必须操作注册时的顺序一致 */
	private List<GrantResourceDTO> resources;
	private SubjectDTO subject;
	/* 有效期，时间戳，即到了对应时间戳时间后权限就过期 */
	@JsonProperty("expired_at")
	private Long expiredAt;

	public GrantBaseDTO(Boolean asynchronous, String operate, String system, List<GrantResourceDTO> resources, SubjectDTO subject, Long expiredAt) {
		this.asynchronous = asynchronous;
		this.operate = operate;
		this.resources = resources;
		this.subject = subject;
		this.expiredAt = expiredAt;
	}
}
