package com.tencent.bk.sdk.iam.dto.manager.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ManagerRoleMemberDTO {
    List<String> members;
}
