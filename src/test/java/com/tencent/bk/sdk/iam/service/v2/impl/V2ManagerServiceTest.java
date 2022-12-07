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

package com.tencent.bk.sdk.iam.service.v2.impl;

import com.tencent.bk.sdk.iam.config.IamConfiguration;
import com.tencent.bk.sdk.iam.dto.GradeManagerApplicationCreateDTO;
import com.tencent.bk.sdk.iam.dto.GradeManagerApplicationUpdateDTO;
import com.tencent.bk.sdk.iam.dto.PageInfoDTO;
import com.tencent.bk.sdk.iam.dto.SubjectDTO;
import com.tencent.bk.sdk.iam.dto.V2BelongDTO;
import com.tencent.bk.sdk.iam.dto.V2PageInfoDTO;
import com.tencent.bk.sdk.iam.dto.V2QueryPolicyDTO;
import com.tencent.bk.sdk.iam.dto.action.ActionDTO;
import com.tencent.bk.sdk.iam.dto.action.ActionGroupDTO;
import com.tencent.bk.sdk.iam.dto.action.GroupAction;
import com.tencent.bk.sdk.iam.dto.itsm.ItsmAttrs;
import com.tencent.bk.sdk.iam.dto.itsm.ItsmColumn;
import com.tencent.bk.sdk.iam.dto.itsm.ItsmContentDTO;
import com.tencent.bk.sdk.iam.dto.itsm.ItsmScheme;
import com.tencent.bk.sdk.iam.dto.itsm.ItsmStyle;
import com.tencent.bk.sdk.iam.dto.itsm.ItsmValue;
import com.tencent.bk.sdk.iam.dto.manager.Action;
import com.tencent.bk.sdk.iam.dto.manager.AuthorizationScopes;
import com.tencent.bk.sdk.iam.dto.manager.ManagerMember;
import com.tencent.bk.sdk.iam.dto.manager.ManagerPath;
import com.tencent.bk.sdk.iam.dto.manager.ManagerResources;
import com.tencent.bk.sdk.iam.dto.manager.ManagerRoleGroup;
import com.tencent.bk.sdk.iam.dto.manager.ManagerScopes;
import com.tencent.bk.sdk.iam.dto.manager.dto.CreateManagerDTO;
import com.tencent.bk.sdk.iam.dto.manager.dto.CreateSubsetManagerDTO;
import com.tencent.bk.sdk.iam.dto.manager.dto.ManagerMemberGroupDTO;
import com.tencent.bk.sdk.iam.dto.manager.dto.ManagerRoleGroupDTO;
import com.tencent.bk.sdk.iam.dto.manager.dto.UpdateManagerDTO;
import com.tencent.bk.sdk.iam.dto.manager.vo.ManagerGroupMemberVo;
import com.tencent.bk.sdk.iam.dto.manager.vo.V2ManagerRoleGroupVO;
import com.tencent.bk.sdk.iam.dto.resource.ResourceCreatorActionsDTO;
import com.tencent.bk.sdk.iam.dto.resource.V2ResourceNode;
import com.tencent.bk.sdk.iam.dto.response.GradeManagerApplicationResponse;
import com.tencent.bk.sdk.iam.dto.system.SystemFieldDTO;
import com.tencent.bk.sdk.iam.service.IamActionService;
import com.tencent.bk.sdk.iam.service.IamResourceService;
import com.tencent.bk.sdk.iam.service.ManagerService;
import com.tencent.bk.sdk.iam.service.PolicyService;
import com.tencent.bk.sdk.iam.service.SystemService;
import com.tencent.bk.sdk.iam.service.impl.ActionServiceImpl;
import com.tencent.bk.sdk.iam.service.impl.ApigwHttpClientServiceImpl;
import com.tencent.bk.sdk.iam.service.impl.ManagerServiceImpl;
import com.tencent.bk.sdk.iam.service.impl.PolicyServiceImpl;
import com.tencent.bk.sdk.iam.service.impl.ResourceServiceImpl;
import com.tencent.bk.sdk.iam.service.impl.SystemServiceImpl;
import com.tencent.bk.sdk.iam.service.v2.V2ManagerService;
import com.tencent.bk.sdk.iam.service.v2.V2PolicyService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Disabled
public class V2ManagerServiceTest {
    private IamConfiguration iamConfiguration = new IamConfiguration
        ("", "", "",
            "", "");
    private ApigwHttpClientServiceImpl apigwHttpClientService = new ApigwHttpClientServiceImpl(iamConfiguration);
    V2ManagerService v2ManagerService = new V2ManagerServiceImpl(apigwHttpClientService, iamConfiguration);
    ManagerService managerService = new ManagerServiceImpl(apigwHttpClientService, iamConfiguration);
    V2PolicyService v2PolicyService = new V2PolicyServiceImpl(apigwHttpClientService, iamConfiguration);
    PolicyService policyService = new PolicyServiceImpl(iamConfiguration, apigwHttpClientService);

    SystemService systemService = new SystemServiceImpl(apigwHttpClientService, iamConfiguration);
    IamActionService iamActionService = new ActionServiceImpl(iamConfiguration, apigwHttpClientService, systemService);
    IamResourceService iamResourceService = new ResourceServiceImpl(iamConfiguration, apigwHttpClientService, systemService);


    @Test
    public void testV2BatchCreateRoleGroup() {
        ManagerRoleGroup managerRoleGroup1 = new ManagerRoleGroup("testfc7", "testfc1testfc1", false);
        ManagerRoleGroup managerRoleGroup2 = new ManagerRoleGroup("testfc8", "testfc2testfc2", false);
        List<ManagerRoleGroup> groups = Arrays.asList(managerRoleGroup1, managerRoleGroup2);
        ManagerRoleGroupDTO managerRoleGroupDTO = ManagerRoleGroupDTO.builder().groups(groups).build();
        Integer integer = v2ManagerService.batchCreateRoleGroupV2(3151, managerRoleGroupDTO);
        System.out.println(integer);
    }

    @Test
    public void testV2UpdateRoleGroup() {
        ManagerRoleGroup managerRoleGroup = new ManagerRoleGroup("testfc10", "testGreysontestGreysontestGreyson", true);
        v2ManagerService.updateRoleGroupV2(10124, managerRoleGroup);
    }

    @Test
    public void testV2DeleteRoleGroup() {
        v2ManagerService.deleteRoleGroupV2(10124);
    }

    @Test
    public void testV2CreateRoleGroupMember() {
        List<ManagerMember> members = new ArrayList<>();
        members.add(new ManagerMember("user", "greysonfang"));
        Long expiredTime = System.currentTimeMillis() / 1000 + TimeUnit.DAYS.toSeconds(10);
        ManagerMemberGroupDTO managerMemberGroupDTO = ManagerMemberGroupDTO.builder().members(members).expiredAt(expiredTime).build();
        v2ManagerService.createRoleGroupMemberV2(10125, managerMemberGroupDTO);
    }

    @Test
    public void testV2DeleteRoleGroupMember() {
        v2ManagerService.deleteRoleGroupMemberV2(10125, "user", "greysonfang");
    }

    @Test
    public void testVerifyGroupValidMember() {
        System.out.println(v2ManagerService.verifyGroupValidMember("greysonfang", "10125,10076"));
    }

    @Test
    public void testV2GetRoleGroupMember() {
        PageInfoDTO pageInfoDTO = new PageInfoDTO();
        pageInfoDTO.setLimit(1L);
        pageInfoDTO.setOffset(0L);
        ManagerGroupMemberVo managerGroupMemberVo = v2ManagerService.getRoleGroupMemberV2(10031, pageInfoDTO);
        System.out.println(managerGroupMemberVo);
    }

    @Test
    public void testV2RenewalRoleGroupMember() {
        ArrayList<ManagerMember> members = new ArrayList<>();
        ManagerMember managerMember = new ManagerMember("user", "greysonfang");
        members.add(managerMember);
        Long expiredTime = System.currentTimeMillis() / 1000 + TimeUnit.DAYS.toSeconds(12);
        v2ManagerService.renewalRoleGroupMemberV2(10031, ManagerMemberGroupDTO.builder().members(members).expiredAt(expiredTime).build());
    }

    @Test
    public void testV2GrantRoleGroup() {
        List<Action> actions = Arrays.asList(new Action("all_action"));
        ManagerPath managerPath = new ManagerPath("bk_ci", "project", "fc-test", "testfc8");
        List<ManagerResources> resources = Arrays.asList(ManagerResources.builder().system("bk_ci").type("project").paths(Arrays.asList(Arrays.asList(managerPath))).build());
        AuthorizationScopes authorizationScopes = AuthorizationScopes.builder().system("bk_ci").actions(actions).resources(resources).build();
        v2ManagerService.grantRoleGroupV2(10125, authorizationScopes);
    }

    @Test
    public void testV2GetRoleGroupAction() {
        List<GroupAction> groupActions = v2ManagerService.getRoleGroupActionV2(10125);
        System.out.println(groupActions);
    }

    @Test
    public void testVerifyPermissions() {
        ActionDTO actionDTO = new ActionDTO();
        actionDTO.setId("project_view");
        V2QueryPolicyDTO v2QueryPolicyDTO = V2QueryPolicyDTO
            .builder()
            .system("bk_ci")
            .subject(SubjectDTO.builder().type("user").id("greysonfang").build())
            .action(actionDTO)
            .resources(Arrays.asList(V2ResourceNode.builder().system("bk_ci").type("project").id("fc-test").build())).build();
        Boolean aBoolean = v2PolicyService.verifyPermissions(v2QueryPolicyDTO);
        System.out.println(aBoolean);
    }

    @Test
    public void testCreateManagerV2() throws IOException {
        ManagerScopes department = new ManagerScopes("user", "greysonfang");
        AuthorizationScopes resources = AuthorizationScopes.builder()
            .system("bk_ci")
            .actions(Arrays.asList(new Action("project_view")))
            .resources(
                Arrays.asList(ManagerResources
                    .builder()
                    .system("bk_ci")
                    .type("project")
                    .paths(Arrays.asList(Arrays.asList(new ManagerPath("bk_ci", "project", "fc-test-rbac11", "fc-test-rbac11"))))
                    .build()))
            .build();
        CreateManagerDTO test1 = CreateManagerDTO.builder().system("bk_ci").name("fc-test-rbac1121").description("fc-test-rbac11")
            .members(Arrays.asList("greysonfang"))
            .authorization_scopes(Arrays.asList(resources))
            .subject_scopes(Arrays.asList(department)).build();
        Integer manager = v2ManagerService.createManagerV2(test1);
        System.out.println(manager);
        // 3151
    }

    @Test
    public void testUpdateManagerV2() throws IOException {
        ManagerScopes department = new ManagerScopes("*", "*");
        AuthorizationScopes resources = AuthorizationScopes.builder()
            .system("bk_ci")
            .actions(Arrays.asList(new Action("all_action")))
            .resources(
                Arrays.asList(ManagerResources
                    .builder()
                    .system("bk_ci")
                    .type("project")
                    .paths(Arrays.asList(Arrays.asList(new ManagerPath("bk_ci", "project", "fc-test", "test-greysonfang-v2"))))
                    .build()))
            .build();
        UpdateManagerDTO test1 = UpdateManagerDTO.builder().name("greysonfang-v212112").description("test")
            .authorizationScopes(Arrays.asList(resources))
            .members(Arrays.asList("greysonfang"))
            .subjectScopes(Arrays.asList(department)).build();
        v2ManagerService.updateManagerV2("3156", test1);
        // System.out.println(manager);
        // 3151
    }


    @Test
    public void testGetUserGroup() {
        System.out.println(managerService.getUserGroup(3097, "greysonfang"));
    }


    @Test
    public void testVerifyRoleGruopMember() {
        V2BelongDTO v2BelongDTO = V2BelongDTO.builder().userId("greysonfang").groupIds("10019").inherit(false).build();
        Map<Integer, Boolean> map = v2PolicyService.verifyRoleGruopMember(v2BelongDTO);
        System.out.println(map);
    }

    @Test
    public void testGetResourceCreatorAction() {
        System.out.print(iamActionService.getResourceCreatorAction());
    }

    @Test
    public void testResourceCheck() {
        System.out.println(iamResourceService.resourceCheck("project"));
    }

    @Test
    public void testGetAction() {
        System.out.println(iamActionService.getAction("project_view1"));
    }

    @Test
    public void testGetActionGroup() {
        System.out.println(iamActionService.getActionGroup("项目管理"));
    }

    @Test
    public void testCreateActionGroup() {
        ActionGroupDTO actionGroupDTO = new ActionGroupDTO();
        GroupAction groupAction1 = new GroupAction();
        groupAction1.setId("pipeline_edit");
        GroupAction groupAction2 = new GroupAction();
        groupAction2.setId("project_view");
        actionGroupDTO.setActions(Arrays.asList(groupAction1, groupAction2));
        actionGroupDTO.setName("fctest3");
        actionGroupDTO.setEnglishName("fctest3");
        iamActionService.createActionGroup(Arrays.asList(actionGroupDTO));
    }

    @Test
    public void testDeleteAction() {
        System.out.println(iamActionService.deleteAction("fitz_resource_4_view", true));
    }

    @Test
    public void testCreateResourceCreatorAction() {
        SystemFieldDTO bk_ci = systemService.getSystemFieldsInfo("bk_ci");
        System.out.println(bk_ci);
        //System.out.println(bk_ci.getResourceCreatorActions());
        //System.out.println(bk_ci.getActionGroup());
        // System.out.println(bk_ci.getActions());
        System.out.println(bk_ci.getResourceType());
    }

    @Test
    public void testGetSystemFieldsInfo() {
        ResourceCreatorActionsDTO resourceCreatorActionsDTO = new ResourceCreatorActionsDTO();

    }

    @Test
    public void testGetUserGroup1() {
        System.out.println(policyService.getUserGroup("greysonfang", false));
    }

    @Test
    public void testBatchGetPolicyByActionList() {
//        val viewAction = PROJECT_VIEW
//        val managerAction = ALL_ACTION
//        val actionDTOs = mutableListOf<ActionDTO>()
//        val viewActionDto = ActionDTO()
//        viewActionDto.id = viewAction
//        val managerActionDto = ActionDTO()
//        managerActionDto.id = managerAction
//        actionDTOs.add(viewActionDto)
//        actionDTOs.add(managerActionDto)
        String viewAction = "project_view";
        String managerAction = "all_action";
        ArrayList<ActionDTO> actionDTOS = new ArrayList<>();
        ActionDTO viewActionDto = new ActionDTO();
        viewActionDto.setId(viewAction);
        ActionDTO managerActionDto = new ActionDTO();
        managerActionDto.setId(managerAction);
        actionDTOS.add(viewActionDto);
        actionDTOS.add(managerActionDto);

        System.out.println(policyService.getPolicyByAction("greysonfang", managerActionDto, null));
    }

    @Test
    public void testCreateRoleGroupApplicationV2() {
        Long expiredTime = System.currentTimeMillis() / 1000 + TimeUnit.DAYS.toSeconds(10);
        System.out.println(expiredTime);
//        ApplicationDTO applicationDTO = ApplicationDTO.builder().groupId(Arrays.asList(10125)).expiredAt(expiredTime).applicant("greysonfang").reason("test").build();
//        ApplicationVO roleGroupApplicationV2 = v2ManagerService.createRoleGroupApplicationV2(applicationDTO);
//        System.out.println(roleGroupApplicationV2);
    }

    @Test
    public void testCreateSubsetManager() throws IOException {
        ManagerScopes department = new ManagerScopes("user", "greysonfang");
        AuthorizationScopes resources = AuthorizationScopes.builder()
            .system("bk_ci")
            .actions(Arrays.asList(new Action("all_action")))
            .resources(
                Arrays.asList(ManagerResources
                    .builder()
                    .system("bk_ci")
                    .type("project")
                    .paths(Arrays.asList(Arrays.asList(new ManagerPath("bk_ci", "project", "fc-test", "test-greysonfang-v2"))))
                    .build()))
            .build();
        CreateSubsetManagerDTO test1 = CreateSubsetManagerDTO.builder().name("greysonfang-v2-subset1").description("test")
            .members(Arrays.asList("greysonfang"))
            .authorizationScopes(Arrays.asList(resources))
            .subjectScopes(Arrays.asList(department)).build();
        Integer subsetManager = v2ManagerService.createSubsetManager("3151", test1);
        System.out.println(subsetManager);
        // 3153
    }

    @Test
    public void testBatchCreateSubsetRoleGroup() {
        ManagerRoleGroup managerRoleGroup1 = new ManagerRoleGroup("testfc7", "testfc1testfc1", false);
        ManagerRoleGroup managerRoleGroup2 = new ManagerRoleGroup("testfc8", "testfc2testfc2", false);
        List<ManagerRoleGroup> groups = Arrays.asList(managerRoleGroup1, managerRoleGroup2);
        ManagerRoleGroupDTO managerRoleGroupDTO = ManagerRoleGroupDTO.builder().groups(groups).build();
        Integer integer = v2ManagerService.batchCreateRoleGroupV2(3153, managerRoleGroupDTO);
        System.out.println(integer);
    }

    @Test
    public void testGetSubsetManagerRoleGroup() {
        V2PageInfoDTO v2PageInfoDTO = new V2PageInfoDTO();
        v2PageInfoDTO.setPage(1);
        v2PageInfoDTO.setPageSize(100);
        V2ManagerRoleGroupVO gradeManagerRoleGroupV2 = v2ManagerService.getGradeManagerRoleGroupV2("3156", "testfc1", v2PageInfoDTO);
        System.out.println(gradeManagerRoleGroupV2);
    }

    @Test
    public void testCreateGradeManagerApplication() {
        ManagerScopes department = new ManagerScopes("user", "greysonfang");
        AuthorizationScopes resources = AuthorizationScopes.builder()
            .system("bk_ci")
            .actions(Arrays.asList(new Action("all_action")))
            .resources(
                Arrays.asList(ManagerResources
                    .builder()
                    .system("bk_ci")
                    .type("project")
                    .paths(Arrays.asList(Arrays.asList(new ManagerPath("bk_ci", "project", "fc-test", "test-greysonfang-v2"))))
                    .build()))
            .build();
        List<ItsmColumn> itsmColumns = Arrays.asList(
            ItsmColumn.builder().key("projectName").name("项目名称").type("text").build(),
            ItsmColumn.builder().key("projectId").name("项目ID").type("text").build(),
            ItsmColumn.builder().key("desc").name("项目描述").type("text").build(),
            ItsmColumn.builder().key("organization").name("所属组织").type("text").build(),
            ItsmColumn.builder().key("authSecrecy").name("项目性质").type("text").build(),
            ItsmColumn.builder().key("subjectScopes").name("最大可授权人员范围").type("text").width(100).build()
        );
        ItsmAttrs itsmAttrs = ItsmAttrs.builder().column(itsmColumns).build();
        ItsmScheme itsmScheme = ItsmScheme.builder().attrs(itsmAttrs).type("table").build();
        HashMap<String, ItsmScheme> scheme = new HashMap<>();
        scheme.put("content_table", itsmScheme);
        HashMap<String, ItsmStyle> value = new HashMap<>();
        value.put("projectName", ItsmStyle.builder().value("test").build());
        value.put("projectId", ItsmStyle.builder().value("test").build());
        value.put("desc", ItsmStyle.builder().value("test").build());
        value.put("organization", ItsmStyle.builder().value("test").build());
        value.put("authSecrecy", ItsmStyle.builder().value("test").build());
        value.put("subjectScopes", ItsmStyle.builder().value("test").build());
        ItsmValue itsmValue = ItsmValue.builder().scheme("content_table").lable("项目创建审批").value(Arrays.asList(value)).build();
        ItsmContentDTO itsmContentDTO = ItsmContentDTO.builder().formData(Arrays.asList(itsmValue)).schemes(scheme).build();

        GradeManagerApplicationCreateDTO build = GradeManagerApplicationCreateDTO.builder().name("fc-test-rbac412126").description("fc-test-rbac121241")
            .members(Arrays.asList("greysonfang"))
            .authorizationScopes(Arrays.asList(resources))
            .subjectScopes(Arrays.asList(department))
            .applicant("greysonfang")
            .reason("just test")
            .callbackId("123")
            .callbackUrl("xxx")
            .content(itsmContentDTO)
            .title("fc-test").build();
        // GradeManagerApplicationResponse(id=604, sn=REQ20221122000028)
        GradeManagerApplicationResponse gradeManagerApplication = v2ManagerService.createGradeManagerApplication(build);
        System.out.println(gradeManagerApplication);
    }

    @Test
    public void testCancelCallbackApplication() {
        //REQ20221122000021
        Boolean req20221122000021 = v2ManagerService.cancelCallbackApplication("11112331312312311111233131231225");
        System.out.println(req20221122000021);
    }

    @Test
    public void testUpdateGradeManagerApplication() {
        ManagerScopes department = new ManagerScopes("user", "greysonfang");
        AuthorizationScopes resources = AuthorizationScopes.builder()
            .system("bk_ci")
            .actions(Arrays.asList(new Action("all_action")))
            .resources(
                Arrays.asList(ManagerResources
                    .builder()
                    .system("bk_ci")
                    .type("project")
                    .paths(Arrays.asList(Arrays.asList(new ManagerPath("bk_ci", "project", "fc-test", "test-greysonfang-v1"))))
                    .build()))
            .build();
        List<ItsmColumn> itsmColumns = Arrays.asList(
            ItsmColumn.builder().key("projectName").name("项目名称").type("text").build(),
            ItsmColumn.builder().key("projectId").name("项目ID").type("text").build(),
            ItsmColumn.builder().key("desc").name("项目描述").type("text").build(),
            ItsmColumn.builder().key("organization").name("所属组织").type("text").build(),
            ItsmColumn.builder().key("authSecrecy").name("项目性质").type("text").build(),
            ItsmColumn.builder().key("subjectScopes").name("最大可授权人员范围").type("text").width(100).build()
        );
        ItsmAttrs itsmAttrs = ItsmAttrs.builder().column(itsmColumns).build();
        ItsmScheme itsmScheme = ItsmScheme.builder().attrs(itsmAttrs).type("table").build();
        HashMap<String, ItsmScheme> scheme = new HashMap<>();
        scheme.put("content_table", itsmScheme);
        HashMap<String, ItsmStyle> value = new HashMap<>();
        value.put("projectName", ItsmStyle.builder().value("test").build());
        value.put("projectId", ItsmStyle.builder().value("test").build());
        value.put("desc", ItsmStyle.builder().value("test").build());
        value.put("organization", ItsmStyle.builder().value("test").build());
        value.put("authSecrecy", ItsmStyle.builder().value("test").build());
        value.put("subjectScopes", ItsmStyle.builder().value("test").build());
        ItsmValue itsmValue = ItsmValue.builder().scheme("content_table").lable("项目创建审批").value(Arrays.asList(value)).build();
        ItsmContentDTO itsmContentDTO = ItsmContentDTO.builder().formData(Arrays.asList(itsmValue)).schemes(scheme).build();
        GradeManagerApplicationUpdateDTO build = GradeManagerApplicationUpdateDTO.builder().name("test-134").description("123")
            .members(Arrays.asList("greysonfang"))
            .authorizationScopes(Arrays.asList(resources))
            .subjectScopes(Arrays.asList(department))
            .applicant("greysonfang")
            .reason("just test")
            .callbackId("1234")
            .callbackUrl("xxx")
            .content(itsmContentDTO)
            .title("fc-test").build();

        GradeManagerApplicationResponse gradeManagerApplication = v2ManagerService.updateGradeManagerApplication("3153", build);
        System.out.println(gradeManagerApplication);
    }

    @Test
    public void testGetGradeManagerDetail() {
        System.out.println(v2ManagerService.getGradeManagerDetail("3156"));
    }
}
