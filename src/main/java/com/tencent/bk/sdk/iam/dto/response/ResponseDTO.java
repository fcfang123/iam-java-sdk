package com.tencent.bk.sdk.iam.dto.response;

import lombok.Data;

/**
 * @author citruswang
 * @since 17/3/2020 18:51
 */
@Data
public class ResponseDTO<T> {

    private Long code;

    private String message;

    private Boolean result;

    private T data;
}
