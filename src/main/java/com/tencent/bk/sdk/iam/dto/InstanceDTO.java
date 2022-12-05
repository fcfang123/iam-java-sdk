package com.tencent.bk.sdk.iam.dto;

import java.util.Map;

import lombok.Data;

/**
 * @author citruswang
 * @since 2/6/2020 12:23
 */
@Data
public class InstanceDTO {

    /**
     * 资源 ID，必填
     */
    private String id;

    /**
     * 资源所属系统，必填
     */
    private String system;

    /**
     * 资源类型，必填
     */
    private String type;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源路径，不包含本身，选填
     */
    private PathInfoDTO path;

    /**
     * 资源属性，选填
     */
    private Map<String, Object> attribute;
}
