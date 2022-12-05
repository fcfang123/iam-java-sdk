package com.tencent.bk.sdk.iam.dto.callback.request;

import com.tencent.bk.sdk.iam.constants.CallbackMethodEnum;
import com.tencent.bk.sdk.iam.dto.PageInfoDTO;

import lombok.Data;

/**
 * @author citruswang
 * @since 20/3/2020 17:55
 */
@Data
public class CallbackRequestDTO {

    /**
     * 查询的资源类型
     */
    private String type;

    /**
     * 需要查询资源信息的方式，不同方式对应查询资源的不同信息
     * <p>
     * 目前值有：list_attr、list_attr_value、 list_instance、fetch_instance_info、list_instance_by_policy
     */
    private CallbackMethodEnum method;

    /**
     * 根据不同查询方式(method)，传入不同的过滤参数
     */
    private FilterDTO filter;

    /**
     * 当返回数据需要支持分页时，需要参数
     */
    private PageInfoDTO page;

}
