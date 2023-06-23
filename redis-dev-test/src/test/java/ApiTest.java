import edu.nuaa.middleware.test.ApiTestApplication;
import edu.nuaa.middleware.test.service.IRedisService;
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
 * @date 2023/6/23 13:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApiTestApplication.class})
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    private IRedisService redisService;//基本就是RedisTemplate的功能

    @Test
    public void test_set() {
        redisService.set("key_info_user", "刀下生，刀下死！");
    }

    @Test
    public void test_get() {
        String result = redisService.get("key_info_user");
        logger.info("获取 Redis key：{} 信息：{}", "b_info_user", result);
    }

}
