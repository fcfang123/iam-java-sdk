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

import org.apache.http.NoHttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class IamHttpRequestRetryHandler extends DefaultHttpRequestRetryHandler {

    public static final IamHttpRequestRetryHandler INSTANCE = new IamHttpRequestRetryHandler();
    private final int retryCount;
    /**
     * 可以重试的异常
     */
    private final Set<Class<? extends IOException>> retriableClasses;

    public IamHttpRequestRetryHandler(
            final int retryCount,
            final boolean requestSentRetryEnabled,
            final Collection<Class<? extends IOException>> retriableClasses) {
        super(retryCount, requestSentRetryEnabled);
        this.retryCount = retryCount;
        this.retriableClasses = new HashSet<>();
        this.retriableClasses.addAll(retriableClasses);
    }

    public IamHttpRequestRetryHandler(final int retryCount, final boolean requestSentRetryEnabled) {
        this(retryCount, requestSentRetryEnabled, Arrays.asList(
                UnknownHostException.class,
                SocketTimeoutException.class,
                ConnectTimeoutException.class,
                NoHttpResponseException.class
        ));
    }

    public IamHttpRequestRetryHandler() {
        this(3, false);
    }

    @Override
    public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
        if (executionCount > this.retryCount) {
            // Do not retry if over max retry count
            return false;
        }
        if (this.retriableClasses.contains(exception.getClass())) {
            return true;
        }
        for (final Class<? extends IOException> acceptException : this.retriableClasses) {
            if (acceptException.isInstance(exception)) {
                return true;
            }
        }
        return super.retryRequest(exception, executionCount, context);
    }
}
