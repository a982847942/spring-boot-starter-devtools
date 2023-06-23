package edu.nuaa.interfaces;

import edu.nuaa.HelloService;
import edu.nuaa.domain.Hi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 20:41
 */
@Controller("helloService")
public class HelloServiceImpl implements HelloService {
    @Override
    public String hi() {
        return "hi zk rpc";
    }

    @Override
    public String say(String str) {
        return str;
    }

    @Override
    public String sayHi(Hi hi) {
        return hi.getUserName() + " say：" + hi.getSayMsg();
    }

}
