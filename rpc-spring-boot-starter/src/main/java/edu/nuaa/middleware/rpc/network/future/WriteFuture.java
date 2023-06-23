package edu.nuaa.middleware.rpc.network.future;

import edu.nuaa.middleware.rpc.network.msg.Response;

import java.util.concurrent.Future;


/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 15:55
 */
public interface WriteFuture<T> extends Future<T> {
    Throwable cause();

    void setCause(Throwable cause);

    boolean isWriteSuccess();

    void setWriteResult(boolean result);

    String requestId();

    T response();

    void setResponse(Response response);

    boolean isTimeout();

}
