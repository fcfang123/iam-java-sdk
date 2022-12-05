package com.tencent.bk.sdk.iam.service;

import com.tencent.bk.sdk.iam.dto.system.SystemDTO;
import com.tencent.bk.sdk.iam.dto.system.SystemFieldDTO;

public interface SystemService {

    Boolean systemCheck(String systemId);

    SystemFieldDTO getSystemFieldsInfo(String systemId);

    Boolean createSystem(SystemDTO systemInfo);
}
