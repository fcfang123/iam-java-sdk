package com.tencent.bk.sdk.iam.dto.callback.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author citruswang
 * @since 20/3/2020 18:07
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ListInstanceByPolicyResponseDTO extends CallbackBaseResponseDTO {
    private BaseDataResponseDTO<BaseInfoDTO> data;
}
