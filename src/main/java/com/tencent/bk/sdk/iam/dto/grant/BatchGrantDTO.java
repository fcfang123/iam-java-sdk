package com.tencent.bk.sdk.iam.dto.grant;

import com.tencent.bk.sdk.iam.constants.GrantType;
import com.tencent.bk.sdk.iam.dto.SubjectDTO;
import com.tencent.bk.sdk.iam.service.impl.GrantActionDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class BatchGrantDTO extends GrantBaseDTO{
    private List<GrantActionDTO> actions;

    @Builder
    public BatchGrantDTO(
        Boolean asynchronous,
        GrantType operate,
        String system,
        SubjectDTO subject,
        List<GrantResourceDTO> resources,
        Long expiredAt,
        List<GrantActionDTO> actions
    ) {
        super(asynchronous, operate.getType(), system, resources, subject, expiredAt);
        this.actions = actions;
    }
}
