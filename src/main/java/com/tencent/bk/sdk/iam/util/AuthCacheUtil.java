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

package com.tencent.bk.sdk.iam.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class AuthCacheUtil {

    /**
     * 直接鉴权本地缓存
     */
    private static final Cache<String, Boolean> permissionCache = CacheBuilder.newBuilder()
            .maximumSize(50000)
            .expireAfterWrite(1, TimeUnit.MINUTES)
            .build();

    public static Boolean cachePermission(String cacheKey, Supplier<Boolean> request) {
        Boolean cacheResult = permissionCache.getIfPresent(cacheKey);
        if (cacheResult != null) {
            return cacheResult;
        }
        Boolean requestResult = request.get();
        if (requestResult) {
            permissionCache.put(cacheKey, true);
        }
        return requestResult;
    }
}
