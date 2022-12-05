package com.tencent.bk.sdk.iam.dto;

import lombok.Data;

import java.util.List;

@Data
public class Attributes {
    private String id;
    private String name;
    private List<AttributesValue> values;
}
