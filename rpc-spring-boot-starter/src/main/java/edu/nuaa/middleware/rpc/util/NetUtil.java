package edu.nuaa.middleware.rpc.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/21 16:27
 */
public class NetUtil {
    public static boolean isPortUsing(int port) throws UnknownHostException {
        boolean flag = false;
        try {
            Socket socket = new Socket("localhost", port);
            socket.close();
            flag = true;
        } catch (IOException e) {

        }
        return flag;
    }

    public static String getHost() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }

    public static void main(String[] args) throws UnknownHostException {
        NetUtil.isPortUsing(8080);
    }

}
