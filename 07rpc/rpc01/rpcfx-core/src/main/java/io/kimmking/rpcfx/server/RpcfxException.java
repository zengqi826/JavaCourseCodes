package io.kimmking.rpcfx.server;

/**
 * RpcfxException
 *
 * @author zengqi
 * @date 2021/8/16 9:04
 */
public class RpcfxException extends Exception {
    public RpcfxException(Throwable cause) {
        super(cause);
    }


    public RpcfxException(String message, Throwable cause) {
        super(message, cause);
    }
}
