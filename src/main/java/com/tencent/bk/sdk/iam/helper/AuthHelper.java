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

package com.tencent.bk.sdk.iam.helper;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.tencent.bk.sdk.iam.config.IamConfiguration;
import com.tencent.bk.sdk.iam.dto.ExpressionWithResourceDTO;
import com.tencent.bk.sdk.iam.dto.InstanceDTO;
import com.tencent.bk.sdk.iam.dto.action.ActionDTO;
import com.tencent.bk.sdk.iam.dto.expression.ExpressionDTO;
import com.tencent.bk.sdk.iam.dto.resource.ResourceDTO;
import com.tencent.bk.sdk.iam.exception.IamException;
import com.tencent.bk.sdk.iam.service.PolicyService;
import com.tencent.bk.sdk.iam.service.TokenService;

import org.apache.commons.codec.Charsets;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthHelper {

    private static final String BASIC_AUTH = "Basic";
    private static final String DIGEST_AUTH = "Digest";
    private static final String IAM_USER = "bk_iam";
    private static final String PATH_ATTRIBUTE = "_bk_iam_path_";
    private static final Integer BATCH_SIZE = 500;

    private final TokenService tokenService;
    private final PolicyService policyService;
    private final IamConfiguration iamConfiguration;

    public AuthHelper(TokenService tokenService, PolicyService policyService, IamConfiguration iamConfiguration) {
        this.tokenService = tokenService;
        this.policyService = policyService;
        this.iamConfiguration = iamConfiguration;
    }

    private static List<ResourceDTO> buildResourceList(List<InstanceDTO> instanceList) {
        if (CollectionUtils.isEmpty(instanceList)) {
            return null;
        }
        return instanceList.parallelStream().map(AuthHelper::buildResource).collect(Collectors.toList());
    }

    private static ResourceDTO buildResource(InstanceDTO instance) {
        if (instance != null) {
            return ResourceDTO.builder().id(instance.getId())
                    .system(instance.getSystem()).type(instance.getType()).build();
        } else {
            return null;
        }
    }

    protected static boolean calculateExpression(Map<String, InstanceDTO> instanceMap, ExpressionDTO expression) {
        if (expression.isEmpty()) {
            return false;
        }
        String type = null;
        String attribute = null;
        List<String> attributeValueList = Collections.emptyList();
        if (StringUtils.isNotBlank(expression.getField())) {
            try {
                String[] field = expression.getField().split("\\.");
                type = field[0];
                attribute = field[1];
            } catch (Exception e) {
                throw new IamException(-1, "Unsupported field " + expression.getField());
            }
            attributeValueList = getAttribute(attribute, instanceMap.get(type));
        }
        switch (expression.getOperator()) {
            case OR:
                for (ExpressionDTO subExpression : expression.getContent()) {
                    if (calculateExpression(instanceMap, subExpression)) {
                        return true;
                    }
                }
                return false;
            case AND:
                for (ExpressionDTO subExpression : expression.getContent()) {
                    if (!calculateExpression(instanceMap, subExpression)) {
                        return false;
                    }
                }
                return true;
            case EQUAL:
                checkParam(type, attribute, expression);
                convertValue(expression);
                for (String attributeValue : attributeValueList) {
                    if (expression.getValue().equals(attributeValue)) {
                        return true;
                    }
                }
                return false;
            case NOT_EQUAL:
                checkParam(type, attribute, expression);
                convertValue(expression);
                for (String attributeValue : attributeValueList) {
                    if (expression.getValue().equals(attributeValue)) {
                        return false;
                    }
                }
                return true;
            case IN:
                checkParam(type, attribute, expression);
                convertValue(expression);
                if (expression.getValue() instanceof List) {
                    for (String attributeValue : attributeValueList) {
                        if (((List<?>) expression.getValue()).contains(attributeValue)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            case NOT_IN:
                checkParam(type, attribute, expression);
                convertValue(expression);
                if (expression.getValue() instanceof List) {
                    for (String attributeValue : attributeValueList) {
                        if (((List<?>) expression.getValue()).contains(attributeValue)) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            case CONTAIN:
                checkParam(type, attribute, expression);
                return attributeValueList.contains((String) expression.getValue());
            case NOT_CONTAIN:
                checkParam(type, attribute, expression);
                return !attributeValueList.contains((String) expression.getValue());
            case START_WITH:
                checkParam(type, attribute, expression);
                String expressionValue = (String) expression.getValue();
                if (PATH_ATTRIBUTE.equals(attribute)) {
                    if (expressionValue.endsWith(",*/")) {
                        expressionValue = expressionValue.substring(0, expressionValue.length() - 3);
                    }
                }
                for (String attributeValue : attributeValueList) {
                    if (attributeValue.startsWith(expressionValue)) {
                        return true;
                    }
                }
                return false;
            case NOT_START_WITH:
                checkParam(type, attribute, expression);
                for (String attributeValue : attributeValueList) {
                    if (attributeValue.startsWith((String) expression.getValue())) {
                        return false;
                    }
                }
                return true;
            case END_WITH:
                checkParam(type, attribute, expression);
                for (String attributeValue : attributeValueList) {
                    if (attributeValue.endsWith((String) expression.getValue())) {
                        return true;
                    }
                }
                return false;
            case NOT_END_WITH:
                checkParam(type, attribute, expression);
                for (String attributeValue : attributeValueList) {
                    if (attributeValue.endsWith((String) expression.getValue())) {
                        return false;
                    }
                }
                return true;
            case LESS_THEN:
                checkParam(type, attribute, expression);
                for (String attributeValue : attributeValueList) {
                    if (NumberUtils.createBigDecimal(attributeValue).compareTo(NumberUtils.createBigDecimal((String) expression.getValue())) < 0) {
                        return true;
                    }
                }
                return false;
            case LESS_THAN_OR_EQUAL:
                checkParam(type, attribute, expression);
                for (String attributeValue : attributeValueList) {
                    if (NumberUtils.createBigDecimal(attributeValue).compareTo(NumberUtils.createBigDecimal((String) expression.getValue())) <= 0) {
                        return true;
                    }
                }
                return false;
            case GREATER_THAN:
                checkParam(type, attribute, expression);
                for (String attributeValue : attributeValueList) {
                    if (NumberUtils.createBigDecimal(attributeValue).compareTo(NumberUtils.createBigDecimal((String) expression.getValue())) > 0) {
                        return true;
                    }
                }
                return false;
            case GREATER_THAN_OR_EQUAL:
                checkParam(type, attribute, expression);
                for (String attributeValue : attributeValueList) {
                    if (NumberUtils.createBigDecimal(attributeValue).compareTo(NumberUtils.createBigDecimal((String) expression.getValue())) >= 0) {
                        return true;
                    }
                }
                return false;
            case ANY:
                if (type == null) {
                    return true;
                } else {
                    return instanceMap.get(type) != null;
                }
            case STRING_CONTAINS:
                checkParam(type, attribute, expression);
                for (String attributeValue : attributeValueList) {
                    if (attributeValue.contains((String) expression.getValue())) {
                        return true;
                    }
                }
                return false;
            default:
                throw new IamException(-1, "Unrecognized expression operator " + expression.getOperator());
        }
    }

    private static void convertValue(ExpressionDTO expression) {
        if (expression.getValue() instanceof List) {
            if (!(((List<?>) expression.getValue()).get(0) instanceof String)) {
                expression.setValue(((List<?>) expression.getValue()).parallelStream().map(Object::toString).collect(Collectors.toList()));
            }
        } else if (!(expression.getValue() instanceof String)) {
            expression.setValue(expression.getValue().toString());
        }
    }

    private static void checkParam(String type, String attribute, ExpressionDTO expression) {
        if (type == null || attribute == null || expression.getValue() == null) {
            throw new IamException(-1, "Equal must have field and value!");
        }
    }

    private static List<String> getAttribute(String attribute, InstanceDTO instance) {
        if (instance == null) {
            return Collections.emptyList();
        }
        if (StringUtils.isNotBlank(attribute)) {
            switch (attribute) {
                case "id":
                    return Collections.singletonList(instance.getId());
                case PATH_ATTRIBUTE:
                    if (instance.getPath() != null) {
                        StringBuilder sb = new StringBuilder(instance.getPath().toString());
                        return Collections.singletonList(sb.append(instance.getType()).append(",").append(instance.getId()).append(
                                "/").toString());
                    } else {
                        if (instance.getAttribute() != null && instance.getAttribute().get(PATH_ATTRIBUTE) != null) {
                            if (instance.getAttribute().get(PATH_ATTRIBUTE) instanceof List) {
                                List<String> pathList = new ArrayList<>();
                                if (((List<?>) instance.getAttribute().get(PATH_ATTRIBUTE)).get(0) instanceof String) {
                                    for (String path : (List<String>) instance.getAttribute().get(PATH_ATTRIBUTE)) {
                                        StringBuilder sb = new StringBuilder(path);
                                        pathList.add(sb.append(instance.getType()).append(",").append(instance.getId()).append(
                                                "/").toString());
                                    }
                                }
                                return pathList;
                            }
                        }
                        return Collections.emptyList();
                    }
                default:
                    if (instance.getAttribute() != null) {
                        if (instance.getAttribute().get(attribute) != null) {
                            return Collections.singletonList(instance.getAttribute().get(attribute).toString());
                        }
                    }
                    return Collections.emptyList();
            }
        } else {
            return Collections.emptyList();
        }
    }

    public boolean isAllowed(String username, String action) {
        ActionDTO actionDTO = new ActionDTO();
        actionDTO.setId(action);
        ExpressionDTO expression = policyService.getPolicyByAction(username, actionDTO, null);
        return expression != null && !new ExpressionDTO().equals(expression);
    }

    public boolean isAllowed(String username, String action, InstanceDTO instance) {
        List<String> allowed = isAllowed(username, action, Collections.singletonList(instance), false);
        log.info("isAllowed {}|{}|{}|{}|{}", username, action, instance.getId(), allowed, allowed.contains(instance.getId()));
        return allowed.contains(instance.getId());
    }

    public boolean isAllowedV2(String username, String action) {
        ActionDTO actionDTO = new ActionDTO();
        actionDTO.setId(action);
        ExpressionDTO expression = policyService.getPolicyByActionV2(username, actionDTO, null, true);
        return expression != null && !new ExpressionDTO().equals(expression);
    }

    public boolean isAllowedV2(String username, String action, InstanceDTO instance) {
        List<String> allowed = isAllowed(username, action, Collections.singletonList(instance), true);
        log.info("isAllowed {}|{}|{}|{}|{}", username, action, instance.getId(), allowed, allowed.contains(instance.getId()));
        return allowed.contains(instance.getId());
    }

    public List<String> isAllowed(String username, String action, List<InstanceDTO> instanceList, Boolean isV2) {
        if (CollectionUtils.isEmpty(instanceList)) {
            return Collections.emptyList();
        }

        ActionDTO actionDTO = new ActionDTO();
        actionDTO.setId(action);

        // 本系统资源不传 resource
        ExpressionDTO expression;
        if (isV2) {
            if (instanceList.get(0).getSystem().equals(iamConfiguration.getSystemId())) {
                expression = policyService.getPolicyByActionV2(username,
                    actionDTO, null, true);
            } else {
                expression = policyService.getPolicyByActionV2(username,
                    actionDTO, buildResourceList(instanceList), true);
            }
        } else {
            if (instanceList.get(0).getSystem().equals(iamConfiguration.getSystemId())) {
                expression = policyService.getPolicyByAction(username,
                    actionDTO, null);
            } else {
                expression = policyService.getPolicyByAction(username,
                    actionDTO, buildResourceList(instanceList));
            }
        }

        log.debug("Expression for action|{}|{}|{}|{}", username, action, instanceList,
            expression);
        if (expression == null) {
            return Collections.emptyList();
        }
        List<String> allowedInstanceList =
            instanceList.parallelStream().filter(instance -> {
                Map<String, InstanceDTO> instanceMap = new HashMap<>(1);
                instanceMap.put(instance.getType(), instance);
                return calculateExpression(instanceMap, expression);
            }).map(InstanceDTO::getId).distinct().collect(Collectors.toList());
        log.debug("Allowed instance list|{}|{}|{}", username, action, allowedInstanceList);
        return allowedInstanceList;
    }

    /**
     * 一个本系统资源对应多个其它系统资源的权限校验
     *
     * @param username              用户名
     * @param action                操作 ID
     * @param selfInstance          本系统资源
     * @param dependentInstanceList 依赖的其它系统资源，必须为同系统的同一种资源
     * @return
     */
    public boolean isAllowed(String username, String action, InstanceDTO selfInstance,
                             List<InstanceDTO> dependentInstanceList) {
        if (CollectionUtils.isEmpty(dependentInstanceList)) {
            throw new IamException(-1, "dependentInstanceList is required!");
        }
        ActionDTO actionDTO = new ActionDTO();
        actionDTO.setId(action);

        List<ResourceDTO> dependencyResource = new ArrayList<>();
        if (shouldGetDependentResourceAttr(dependentInstanceList)) {
            String systemId = dependentInstanceList.get(0).getSystem();
            String type = dependentInstanceList.get(0).getType();
            ResourceDTO resource = ResourceDTO.builder().system(systemId).type(type).idList(new ArrayList<>()).build();
            dependentInstanceList.forEach(instance -> {
                if (StringUtils.isNotBlank(instance.getId())) {
                    resource.getIdList().add(instance.getId());
                }
            });
            dependencyResource.add(resource);
        }

        ExpressionWithResourceDTO expressionWithResource = null;
        if (dependencyResource.size() == 1 && dependencyResource.get(0).getIdList().size() > BATCH_SIZE) {
            int page = 0;
            ResourceDTO resource = dependencyResource.get(0);
            while (page * BATCH_SIZE < resource.getIdList().size()) {
                List<String> resourceIdList;
                if ((page + 1) * BATCH_SIZE < resource.getIdList().size()) {
                    resourceIdList = resource.getIdList().subList(page * BATCH_SIZE, (page + 1) * BATCH_SIZE);
                } else {
                    resourceIdList = resource.getIdList().subList(page * BATCH_SIZE, resource.getIdList().size());
                }

                List<ResourceDTO> pageDependencyResource = new ArrayList<>();
                ResourceDTO pageResource = ResourceDTO.builder().system(resource.getSystem()).type(resource.getType()).idList(resourceIdList).build();
                pageDependencyResource.add(pageResource);

                ExpressionWithResourceDTO pageExpressionWithResource = policyService.batchGetPolicyAndAttribute(username,
                    actionDTO, null, pageDependencyResource);

                if (page == 0) {
                    expressionWithResource = pageExpressionWithResource;
                } else {
                    if (expressionWithResource == null) {
                        throw new IamException(-1, "Error while batch get policy and attribute by page!");
                    }
                    for (Map.Entry<String, Map<String, List<InstanceDTO>>> entry : pageExpressionWithResource.getInstanceMap().entrySet()) {
                        if (MapUtils.isNotEmpty(expressionWithResource.getInstanceMap().get(entry.getKey()))) {
                            for (Map.Entry<String, List<InstanceDTO>> instanceInfoEntry : entry.getValue().entrySet()) {
                                if (CollectionUtils.isNotEmpty(expressionWithResource.getInstanceMap().get(entry.getKey()).get(instanceInfoEntry.getKey()))) {
                                    expressionWithResource.getInstanceMap().get(entry.getKey()).get(instanceInfoEntry.getKey()).addAll(instanceInfoEntry.getValue());
                                } else {
                                    expressionWithResource.getInstanceMap().get(entry.getKey()).put(instanceInfoEntry.getKey(), instanceInfoEntry.getValue());
                                }
                            }
                        }
                    }
                }
                page++;
            }
        } else {
            expressionWithResource = policyService.batchGetPolicyAndAttribute(username,
                actionDTO, null, dependencyResource);
        }

        if (expressionWithResource == null) {
            throw new IamException(-1, "Error while batch get policy and attribute!");
        }

        ExpressionDTO expression = expressionWithResource.getExpression();
        Map<String, Map<String, List<InstanceDTO>>> systemTypeInstanceMap = expressionWithResource.getInstanceMap();
        Map<String, InstanceDTO> instanceMap = new ConcurrentHashMap<>();
        systemTypeInstanceMap.forEach((systemId, typeInstanceMap) ->
            typeInstanceMap.forEach((type, instanceList) ->
                instanceList.forEach(instance ->
                    instanceMap.put(instance.getId(), instance))));

        boolean pass = true;
        Map<String, InstanceDTO> finalInstanceMap = new ConcurrentHashMap<>();
        if (selfInstance != null) {
            finalInstanceMap.put(selfInstance.getType(), selfInstance);
        }
        for (InstanceDTO instance : dependentInstanceList) {
            if (StringUtils.isNotBlank(instance.getId()) && instanceMap.get(instance.getId()) != null) {
                finalInstanceMap.put(instance.getType(), instanceMap.get(instance.getId()));
            } else {
                finalInstanceMap.put(instance.getType(), instance);
            }
            if (!calculateExpression(finalInstanceMap, expression)) {
                pass = false;
            }
        }

        return pass;
    }

    private boolean shouldGetDependentResourceAttr(List<InstanceDTO> dependentResources) {
        return !CollectionUtils.isEmpty(dependentResources) && dependentResources.stream().anyMatch(instance -> StringUtils.isNotEmpty(instance.getId()));
    }

    public boolean validRequest(HttpServletRequest request) {
        try {
            String authHeader = request.getHeader("Authorization").trim();
            if (authHeader.startsWith(BASIC_AUTH)) {
                String base64AuthStr = authHeader.replace(BASIC_AUTH, "").trim();
                String authStr = new String(Base64.getDecoder().decode(base64AuthStr), Charsets.UTF_8);
                String[] userAndPass = authStr.split(":");
                String username = userAndPass[0];
                String password = userAndPass[1];
                if (IAM_USER.equals(username) && tokenService.getToken().equals(password)) {
                    log.debug("IAM callback basic auth check success!");
                    return true;
                }
                log.error("IAM callback basic auth check failed!");
                return false;
            } else if (authHeader.startsWith(DIGEST_AUTH)) {
                String digest = authHeader.replace(DIGEST_AUTH, "").trim();
                log.error("IAM callback digest auth check not support!");
                return false;
            } else {
                String sign = request.getHeader("X-Bk-IAM-Signature").trim();
                if (StringUtils.isNotBlank(sign)) {
                    log.error("IAM callback sign auth check not support!");
                    return false;
                } else {
                    log.error("Unknown IAM callback auth method!");
                    return false;
                }
            }
        } catch (Exception e) {
            log.error("Error while check iam callback request!", e);
        }
        return false;
    }

}
