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


import com.tencent.bk.sdk.iam.constants.ExpressionOperationEnum;
import com.tencent.bk.sdk.iam.dto.InstanceDTO;
import com.tencent.bk.sdk.iam.dto.PathInfoDTO;
import com.tencent.bk.sdk.iam.dto.expression.ExpressionDTO;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthHelperTest {

	@Test
	public void calculateExpression() {
		Map<String, InstanceDTO> instanceMap = new HashMap<>(2);
		ExpressionDTO ExpressionDTO = new ExpressionDTO();
		InstanceDTO instanceDTO1 = new InstanceDTO();
		PathInfoDTO pathInfoDTO = new PathInfoDTO();
		pathInfoDTO.setType("project");
		pathInfoDTO.setId("v3test");
		instanceDTO1.setType("pipeline");
		instanceDTO1.setId("p-0d1fff4dabca4fc282e5ff63644bd339");
		instanceDTO1.setPath(pathInfoDTO);
		System.out.println(instanceDTO1);
		instanceMap.put(instanceDTO1.getType(), instanceDTO1);

		List<ExpressionDTO> content = new ArrayList<>();
		ExpressionDTO content1 = new ExpressionDTO();
		content1.setOperator(ExpressionOperationEnum.START_WITH);
		content1.setField("pipeline._bk_iam_path_");
		content1.setValue("/project,demo/pipeline,p-098b68a251ae4ec4b6f4fde87767387f/");

		ExpressionDTO content2 = new ExpressionDTO();
		content2.setOperator(ExpressionOperationEnum.START_WITH);
		content2.setField("pipeline._bk_iam_path_");
		content2.setValue("/project,demo/pipeline,p-12b2c343109f43a58a79dcb9e3721c1b/");

		ExpressionDTO content3 = new ExpressionDTO();
		content3.setOperator(ExpressionOperationEnum.START_WITH);
		content3.setField("pipeline._bk_iam_path_");
		content3.setValue("/project,v3test/pipeline,p-0d1fff4dabca4fc282e5ff63644bd339/");

		ExpressionDTO content4 = new ExpressionDTO();
		content4.setOperator(ExpressionOperationEnum.START_WITH);
		content4.setField("pipeline._bk_iam_path_");
		content4.setValue("/project,v3test/pipeline,p-54fb8b6562584df4b3693f7c787c105a/");

		content.add(content1);
		content.add(content2);
		content.add(content3);
		content.add(content4);

		ExpressionDTO.setField(null);
		ExpressionDTO.setOperator(ExpressionOperationEnum.OR);
		ExpressionDTO.setContent(content);

		Boolean isallow = AuthHelper.calculateExpression(instanceMap, ExpressionDTO);
		System.out.println(isallow);
	}

	/** ExpressionDTO(operator=AND, field=null, value=null, content=[
	 * 		ExpressionDTO(operator=IN, field=pipeline.id, value=[p-397e11330be143378bd39eb26358dcf8, p-cbb155c4b0b245e2adba872b73873558], content=null),
	 * 		ExpressionDTO(operator=START_WITH, field=pipeline._bk_iam_path_, value=/project,froms/, content=null)]
	 * 		)
	 *
	 */
	@Test
	public void calculateExpression1() {
		ExpressionDTO expressionDTO = new ExpressionDTO();
		expressionDTO.setOperator(ExpressionOperationEnum.AND);

		ExpressionDTO childExpression1 = new ExpressionDTO();
		ExpressionDTO childExpression2 = new ExpressionDTO();
		childExpression1.setOperator(ExpressionOperationEnum.IN);
		childExpression1.setField("pipeline.id");
		List<String> pipelineId = new ArrayList<>();
		pipelineId.add("p-397e11330be143378bd39eb26358dcf8");
		pipelineId.add("p-cbb155c4b0b245e2adba872b73873558");
		childExpression1.setValue(pipelineId);

		childExpression2.setOperator(ExpressionOperationEnum.START_WITH);
		childExpression2.setField("pipeline._bk_iam_path_");
		childExpression2.setValue("/project,froms/");

		List<ExpressionDTO> content = new ArrayList<>();
		content.add(childExpression1);
		content.add(childExpression2);
		expressionDTO.setContent(content);

//		InstanceDTO instanceDTO = new InstanceDTO();
//		instanceDTO.setId("p-cbb155c4b0b245e2adba872b73873558");
//		instanceDTO.setSystem("bk_ci");
//		instanceDTO.setType("project");
//		PathInfoDTO pathInfoDTO = new PathInfoDTO();
//		pathInfoDTO.setType("project");
//		pathInfoDTO.setId("froms");
//		instanceDTO.setPath(pathInfoDTO);
//		Map<String, InstanceDTO> instanceMap1 = new HashMap<>(1);
//		instanceMap1.put(instanceDTO.getType(), instanceDTO);
//		Boolean isallow = AuthHelper.calculateExpression(instanceMap1, expressionDTO);
//
		Map<String, InstanceDTO> instanceMap2 = new HashMap<>(1);

		InstanceDTO instanceDTO1 = new InstanceDTO();
		instanceDTO1.setId("p-cbb155c4b0b245e2adba872b73873558");
		instanceDTO1.setSystem("bk_ci");
		instanceDTO1.setType("pipeline");
		PathInfoDTO pathInfoDTO1 = new PathInfoDTO();
		pathInfoDTO1.setType("project");
		pathInfoDTO1.setId("froms");
		instanceDTO1.setPath(pathInfoDTO1);
		instanceMap2.put(instanceDTO1.getType(), instanceDTO1);
		System.out.println("instance:" + instanceMap2);
		System.out.println("exp:" + expressionDTO);
		Boolean isallow1 = AuthHelper.calculateExpression(instanceMap2, expressionDTO);
		System.out.println(isallow1);
	}
}
