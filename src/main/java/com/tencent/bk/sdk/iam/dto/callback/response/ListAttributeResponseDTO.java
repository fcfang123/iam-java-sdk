package com.tencent.bk.sdk.iam.dto.callback.response;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author citruswang
 * @since 20/3/2020 18:04
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ListAttributeResponseDTO extends CallbackBaseResponseDTO {
    private List<AttributeDTO> data;
}
