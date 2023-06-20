package edu.nuaa.controller;

import edu.nuaa.domain.UserInfo;
import edu.nuaa.middleware.whitelist.annotation.DoWhiteList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/19 10:37
 */
@RestController
public class HelloWorldController {
    //    @DoDoor(key = "userId", returnJson = "{\"code\":\"1111\",\"info\":\"非白名单可访问用户拦截！\"}")
    @DoWhiteList(key = "userId",returnJson = "{\"code\":\"1111\",\"info\":\"非白名单可访问用户拦截！\"}")
    @RequestMapping(path = "/api/queryUserInfo", method = RequestMethod.GET)
    public UserInfo queryUserInfo(@RequestParam String userId) {
        System.out.println("userId:" + userId);
        return new UserInfo("虫虫:" + userId, 19, "天津市南开区旮旯胡同100号");
    }

}
