package edu.nuaa.test;

import com.alibaba.fastjson.JSON;
import edu.nuaa.middleware.test.ApiTestApplication;
import edu.nuaa.middleware.test.infrastructure.dao.IUserDao;
import edu.nuaa.middleware.test.infrastructure.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author brain
 * @version 1.0
 * @date 2023/12/30 16:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiTestApplication.class)
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    private IUserDao userDao;

    @Test
    public void test_queryUserInfoByUserId() {
        User user = userDao.queryUserInfoByUserId(new User("980765512"));
        logger.info("测试结果：{}", JSON.toJSONString(user));
    }

    @Test
    public void test_insertUser() {
        User user = new User();
        user.setUserId("980765512");
        user.setUserNickName("brain");
        user.setUserHead("01_50");
        user.setUserPassword("123456");

        userDao.insertUser(user);
    }

}
