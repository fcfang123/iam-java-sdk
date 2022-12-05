package com.tencent.bk.sdk.iam.dto.callback.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author citruswang
 * @since 20/3/2020 18:11
 */
@Data
public class BaseDataResponseDTO<T> {
    private Long count;

    @JsonProperty("results")
    private List<T> result;
}
