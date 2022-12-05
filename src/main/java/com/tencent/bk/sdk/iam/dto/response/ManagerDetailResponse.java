package com.tencent.bk.sdk.iam.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ManagerDetailResponse {
    private String id;
    private String name;
    private String description;
    private String creator;
    private List<String> members;
    @JsonProperty("sync_perm")
    private Boolean syncPerm;
}
