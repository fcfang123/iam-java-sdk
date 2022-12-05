package com.tencent.bk.sdk.iam.dto.resource;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.InstanceDTO;

import lombok.Data;

/**
 * @author citruswang
 * @since 19/6/2020 21:28
 */
@Data
public class DependencyResourceInfoDTO {
    private String system;
    private String type;
    @JsonProperty("instances")
    private List<InstanceDTO> instanceList;
}
