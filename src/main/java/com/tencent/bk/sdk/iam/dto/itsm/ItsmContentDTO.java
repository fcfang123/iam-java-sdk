package com.tencent.bk.sdk.iam.dto.itsm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class ItsmContentDTO {
    private Map<String,ItsmScheme> schemes;
    @JsonProperty("form_data")
    private List<ItsmValue> formData;
}
