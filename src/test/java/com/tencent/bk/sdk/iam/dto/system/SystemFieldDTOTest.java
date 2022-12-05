package com.tencent.bk.sdk.iam.dto.system;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.sdk.iam.dto.response.ResponseDTO;
import com.tencent.bk.sdk.iam.util.JsonUtil;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

class SystemFieldDTOTest {

    private String resourceType = "{\n" +
        "    \"code\": 0,\n" +
        "    \"message\": \"ok\",\n" +
        "    \"data\": {\n" +
        "        \"resource_types\": [\n" +
        "            {\n" +
        "                \"id\": \"project\",\n" +
        "                \"name\": \"项目\",\n" +
        "                \"name_en\": \"Project\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"parents\": [],\n" +
        "                \"provider_config\": {\n" +
        "                    \"path\": \"/api/open/auth/resource/projects\"\n" +
        "                },\n" +
        "                \"version\": 1\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"pipeline\",\n" +
        "                \"name\": \"流水线\",\n" +
        "                \"name_en\": \"Pipeline\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"parents\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"provider_config\": {\n" +
        "                    \"path\": \"/api/open/auth/resource/instances/list\"\n" +
        "                },\n" +
        "                \"version\": 1\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"repertory\",\n" +
        "                \"name\": \"代码库\",\n" +
        "                \"name_en\": \"Repository\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"parents\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"provider_config\": {\n" +
        "                    \"path\": \"/api/open/auth/resource/instances/list\"\n" +
        "                },\n" +
        "                \"version\": 1\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"credential\",\n" +
        "                \"name\": \"凭据\",\n" +
        "                \"name_en\": \"Credential\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"parents\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"provider_config\": {\n" +
        "                    \"path\": \"/api/open/auth/resource/instances/list\"\n" +
        "                },\n" +
        "                \"version\": 1\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"cert\",\n" +
        "                \"name\": \"证书\",\n" +
        "                \"name_en\": \"Cert\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"parents\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"provider_config\": {\n" +
        "                    \"path\": \"/api/open/auth/resource/instances/list\"\n" +
        "                },\n" +
        "                \"version\": 1\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"environment\",\n" +
        "                \"name\": \"环境\",\n" +
        "                \"name_en\": \"Environment\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"parents\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"provider_config\": {\n" +
        "                    \"path\": \"/api/open/auth/resource/instances/list\"\n" +
        "                },\n" +
        "                \"version\": 1\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"env_node\",\n" +
        "                \"name\": \"节点\",\n" +
        "                \"name_en\": \"Node\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"parents\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"provider_config\": {\n" +
        "                    \"path\": \"/api/open/auth/resource/instances/list\"\n" +
        "                },\n" +
        "                \"version\": 1\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"experience_task\",\n" +
        "                \"name\": \"体验任务\",\n" +
        "                \"name_en\": \"experience_task\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"parents\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"provider_config\": {\n" +
        "                    \"path\": \"/api/open/auth/resource/instances/list\"\n" +
        "                },\n" +
        "                \"version\": 1\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"experience_group\",\n" +
        "                \"name\": \"体验组\",\n" +
        "                \"name_en\": \"experience_group\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"parents\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"provider_config\": {\n" +
        "                    \"path\": \"/api/open/auth/resource/instances/list\"\n" +
        "                },\n" +
        "                \"version\": 1\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"rule\",\n" +
        "                \"name\": \"质量红线规则\",\n" +
        "                \"name_en\": \"Rule\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"parents\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"provider_config\": {\n" +
        "                    \"path\": \"/api/open/auth/resource/instances/list\"\n" +
        "                },\n" +
        "                \"version\": 1\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"quality_group\",\n" +
        "                \"name\": \"质量红线通知组\",\n" +
        "                \"name_en\": \"Group\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"parents\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"provider_config\": {\n" +
        "                    \"path\": \"/api/open/auth/resource/instances/list\"\n" +
        "                },\n" +
        "                \"version\": 1\n" +
        "            }\n" +
        "        ]\n" +
        "    }\n" +
        "}";

    private String actionGroup = "{\n" +
        "    \"code\": 0,\n" +
        "    \"message\": \"ok\",\n" +
        "    \"data\": {\n" +
        "        \"action_groups\": [\n" +
        "            {\n" +
        "                \"actions\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project_view\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"project_views_manager\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"all_action\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"name\": \"项目管理\",\n" +
        "                \"name_en\": \"Project Permissions\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"actions\": [\n" +
        "                    {\n" +
        "                        \"id\": \"pipeline_view\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"pipeline_edit\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"pipeline_create\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"pipeline_download\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"pipeline_delete\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"pipeline_share\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"pipeline_execute\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"name\": \"流水线管理\",\n" +
        "                \"name_en\": \"Pipeline Permissions\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"actions\": [\n" +
        "                    {\n" +
        "                        \"id\": \"repertory_view\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"repertory_edit\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"repertory_create\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"repertory_delete\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"repertory_use\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"name\": \"代码库管理\",\n" +
        "                \"name_en\": \"Repository Permissions\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"actions\": [\n" +
        "                    {\n" +
        "                        \"id\": \"credential_view\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"credential_edit\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"credential_create\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"credential_delete\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"credential_use\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"name\": \"凭证管理\",\n" +
        "                \"name_en\": \"Credential Permissions\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"actions\": [\n" +
        "                    {\n" +
        "                        \"id\": \"cert_view\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"cert_edit\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"cert_create\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"cert_delete\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"cert_use\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"name\": \"证书管理\",\n" +
        "                \"name_en\": \"Cert Permissions\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"actions\": [\n" +
        "                    {\n" +
        "                        \"id\": \"environment_view\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"environment_edit\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"environment_create\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"environment_delete\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"environment_use\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"name\": \"环境管理\",\n" +
        "                \"name_en\": \"Environment Permissions\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"actions\": [\n" +
        "                    {\n" +
        "                        \"id\": \"env_node_view\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"env_node_edit\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"env_node_create\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"env_node_delete\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"env_node_use\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"name\": \"环境节点管理\",\n" +
        "                \"name_en\": \"Node Permissions\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"actions\": [\n" +
        "                    {\n" +
        "                        \"id\": \"experience_task_delete\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"experience_task_edit\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"experience_group_delete\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"experience_group_edit\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"name\": \"版本体验\",\n" +
        "                \"name_en\": \"Experience Permissions\"\n" +
        "            },\n" +
        "            {\n" +
        "                \"actions\": [\n" +
        "                    {\n" +
        "                        \"id\": \"rule_create\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"rule_delete\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"rule_edit\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"rule_enable\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"quality_group_create\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"quality_group_delete\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"quality_group_edit\"\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"name\": \"质量红线\",\n" +
        "                \"name_en\": \"Quality Permissions\"\n" +
        "            }\n" +
        "        ]\n" +
        "    }\n" +
        "}";

    private String instanceSelect = "{\n" +
        "    \"code\": 0,\n" +
        "    \"message\": \"ok\",\n" +
        "    \"data\": {\n" +
        "        \"instance_selections\": [\n" +
        "            {\n" +
        "                \"id\": \"cert_instance\",\n" +
        "                \"name\": \"证书视图\",\n" +
        "                \"name_en\": \"cert instance selection\",\n" +
        "                \"is_dynamic\": false,\n" +
        "                \"resource_type_chain\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"cert\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ]\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"credential_instance\",\n" +
        "                \"name\": \"凭证视图\",\n" +
        "                \"name_en\": \"credential instance selection\",\n" +
        "                \"is_dynamic\": false,\n" +
        "                \"resource_type_chain\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"credential\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ]\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"environment_instance\",\n" +
        "                \"name\": \"环境视图\",\n" +
        "                \"name_en\": \"environment instance selection\",\n" +
        "                \"is_dynamic\": false,\n" +
        "                \"resource_type_chain\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"environment\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ]\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"experience_group_instance\",\n" +
        "                \"name\": \"版本体验用户组\",\n" +
        "                \"name_en\": \"experience_group instance selection\",\n" +
        "                \"is_dynamic\": false,\n" +
        "                \"resource_type_chain\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"experience_group\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ]\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"experience_task_instance\",\n" +
        "                \"name\": \"版本体验任务\",\n" +
        "                \"name_en\": \"experience_task instance selection\",\n" +
        "                \"is_dynamic\": false,\n" +
        "                \"resource_type_chain\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"experience_task\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ]\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"node_instance\",\n" +
        "                \"name\": \"环境节点视图\",\n" +
        "                \"name_en\": \"node instance selection\",\n" +
        "                \"is_dynamic\": false,\n" +
        "                \"resource_type_chain\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"env_node\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ]\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"pipeline_instance\",\n" +
        "                \"name\": \"流水线视图\",\n" +
        "                \"name_en\": \"pipeline instance selection\",\n" +
        "                \"is_dynamic\": false,\n" +
        "                \"resource_type_chain\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"pipeline\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ]\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"project_instance\",\n" +
        "                \"name\": \"项目视图\",\n" +
        "                \"name_en\": \"project instance selection\",\n" +
        "                \"is_dynamic\": false,\n" +
        "                \"resource_type_chain\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ]\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"quality_group_rule\",\n" +
        "                \"name\": \"质量红线用户组视图\",\n" +
        "                \"name_en\": \"quality group instance selection\",\n" +
        "                \"is_dynamic\": false,\n" +
        "                \"resource_type_chain\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"quality_group\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ]\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"quality_rule_instance\",\n" +
        "                \"name\": \"质量红线规则视图\",\n" +
        "                \"name_en\": \"quality rule instance selection\",\n" +
        "                \"is_dynamic\": false,\n" +
        "                \"resource_type_chain\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"rule\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ]\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"repertory_instance\",\n" +
        "                \"name\": \"代码库视图\",\n" +
        "                \"name_en\": \"repository instance selection\",\n" +
        "                \"is_dynamic\": false,\n" +
        "                \"resource_type_chain\": [\n" +
        "                    {\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    },\n" +
        "                    {\n" +
        "                        \"id\": \"repertory\",\n" +
        "                        \"system_id\": \"bk_ci\"\n" +
        "                    }\n" +
        "                ]\n" +
        "            }\n" +
        "        ]\n" +
        "    }\n" +
        "}";

    private String createResource = "{\n" +
        "    \"code\": 0,\n" +
        "    \"message\": \"ok\",\n" +
        "    \"data\": {\n" +
        "        \"resource_creator_actions\": {\n" +
        "            \"config\": [\n" +
        "                {\n" +
        "                    \"actions\": [\n" +
        "                        {\n" +
        "                            \"id\": \"project_view\",\n" +
        "                            \"required\": true\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"id\": \"project_views_manager\",\n" +
        "                            \"required\": false\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"id\": \"repertory_create\",\n" +
        "                            \"required\": false\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"id\": \"credential_create\",\n" +
        "                            \"required\": false\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"id\": \"environment_create\",\n" +
        "                            \"required\": false\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"id\": \"env_node_create\",\n" +
        "                            \"required\": false\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"id\": \"cert_create\",\n" +
        "                            \"required\": false\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"id\": \"rule_create\",\n" +
        "                            \"required\": false\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"id\": \"quality_group_create\",\n" +
        "                            \"required\": false\n" +
        "                        }\n" +
        "                    ],\n" +
        "                    \"id\": \"project\",\n" +
        "                    \"sub_resource_types\": [\n" +
        "                        {\n" +
        "                            \"actions\": [\n" +
        "                                {\n" +
        "                                    \"id\": \"pipeline_view\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"pipeline_edit\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"pipeline_download\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"pipeline_delete\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"pipeline_share\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"pipeline_execute\",\n" +
        "                                    \"required\": false\n" +
        "                                }\n" +
        "                            ],\n" +
        "                            \"id\": \"pipeline\"\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"actions\": [\n" +
        "                                {\n" +
        "                                    \"id\": \"repertory_view\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"repertory_edit\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"repertory_delete\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"repertory_use\",\n" +
        "                                    \"required\": false\n" +
        "                                }\n" +
        "                            ],\n" +
        "                            \"id\": \"repertory\"\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"actions\": [\n" +
        "                                {\n" +
        "                                    \"id\": \"credential_view\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"credential_edit\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"credential_delete\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"credential_use\",\n" +
        "                                    \"required\": false\n" +
        "                                }\n" +
        "                            ],\n" +
        "                            \"id\": \"credential\"\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"actions\": [\n" +
        "                                {\n" +
        "                                    \"id\": \"environment_view\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"environment_edit\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"environment_delete\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"environment_use\",\n" +
        "                                    \"required\": false\n" +
        "                                }\n" +
        "                            ],\n" +
        "                            \"id\": \"environment\"\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"actions\": [\n" +
        "                                {\n" +
        "                                    \"id\": \"env_node_view\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"env_node_edit\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"env_node_delete\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"env_node_use\",\n" +
        "                                    \"required\": false\n" +
        "                                }\n" +
        "                            ],\n" +
        "                            \"id\": \"env_node\"\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"actions\": [\n" +
        "                                {\n" +
        "                                    \"id\": \"cert_view\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"cert_edit\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"cert_delete\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"cert_use\",\n" +
        "                                    \"required\": false\n" +
        "                                }\n" +
        "                            ],\n" +
        "                            \"id\": \"cert\"\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"actions\": [\n" +
        "                                {\n" +
        "                                    \"id\": \"quality_group_delete\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"quality_group_edit\",\n" +
        "                                    \"required\": false\n" +
        "                                }\n" +
        "                            ],\n" +
        "                            \"id\": \"quality_group\"\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"actions\": [\n" +
        "                                {\n" +
        "                                    \"id\": \"rule_delete\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"rule_edit\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"rule_enable\",\n" +
        "                                    \"required\": false\n" +
        "                                }\n" +
        "                            ],\n" +
        "                            \"id\": \"rule\"\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"actions\": [\n" +
        "                                {\n" +
        "                                    \"id\": \"experience_group_delete\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"experience_group_edit\",\n" +
        "                                    \"required\": false\n" +
        "                                }\n" +
        "                            ],\n" +
        "                            \"id\": \"experience_group\"\n" +
        "                        },\n" +
        "                        {\n" +
        "                            \"actions\": [\n" +
        "                                {\n" +
        "                                    \"id\": \"experience_task_delete\",\n" +
        "                                    \"required\": false\n" +
        "                                },\n" +
        "                                {\n" +
        "                                    \"id\": \"experience_task_edit\",\n" +
        "                                    \"required\": false\n" +
        "                                }\n" +
        "                            ],\n" +
        "                            \"id\": \"experience_task\"\n" +
        "                        }\n" +
        "                    ]\n" +
        "                }\n" +
        "            ],\n" +
        "            \"mode\": \"system\"\n" +
        "        }\n" +
        "    }\n" +
        "}";

    private String actions = "{\n" +
        "    \"code\": 0,\n" +
        "    \"message\": \"ok\",\n" +
        "    \"data\": {\n" +
        "        \"actions\": [\n" +
        "            {\n" +
        "                \"id\": \"project_view\",\n" +
        "                \"name\": \"查看项目\",\n" +
        "                \"name_en\": \"Project View\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"type\": \"view\",\n" +
        "                \"version\": 1,\n" +
        "                \"related_resource_types\": [\n" +
        "                    {\n" +
        "                        \"system_id\": \"bk_ci\",\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"name_alias\": \"\",\n" +
        "                        \"name_alias_en\": \"\",\n" +
        "                        \"selection_mode\": \"instance\",\n" +
        "                        \"instance_selections\": [\n" +
        "                            {\n" +
        "                                \"id\": \"project_instance\",\n" +
        "                                \"ignore_iam_path\": false,\n" +
        "                                \"is_dynamic\": false,\n" +
        "                                \"name\": \"项目视图\",\n" +
        "                                \"name_en\": \"project instance selection\",\n" +
        "                                \"resource_type_chain\": [\n" +
        "                                    {\n" +
        "                                        \"id\": \"project\",\n" +
        "                                        \"system_id\": \"bk_ci\"\n" +
        "                                    }\n" +
        "                                ],\n" +
        "                                \"system_id\": \"bk_ci\"\n" +
        "                            }\n" +
        "                        ]\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"related_actions\": null,\n" +
        "                \"related_environments\": null\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"project_views_manager\",\n" +
        "                \"name\": \"项目视图管理\",\n" +
        "                \"name_en\": \"Project Views Manager\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"type\": \"edit\",\n" +
        "                \"version\": 1,\n" +
        "                \"related_resource_types\": [\n" +
        "                    {\n" +
        "                        \"system_id\": \"bk_ci\",\n" +
        "                        \"id\": \"project\",\n" +
        "                        \"name_alias\": \"\",\n" +
        "                        \"name_alias_en\": \"\",\n" +
        "                        \"selection_mode\": \"instance\",\n" +
        "                        \"instance_selections\": [\n" +
        "                            {\n" +
        "                                \"id\": \"project_instance\",\n" +
        "                                \"ignore_iam_path\": false,\n" +
        "                                \"is_dynamic\": false,\n" +
        "                                \"name\": \"项目视图\",\n" +
        "                                \"name_en\": \"project instance selection\",\n" +
        "                                \"resource_type_chain\": [\n" +
        "                                    {\n" +
        "                                        \"id\": \"project\",\n" +
        "                                        \"system_id\": \"bk_ci\"\n" +
        "                                    }\n" +
        "                                ],\n" +
        "                                \"system_id\": \"bk_ci\"\n" +
        "                            }\n" +
        "                        ]\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"related_actions\": [\n" +
        "                    \"project_view\"\n" +
        "                ],\n" +
        "                \"related_environments\": null\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"pipeline_view\",\n" +
        "                \"name\": \"查看流水线\",\n" +
        "                \"name_en\": \"Pipeline View\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"type\": \"view\",\n" +
        "                \"version\": 1,\n" +
        "                \"related_resource_types\": [\n" +
        "                    {\n" +
        "                        \"system_id\": \"bk_ci\",\n" +
        "                        \"id\": \"pipeline\",\n" +
        "                        \"name_alias\": \"\",\n" +
        "                        \"name_alias_en\": \"\",\n" +
        "                        \"selection_mode\": \"instance\",\n" +
        "                        \"instance_selections\": [\n" +
        "                            {\n" +
        "                                \"id\": \"pipeline_instance\",\n" +
        "                                \"ignore_iam_path\": false,\n" +
        "                                \"is_dynamic\": false,\n" +
        "                                \"name\": \"流水线视图\",\n" +
        "                                \"name_en\": \"pipeline instance selection\",\n" +
        "                                \"resource_type_chain\": [\n" +
        "                                    {\n" +
        "                                        \"id\": \"project\",\n" +
        "                                        \"system_id\": \"bk_ci\"\n" +
        "                                    },\n" +
        "                                    {\n" +
        "                                        \"id\": \"pipeline\",\n" +
        "                                        \"system_id\": \"bk_ci\"\n" +
        "                                    }\n" +
        "                                ],\n" +
        "                                \"system_id\": \"bk_ci\"\n" +
        "                            }\n" +
        "                        ]\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"related_actions\": null,\n" +
        "                \"related_environments\": null\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"repertory_view\",\n" +
        "                \"name\": \"查看代码库\",\n" +
        "                \"name_en\": \"Repository View\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"type\": \"view\",\n" +
        "                \"version\": 1,\n" +
        "                \"related_resource_types\": [\n" +
        "                    {\n" +
        "                        \"system_id\": \"bk_ci\",\n" +
        "                        \"id\": \"repertory\",\n" +
        "                        \"name_alias\": \"\",\n" +
        "                        \"name_alias_en\": \"\",\n" +
        "                        \"selection_mode\": \"instance\",\n" +
        "                        \"instance_selections\": [\n" +
        "                            {\n" +
        "                                \"id\": \"repertory_instance\",\n" +
        "                                \"ignore_iam_path\": false,\n" +
        "                                \"is_dynamic\": false,\n" +
        "                                \"name\": \"代码库视图\",\n" +
        "                                \"name_en\": \"repository instance selection\",\n" +
        "                                \"resource_type_chain\": [\n" +
        "                                    {\n" +
        "                                        \"id\": \"project\",\n" +
        "                                        \"system_id\": \"bk_ci\"\n" +
        "                                    },\n" +
        "                                    {\n" +
        "                                        \"id\": \"repertory\",\n" +
        "                                        \"system_id\": \"bk_ci\"\n" +
        "                                    }\n" +
        "                                ],\n" +
        "                                \"system_id\": \"bk_ci\"\n" +
        "                            }\n" +
        "                        ]\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"related_actions\": null,\n" +
        "                \"related_environments\": null\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"cert_edit\",\n" +
        "                \"name\": \"编辑证书\",\n" +
        "                \"name_en\": \"Cert Edit\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"type\": \"edit\",\n" +
        "                \"version\": 1,\n" +
        "                \"related_resource_types\": [\n" +
        "                    {\n" +
        "                        \"system_id\": \"bk_ci\",\n" +
        "                        \"id\": \"cert\",\n" +
        "                        \"name_alias\": \"\",\n" +
        "                        \"name_alias_en\": \"\",\n" +
        "                        \"selection_mode\": \"instance\",\n" +
        "                        \"instance_selections\": [\n" +
        "                            {\n" +
        "                                \"id\": \"cert_instance\",\n" +
        "                                \"ignore_iam_path\": false,\n" +
        "                                \"is_dynamic\": false,\n" +
        "                                \"name\": \"证书视图\",\n" +
        "                                \"name_en\": \"cert instance selection\",\n" +
        "                                \"resource_type_chain\": [\n" +
        "                                    {\n" +
        "                                        \"id\": \"project\",\n" +
        "                                        \"system_id\": \"bk_ci\"\n" +
        "                                    },\n" +
        "                                    {\n" +
        "                                        \"id\": \"cert\",\n" +
        "                                        \"system_id\": \"bk_ci\"\n" +
        "                                    }\n" +
        "                                ],\n" +
        "                                \"system_id\": \"bk_ci\"\n" +
        "                            }\n" +
        "                        ]\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"related_actions\": [\n" +
        "                    \"project_view\",\n" +
        "                    \"cert_view\"\n" +
        "                ],\n" +
        "                \"related_environments\": null\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"quality_group_delete\",\n" +
        "                \"name\": \"删除质量红线通知组\",\n" +
        "                \"name_en\": \"Group Delete\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"type\": \"delete\",\n" +
        "                \"version\": 1,\n" +
        "                \"related_resource_types\": [\n" +
        "                    {\n" +
        "                        \"system_id\": \"bk_ci\",\n" +
        "                        \"id\": \"quality_group\",\n" +
        "                        \"name_alias\": \"\",\n" +
        "                        \"name_alias_en\": \"\",\n" +
        "                        \"selection_mode\": \"instance\",\n" +
        "                        \"instance_selections\": [\n" +
        "                            {\n" +
        "                                \"id\": \"quality_group_rule\",\n" +
        "                                \"ignore_iam_path\": false,\n" +
        "                                \"is_dynamic\": false,\n" +
        "                                \"name\": \"质量红线用户组视图\",\n" +
        "                                \"name_en\": \"quality group instance selection\",\n" +
        "                                \"resource_type_chain\": [\n" +
        "                                    {\n" +
        "                                        \"id\": \"project\",\n" +
        "                                        \"system_id\": \"bk_ci\"\n" +
        "                                    },\n" +
        "                                    {\n" +
        "                                        \"id\": \"quality_group\",\n" +
        "                                        \"system_id\": \"bk_ci\"\n" +
        "                                    }\n" +
        "                                ],\n" +
        "                                \"system_id\": \"bk_ci\"\n" +
        "                            }\n" +
        "                        ]\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"related_actions\": [\n" +
        "                    \"project_view\"\n" +
        "                ],\n" +
        "                \"related_environments\": null\n" +
        "            },\n" +
        "            {\n" +
        "                \"id\": \"quality_group_edit\",\n" +
        "                \"name\": \"编辑质量红线通知组\",\n" +
        "                \"name_en\": \"Group Edit\",\n" +
        "                \"description\": \"\",\n" +
        "                \"description_en\": \"\",\n" +
        "                \"type\": \"edit\",\n" +
        "                \"version\": 1,\n" +
        "                \"related_resource_types\": [\n" +
        "                    {\n" +
        "                        \"system_id\": \"bk_ci\",\n" +
        "                        \"id\": \"quality_group\",\n" +
        "                        \"name_alias\": \"\",\n" +
        "                        \"name_alias_en\": \"\",\n" +
        "                        \"selection_mode\": \"instance\",\n" +
        "                        \"instance_selections\": [\n" +
        "                            {\n" +
        "                                \"id\": \"quality_group_rule\",\n" +
        "                                \"ignore_iam_path\": false,\n" +
        "                                \"is_dynamic\": false,\n" +
        "                                \"name\": \"质量红线用户组视图\",\n" +
        "                                \"name_en\": \"quality group instance selection\",\n" +
        "                                \"resource_type_chain\": [\n" +
        "                                    {\n" +
        "                                        \"id\": \"project\",\n" +
        "                                        \"system_id\": \"bk_ci\"\n" +
        "                                    },\n" +
        "                                    {\n" +
        "                                        \"id\": \"quality_group\",\n" +
        "                                        \"system_id\": \"bk_ci\"\n" +
        "                                    }\n" +
        "                                ],\n" +
        "                                \"system_id\": \"bk_ci\"\n" +
        "                            }\n" +
        "                        ]\n" +
        "                    }\n" +
        "                ],\n" +
        "                \"related_actions\": [\n" +
        "                    \"project_view\"\n" +
        "                ],\n" +
        "                \"related_environments\": null\n" +
        "            }\n" +
        "        ]\n" +
        "    }\n" +
        "}";

    @SneakyThrows
    @Test
    public void test() {
        try {
            ResponseDTO<SystemFieldDTO> responseInfo = JsonUtil.fromJson(resourceType, new TypeReference<ResponseDTO<SystemFieldDTO>>() {
            });
            if (responseInfo != null) {
                SystemFieldDTO data = responseInfo.getData();
                System.out.println("resouceType");
                System.out.println(data.getResourceType());
            }

            ResponseDTO<SystemFieldDTO> actionGroupInfo = JsonUtil.fromJson(actionGroup, new TypeReference<ResponseDTO<SystemFieldDTO>>() {
            });
            if (actionGroupInfo != null) {
                SystemFieldDTO actionGroupData = actionGroupInfo.getData();
                System.out.println("actionGroup");
                System.out.println(actionGroupData.getActionGroup());
            }

            ResponseDTO<SystemFieldDTO> instanceSeleteInfo = JsonUtil.fromJson(instanceSelect, new TypeReference<ResponseDTO<SystemFieldDTO>>() {
            });
            if (instanceSeleteInfo != null) {
                SystemFieldDTO instanceSeleteData = instanceSeleteInfo.getData();
                System.out.println("instanceSelect");
                System.out.println(instanceSeleteData.getInstanceSelections());
            }

            ResponseDTO<SystemFieldDTO> createResourceInfo = JsonUtil.fromJson(createResource, new TypeReference<ResponseDTO<SystemFieldDTO>>() {
            });
            if (createResourceInfo != null) {
                SystemFieldDTO createResourceData = createResourceInfo.getData();
                System.out.println("createResource");
                System.out.println(createResourceData.getResourceCreatorActions());
            }

            ResponseDTO<SystemFieldDTO> actionInfo = JsonUtil.fromJson(actions, new TypeReference<ResponseDTO<SystemFieldDTO>>() {
            });
            if (actionInfo != null) {
                SystemFieldDTO actioneData = actionInfo.getData();
                System.out.println("actions");
                System.out.println(actioneData.getActions());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}