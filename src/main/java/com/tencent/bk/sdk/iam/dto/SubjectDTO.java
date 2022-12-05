package com.tencent.bk.sdk.iam.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author citruswang
 * @since 18/3/2020 16:49
 */
@Data
@Builder
public class SubjectDTO {
    private String type;

    private String id;
}
