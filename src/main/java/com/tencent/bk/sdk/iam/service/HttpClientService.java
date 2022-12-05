package com.tencent.bk.sdk.iam.service;

/**
 * @author citruswang
 * @since 18/3/2020 17:39
 */
public interface HttpClientService {

    /**
     * 发起 HTTP GET 请求
     *
     * @param uri 请求路径
     * @return 响应包体
     */
    String doHttpGet(String uri);

    /**
     * 发起 HTTP POST 请求
     *
     * @param uri  请求路径
     * @param body 请求体
     * @return 响应包体
     */
    String doHttpPost(String uri, Object body);

    /**
     * 发起 HTTP PUT 请求
     *
     * @param uri  请求路径
     * @param body 请求体
     * @return 响应包体
     */
    String doHttpPut(String uri, Object body);

    /**
     * 发起 HTTP PUT 请求
     *
     * @param uri  请求路径
     * @return 响应包体
     */
    String doHttpPut(String uri);

    /**
     * 发起 HTTP DELETE 请求
     *
     * @param uri 请求路径
     * @return 响应包体
     */
    String doHttpDelete(String uri);

    /**
     * 发起 HTTP DELETE 请求
     *
     * @param uri  请求路径
     * @param body 请求体
     * @return 响应包体
     */
    String doHttpDelete(String uri, Object body);
}
