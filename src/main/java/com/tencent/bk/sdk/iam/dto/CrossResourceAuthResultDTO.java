package com.tencent.bk.sdk.iam.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * @author citruswang
 * @since 19/6/2020 21:05
 */
@Data
public class CrossResourceAuthResultDTO {

    /**
     * 是否有权限
     */
    private Boolean pass;

    /**
     *
     */
    private Boolean hasSelfPermission;

    /**
     * 有权限的 ID 列表，System -> Type -> Id
     */
    private Map<String, Map<String, List<String>>> allowIdMap;
}
