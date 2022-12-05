package com.tencent.bk.sdk.iam.util.http;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * @author citruswang
 * @since 18/3/2020 19:06
 */
public interface ApacheHttpClientBuilder {

    /**
     * 构建httpclient实例
     *
     * @return new instance of CloseableHttpClient
     */
    CloseableHttpClient build();

    /**
     * 设置代理服务器地址
     *
     * @param httpProxyHost 代理服务器地址
     * @return Builder
     */
    ApacheHttpClientBuilder httpProxyHost(String httpProxyHost);

    /**
     * 代理服务器端口
     *
     * @param httpProxyPort 代理服务器端口
     * @return Builder
     */
    ApacheHttpClientBuilder httpProxyPort(int httpProxyPort);

    /**
     * 代理服务器用户名
     *
     * @param httpProxyUsername 代理认证用户名
     * @return Builder
     */
    ApacheHttpClientBuilder httpProxyUsername(String httpProxyUsername);

    /**
     * 代理服务器密码
     *
     * @param httpProxyPassword 代理认证密码
     * @return Builder
     */
    ApacheHttpClientBuilder httpProxyPassword(String httpProxyPassword);

    /**
     * SSL 连接 Socket 工厂
     *
     * @param sslConnectionSocketFactory 自定义 SSL 连接工厂
     * @return Builder
     */
    ApacheHttpClientBuilder sslConnectionSocketFactory(SSLConnectionSocketFactory sslConnectionSocketFactory);
}
