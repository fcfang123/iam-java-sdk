package com.tencent.bk.sdk.iam.dto.callback.response;

import java.util.List;

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
public class FetchInstanceInfoResponseDTO extends CallbackBaseResponseDTO {
    private List<Object> data;
}
