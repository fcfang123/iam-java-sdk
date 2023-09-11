package com.tencent.bk.sdk.iam.dto.itsm;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class ItsmValue {
    private String label;
    private String scheme;
    private List<Map<String, ItsmStyle>> value;
}
