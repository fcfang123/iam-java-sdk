package com.tencent.bk.sdk.iam.dto;

import com.tencent.bk.sdk.iam.dto.callback.response.BaseInfoDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author citruswang
 * @since 20/3/2020 18:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PathInfoDTO extends BaseInfoDTO {
    private String type;

    private PathInfoDTO child;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("/");
        sb.append(type).append(',').append(getId());
        if (child == null) {
            return sb.append("/").toString();
        } else {
            return sb.append(child.toString()).toString();
        }
    }
}
