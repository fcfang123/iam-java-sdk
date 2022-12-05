package com.tencent.bk.sdk.iam.dto.callback.response;

import lombok.Data;

/**
 * @author citruswang
 * @since 20/3/2020 18:00
 */
@Data
public class CallbackBaseResponseDTO {
    private Long code;

    private String message;
}
