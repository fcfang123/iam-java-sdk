package com.tencent.bk.sdk.iam.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author citruswang
 * @since 5/6/2020 20:34
 */
class PathInfoDTOTest {

    @Test
    void testToString() {
        PathInfoDTO pathInfo = new PathInfoDTO();
        pathInfo.setType("a");
        pathInfo.setId("1");
        pathInfo.setChild(new PathInfoDTO());
        pathInfo.getChild().setType("b");
        pathInfo.getChild().setId("2");
        assertEquals(pathInfo.toString(), "/a,1/b,2/");
    }
}