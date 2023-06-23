package edu.nuaa.middleware.rpc.network.future;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 15:54
 */
public class SyncWriteMap {
    public static Map<String, WriteFuture> syncKey = new ConcurrentHashMap<String, WriteFuture>();
}
