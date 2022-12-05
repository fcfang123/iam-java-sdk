package com.tencent.bk.sdk.iam.dto.response;

import com.tencent.bk.sdk.iam.dto.manager.GroupMemberVerifyInfo;
import lombok.Data;

import java.util.HashMap;

@Data
public class GroupMemberVerifyResponse {
    HashMap<Integer, GroupMemberVerifyInfo> verifyResult;
}
