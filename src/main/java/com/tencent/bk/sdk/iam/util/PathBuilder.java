package com.tencent.bk.sdk.iam.util;

import com.tencent.bk.sdk.iam.dto.PathInfoDTO;

/**
 * @author citruswang
 * @since 12/6/2020 16:00
 */
public class PathBuilder {

    private final String id;

    private final String type;

    private PathBuilder child;

    private PathBuilder head;

    private PathBuilder(String type, String id) {
        this.type = type;
        this.id = id;
        this.head = this;
    }

    private PathBuilder(String type, String id, PathBuilder head) {
        this.type = type;
        this.id = id;
        this.head = head;
    }

    public static PathBuilder newBuilder(String type, String id) {
        return new PathBuilder(type, id);
    }

    public PathBuilder head(PathBuilder head) {
        this.head = head;
        return this;
    }

    public PathBuilder child(String type, String id) {
        this.child = new PathBuilder(type, id, this.head);
        return child;
    }

    public PathInfoDTO build() {
        if (this.head == this) {
            PathInfoDTO pathInfo = new PathInfoDTO();
            pathInfo.setType(type);
            pathInfo.setId(id);
            if (this.child != null) {
                pathInfo.setChild(this.child.head(this.child).build());
            }
            return pathInfo;
        } else {
            return this.head.build();
        }
    }
}
