package com.bug.itoken.web.admin.service;

import com.bug.itoken.web.admin.service.fallback.AdminServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "itoken-service-admin",fallback = AdminServiceFallback.class)
public interface AdminService {

    @RequestMapping(value = "login",method = RequestMethod.GET)
    String login(@RequestParam("loginCode") String loginCode,@RequestParam("password") String password);
}
