package edu.nuaa.middleware.test.interfaces;

import edu.nuaa.middleware.test.infrastructure.dao.IUserDao;
import edu.nuaa.middleware.test.infrastructure.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author brain
 * @version 1.0
 * @date 2023/12/30 16:17
 */
@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private IUserDao userDao;

    @RequestMapping(path = "/api/queryUserInfoById", method = RequestMethod.GET)
    public User queryUserInfoById(){
        return userDao.queryUserInfoByUserId(new User("980765512"));
    }

}
