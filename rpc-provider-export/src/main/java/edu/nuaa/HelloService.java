package edu.nuaa;

import edu.nuaa.domain.Hi;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 20:21
 */
public interface HelloService {
    String hi();

    String say(String str);

    String sayHi(Hi hi);

}
