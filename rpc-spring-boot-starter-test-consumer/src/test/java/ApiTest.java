import edu.nuaa.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 20:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    private HelloService helloService;

    @Test
    public void hi() {
        String hi = helloService.hi();
        logger.info("测试结果：{}", hi);
    }

}
