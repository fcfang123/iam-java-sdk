package com.tencent.bk.sdk.iam.dto.resource;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author citruswang
 * @since 18/3/2020 16:50
 */
@Data
@Builder
public class ResourceDTO {

    private String system;

    private String type;

    private String id;

    /**
     * 仅在批量拉取跨系统依赖资源时有效
     */
    @JsonProperty("ids")
    private List<String> idList;
}
