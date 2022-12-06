package com.tencent.bk.sdk.iam.dto.itsm;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
@Builder
public class ItsmValue {
    private String lable;
    private String scheme;
    private List<HashMap<String, ItsmStyle>> value;
}
