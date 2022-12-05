package com.tencent.bk.sdk.iam.dto.request;

import java.util.List;

import com.tencent.bk.sdk.iam.dto.resource.ResourceDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author citruswang
 * @since 3/8/2020 11:31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceCreateRequestDTO {
    /**
     * 系统 ID
     */
    private String system;

    /**
     * 资源类型的唯一标识
     */
    private String type;

    /**
     * 资源实例的唯一标识
     */
    private String id;

    /**
     * 资源实例的名称
     */
    private String name;

    /**
     * 资源实例的创建者
     */
    private String creator;

    /**
     * 资源的祖先，非必填，对于资源实例可能存在不同拓扑层级且某些操作需要按照拓扑层级鉴权时，该字段则需要填写
     * <p>
     * 只需要填写 system, type 与 id
     */
    private List<ResourceDTO> ancestors;
}
