package com.tencent.bk.sdk.iam.dto.callback.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class InstanceListDTO<T> {

    /**
     * 资源实例的唯一标识
     **/
    private String id;

    /**
     * 资源实例的展示名称
     **/
    @JsonProperty("display_name")
    private String displayName;
    /**
     * 创建人
     **/
    private String creator;

    /**
     * 创建人
     **/
    @JsonProperty("created_at")
    private Long createdAt;
    /**
     * 创建人
     **/
    @JsonProperty("updated_at")
    private Long updatedAt;
    /**
     * 变更人
     **/
    private String updater;
    /**
     * 资源拓扑
     **/
    @JsonProperty("_bk_iam_path_")
    private List<String> bkIamPath;
    /**
     * 资源实例详情，键值对需要与实例schema定义保持一致；
     **/
    @JsonProperty("data")
    private T schemaProperties;
}
