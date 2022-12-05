package com.tencent.bk.sdk.iam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author citruswang
 * @since 18/3/2020 15:09
 */
@Data
public class V2PageInfoDTO {
    /**
     * 分页大小, 最大500
     */
    private Integer pageSize;

    private Integer page;
}
