package com.tencent.bk.sdk.iam.dto.callback.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author citruswang
 * @since 20/3/2020 18:06
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ListAttributeValueResponseDTO extends CallbackBaseResponseDTO {
    private BaseDataResponseDTO<AttributeValueDTO> data;
}
