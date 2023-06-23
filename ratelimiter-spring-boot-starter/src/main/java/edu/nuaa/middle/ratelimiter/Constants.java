package edu.nuaa.middle.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 9:42
 */
public class Constants {
    public static Map<String, RateLimiter> rateLimiterMap = Collections.synchronizedMap(new HashMap<String, RateLimiter>());
}
