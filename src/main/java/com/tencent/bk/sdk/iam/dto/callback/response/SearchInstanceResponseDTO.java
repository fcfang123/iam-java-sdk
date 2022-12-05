package com.tencent.bk.sdk.iam.dto.callback.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SearchInstanceResponseDTO extends CallbackBaseResponseDTO {
	private BaseDataResponseDTO<InstanceInfoDTO> data;
}
