package com.tencent.bk.sdk.iam.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author citruswang
 * @since 12/6/2020 16:52
 */
class PathBuilderTest {

    @Test
    void testPathBuilder() {
        PathBuilder pathBuilder = PathBuilder.newBuilder("biz", "1");
        pathBuilder.child("set", "2").child("model", "3");
        assertEquals("/biz,1/set,2/model,3/", pathBuilder.build().toString());
    }
}