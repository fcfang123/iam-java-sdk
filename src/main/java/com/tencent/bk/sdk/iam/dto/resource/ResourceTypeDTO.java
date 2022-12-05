package com.tencent.bk.sdk.iam.dto.resource;

import com.tencent.bk.sdk.iam.dto.BaseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author citruswang
 * @since 12/3/2020 21:57
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ResourceTypeDTO extends BaseDTO {

    /**
     * 资源类型的直接上级，可多个直接上级，可以是自身系统的资源类型或其他系统的资源类型, 可为空列表，不允许重复，数据仅用于权限中心产品上显示 产品说明: 上级资源
     */
    private List<ParentResourceDTO> parents;
}
