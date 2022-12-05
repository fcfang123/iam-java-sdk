package com.tencent.bk.sdk.iam.constants;

public enum GrantType {
	GRANT("grant"),
	REVOKE("remoke");

	private String type;

	GrantType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
