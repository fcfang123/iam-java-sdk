package com.tencent.bk.sdk.iam.dto.callback.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FetchInstanceListDTO<T> extends CallbackBaseResponseDTO {
    private BaseDataResponseDTO<InstanceListDTO<T>> data;
}
