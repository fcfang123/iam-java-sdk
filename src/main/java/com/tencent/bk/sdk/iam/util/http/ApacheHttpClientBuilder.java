/*
 * TencentBlueKing is pleased to support the open source community by making
 * 蓝鲸智云-权限中心Java SDK(iam-java-sdk) available.
 * Copyright (C) 2017-2021 THL A29 Limited, a Tencent company. All rights reserved.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://opensource.org/licenses/MIT
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.tencent.bk.sdk.iam.util.http;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;

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
