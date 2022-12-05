package com.tencent.bk.sdk.iam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.manager.AuthorizationScopes;
import com.tencent.bk.sdk.iam.dto.manager.ManagerScopes;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class GradeManagerApplicationCreateDTO {
    /*
     * 分级管理员名称, 权限中心里全局唯一
     * */
    private String name;
    /*
     * 分级管理员描述，可为空字符串
     * */
    private String description;
    /*
     * 分级管理员成员列表
     * */
    private List<String> members;
    /*
     * 分级管理员可授权范围
     * */
    @JsonProperty("authorization_scopes")
    private List<AuthorizationScopes> authorizationScopes;
    /*
     * 分级管理员可授权的人员范围
     * */
    @JsonProperty("subject_scopes")
    private List<ManagerScopes> subjectScopes;
    /*
     * 是否创建同步权限用户组, 默认false
     * */
    @JsonProperty("sync_perm")
    private Boolean syncPerm;
    /*
     * 申请人
     * */
    private String applicant;
    /*
     * 申请理由
     * */
    private String reason;
    /*
     * 申请回调id, 用于标识申请单, 默认为空
     * */
    @JsonProperty("callback_id")
    private String callbackId;
    /*
     * 申请回调url, 用于申请单审批回调,默认为空
     * */
    @JsonProperty("callback_url")
    private String callbackUrl;
    /*
     * 透传到ITSM审批单的标题, 默认为空
     * */
    private String title;
    /*
     * 透传到ITSM审批单的内容, 默认为空
     * */
    private Map<String, String> content;
}
