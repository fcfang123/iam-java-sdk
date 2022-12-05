package com.tencent.bk.sdk.iam.constants;

public enum ManagerScopesEnum {
    /**
     * 用户
     */
    USER("user"),
    /**
     * 组织
     */
    DEPARTMENT("department"),
    /**
     * 所有类型
     */
    ALL("*");

    private String type;

    ManagerScopesEnum(String type) {
        this.type = type;
    }

    public static String getType(ManagerScopesEnum scopesEnum) {
        return scopesEnum.type;
    }
}
