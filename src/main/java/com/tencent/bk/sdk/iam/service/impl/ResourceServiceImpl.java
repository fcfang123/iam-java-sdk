package com.tencent.bk.sdk.iam.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.sdk.iam.config.IamConfiguration;
import com.tencent.bk.sdk.iam.constants.IamUri;
import com.tencent.bk.sdk.iam.dto.SelectionDTO;
import com.tencent.bk.sdk.iam.dto.resource.ResourceTypeDTO;
import com.tencent.bk.sdk.iam.dto.response.ResponseDTO;
import com.tencent.bk.sdk.iam.dto.system.SystemFieldDTO;
import com.tencent.bk.sdk.iam.exception.IamException;
import com.tencent.bk.sdk.iam.service.IamResourceService;
import com.tencent.bk.sdk.iam.service.SystemService;
import com.tencent.bk.sdk.iam.util.JsonUtil;
import com.tencent.bk.sdk.iam.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Slf4j
public class ResourceServiceImpl implements IamResourceService {
    private IamConfiguration iamConfiguration;
    private ApigwHttpClientServiceImpl apigwHttpClientService;
    private SystemService systemService;

    public ResourceServiceImpl(
        IamConfiguration iamConfiguration,
        ApigwHttpClientServiceImpl apigwHttpClientService,
        SystemService systemService
    ) {
        this.iamConfiguration = iamConfiguration;
        this.apigwHttpClientService = apigwHttpClientService;
        this.systemService = systemService;
    }

    @Override
    public boolean resourceCheck(String resourceType) {
        SystemFieldDTO systemFieldDTO = systemService.getSystemFieldsInfo(iamConfiguration.getSystemId());
        List<ResourceTypeDTO> resources = systemFieldDTO.getResourceType();
        // 系统下注册资源为空
        if (resources.isEmpty()) {
            return false;
        } else {
            // 资源已存在
            for (ResourceTypeDTO resource: resources) {
                if (resource.getId().equals(resourceType)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<SelectionDTO> getSystemInstanceSelector() {
        SystemFieldDTO systemFieldDTO = systemService.getSystemFieldsInfo(iamConfiguration.getSystemId());
        return systemFieldDTO.getInstanceSelections();
    }

    @Override
    public boolean createResource(List<ResourceTypeDTO> resourceTypeDTO) {
        try {
            String url = String.format(IamUri.ADD_RESOURCE_TYPE, iamConfiguration.getSystemId());
            String responseStr = apigwHttpClientService.doHttpPost(url, resourceTypeDTO);
            if (StringUtils.isNotBlank(responseStr)) {
                ResponseDTO<Object> result = JsonUtil.fromJson(responseStr, new TypeReference<ResponseDTO<Object>>() {
                });
                ResponseUtil.checkResponse(result);
                log.info("create resource success. {}", resourceTypeDTO);
                return true;
            } else {
                log.info("create Resource is empty");
            }
        } catch (IamException iamException) {
            log.warn("create resource fail. {}|{}", resourceTypeDTO, iamException);
        } catch (Exception e) {
            log.warn("create resource fail. {}|{}", resourceTypeDTO, e);
        }
        return false;
    }

    @Override
    public boolean updateResource(ResourceTypeDTO resourceTypeDTO, String resourceId) {
        try {
            String url = String.format(IamUri.UPDATE_OR_DELETE_RESOURCE_TYPE, iamConfiguration.getSystemId(), resourceId);
            String responseStr = apigwHttpClientService.doHttpPut(url, resourceTypeDTO);
            if (StringUtils.isNotBlank(responseStr)) {
                ResponseDTO<Object> result = JsonUtil.fromJson(responseStr, new TypeReference<ResponseDTO<Object>>() {
                });
                ResponseUtil.checkResponse(result);
                log.info("update resource success. {}", resourceTypeDTO);
                return true;
            } else {
                log.info("update Resource is empty");
            }
        } catch (IamException iamException) {
            log.warn("update resource fail. {}|{}", resourceTypeDTO, iamException);
        } catch (Exception e) {
            log.warn("update resource fail. {}|{}", resourceTypeDTO, e);
        }
        return false;
    }

    @Override
    public boolean createResourceInstanceSelector(List<SelectionDTO> instanceSelector) {
        try {
            String url = String.format(IamUri.ADD_INSTANCE_SELECTIONS, iamConfiguration.getSystemId());
            String responseStr = apigwHttpClientService.doHttpPost(url, instanceSelector);
            if (StringUtils.isNotBlank(responseStr)) {
                ResponseDTO<Object> result = JsonUtil.fromJson(responseStr, new TypeReference<ResponseDTO<Object>>() {
                });
                ResponseUtil.checkResponse(result);
                log.info("create resource instance success. {}", instanceSelector);
                return true;
            } else {
                log.info("create resource instance is empty");
            }
        } catch (IamException iamException) {
            log.warn("create resource instance fail. {}|{}", instanceSelector, iamException);
        } catch (Exception e) {
            log.warn("create resource instance fail. {}|{}", instanceSelector, e);
        }
        return false;
    }

    @Override
    public boolean updateResourceInstanceSelector(String selectionId, SelectionDTO instanceSelector) {
        try {
            String url = String.format(IamUri.UPDATE_INSTANCE_SELECTIONS, iamConfiguration.getSystemId(), selectionId);
            String responseStr = apigwHttpClientService.doHttpPut(url, instanceSelector);
            if (StringUtils.isNotBlank(responseStr)) {
                ResponseDTO<Object> result = JsonUtil.fromJson(responseStr, new TypeReference<ResponseDTO<Object>>() {
                });
                ResponseUtil.checkResponse(result);
                log.info("update resource InstanceSelector success. {}", instanceSelector);
                return true;
            } else {
                log.info("update resource InstanceSelector is empty");
            }
        } catch (IamException iamException) {
            log.warn("update resource InstanceSelector fail. {}|{}", instanceSelector, iamException);
        } catch (Exception e) {
            log.warn("update resource InstanceSelector fail. {}|{}", instanceSelector, e);
        }
        return false;
    }
}
