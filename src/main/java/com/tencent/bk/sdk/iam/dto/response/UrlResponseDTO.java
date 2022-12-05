package com.tencent.bk.sdk.iam.dto.response;

import lombok.Data;

@Data
public class UrlResponseDTO {
    private String url;

    public UrlResponseDTO(String url) {
        this.url = url;
    }
}
