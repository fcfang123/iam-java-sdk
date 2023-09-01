package com.tencent.bk.sdk.iam.dto.itsm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItsmColumn {
    /**
     * 列标识
     * */
    private String key;
    /**
    * 列名称
    * */
    private String name;
    /**
     * 列类型：text、url
     * */
    private String type;
    /**
     * 是否为抽屉模式
     * */
    @JsonProperty("is_iframe")
    private Boolean iframe;
    private Integer width;
}
