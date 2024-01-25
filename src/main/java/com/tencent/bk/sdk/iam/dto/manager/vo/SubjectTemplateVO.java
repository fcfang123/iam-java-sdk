package com.tencent.bk.sdk.iam.dto.manager.vo;

import com.tencent.bk.sdk.iam.dto.manager.SubjectTemplateInfo;
import lombok.Data;

import java.util.List;

@Data
public class SubjectTemplateVO {
    int count;
    List<SubjectTemplateInfo> results;
}
