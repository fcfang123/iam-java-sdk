package com.tencent.bk.sdk.iam.dto.callback.request;

import static com.tencent.bk.sdk.iam.constants.ParentType.CMDB_BUSINESS;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author citruswang
 * @since 27/5/2020 15:11
 */
@Data
@Slf4j
public class IamSearchCondition {
    private List<String> idList;

    private List<Long> appIdList;

    private Map<String, List<String>> attribute;

    private Long start;

    private Long length;

    public static IamSearchCondition fromReq(CallbackRequestDTO request) {
        IamSearchCondition condition = new IamSearchCondition();
        if (request.getFilter() != null) {
            FilterDTO filter = request.getFilter();
            if (filter.getParent() != null) {
                if (CMDB_BUSINESS.equals(filter.getParent().getType())) {
                    try {
                        condition.setAppIdList(Collections.singletonList(Long.valueOf(filter.getParent().getId())));
                    } catch (NumberFormatException e) {
                        log.warn("Error while parse app id!|{}", filter.getParent());
                    }
                } else {
                    condition.setAttribute(new ConcurrentHashMap<>(1));
                    condition.getAttribute().put(filter.getParent().getType(),
                            Collections.singletonList(filter.getParent().getId()));
                }
            }
            if (filter.getIdList() != null) {
                condition.setIdList(filter.getIdList().parallelStream().map(String::valueOf).collect(Collectors.toList()));
            }
        }
        if (request.getPage() != null) {
            condition.setStart(request.getPage().getOffset());
            condition.setLength(request.getPage().getLimit());
        } else {
            condition.setStart(0L);
            condition.setLength(10L);
        }
        return condition;
    }
}
