package com.tencent.bk.sdk.iam.dto.response;

import com.tencent.bk.sdk.iam.dto.manager.AuthorizationScopes;
import com.tencent.bk.sdk.iam.dto.manager.ManagerScopes;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class GradeManagerApplicationResponse {
    /*
     * 权限中心申请单id
     * */
    private Integer id;
    /*
     * itsm返回的申请单sn
     * */
    private String sn;
}
