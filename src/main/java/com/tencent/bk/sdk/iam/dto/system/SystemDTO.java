package com.tencent.bk.sdk.iam.dto.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.BaseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author citruswang
 * @since 12/3/2020 21:15
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SystemDTO extends BaseDTO {

    /**
     * 有权限调用的客户端，即有权限调用的app_code列表，多个使用英文逗号分隔，注册系统时会校验 Header 头里的 app_code 必须在列表里
     */
    @JsonProperty("clients")
    private String client;

}
