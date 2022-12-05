package com.tencent.bk.sdk.iam.exception;

import lombok.Getter;

/**
 * @author citruswang
 * @since 29/5/2020 10:42
 */
@Getter
public class IamException extends RuntimeException {
    private final long errorCode;
    private final String errorMsg;

    public IamException(long errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public IamException(long errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
