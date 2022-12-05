package com.tencent.bk.sdk.iam.dto.callback.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 某个资源类型可用于配置权限的属性
 *
 * @author citruswang
 * @since 18/3/2020 15:24
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AttributeDTO extends BaseInfoDTO {

    private String name;

    @JsonProperty("values")
    private List<AttributeValueDTO> value;
}
