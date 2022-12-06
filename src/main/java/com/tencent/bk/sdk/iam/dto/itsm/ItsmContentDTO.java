package com.tencent.bk.sdk.iam.dto.itsm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Builder
@Data
public class ItsmContentDTO {
    private HashMap<String,ItsmScheme> schemes;
    @JsonProperty("form_data")
    private List<ItsmValue> formData;
}
