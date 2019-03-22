package com.bug.itoken.web.admin.service.fallback;

import com.bug.itoken.common.constants.HttpStatusConstants;
import com.bug.itoken.common.dto.BaseResult;
import com.bug.itoken.common.utils.MapperUtils;
import com.bug.itoken.web.admin.service.AdminService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceFallback implements AdminService {
    @Override
    public String login(String loginCode, String password) {
        String result=null;
        BaseResult baseResult = BaseResult.notOk(Lists.newArrayList(
                new BaseResult.Error(
                        HttpStatusConstants.BAD_GATEWAY.getStatus(),
                        HttpStatusConstants.BAD_GATEWAY.getContent()
                )
        ));
        try {
            result = MapperUtils.obj2json(baseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
