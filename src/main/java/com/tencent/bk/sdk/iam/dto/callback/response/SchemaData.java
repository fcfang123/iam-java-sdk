package com.tencent.bk.sdk.iam.dto.callback.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SchemaData<T> {
    /**
     * 固定值, 资源类型 schema 最外层必须为object类型
     **/
    private String type;
    /**
     * 资源类型 schema 定义
     **/
    @JsonProperty("properties")
    private T schemaProperties;
}
