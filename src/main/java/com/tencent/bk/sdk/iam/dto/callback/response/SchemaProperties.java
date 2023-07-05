package com.tencent.bk.sdk.iam.dto.callback.response;

import com.tencent.bk.sdk.iam.constants.DataTypeEnum;
import lombok.Data;

@Data
public class SchemaProperties {
    /**
     * 数据类型
     **/
    private DataTypeEnum type;
    /**
     * 描述
     **/
    private String description;
}
