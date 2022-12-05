package com.tencent.bk.sdk.iam.util;

import com.tencent.bk.sdk.iam.dto.response.ResponseDTO;
import com.tencent.bk.sdk.iam.exception.IamException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author citruswang
 * @since 15/6/2020 20:40
 */
@Slf4j
public class ResponseUtil {
    public static <T> void checkResponse(ResponseDTO<T> responseInfo) {
        log.debug("Receive response|{}|{}|{}", responseInfo.getCode(), responseInfo.getMessage(), responseInfo.getData());
        if (responseInfo.getCode() != 0) {
            log.warn("Receive response|{}|{}|{}", responseInfo.getCode(), responseInfo.getMessage(), responseInfo.getData());
            throw new IamException(responseInfo.getCode(), responseInfo.getMessage());
        }
    }
}
