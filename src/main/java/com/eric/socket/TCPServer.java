package com.eric.socket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description TCP服务端
 * @Date 2019/3/31 14:24
 * @Author LSM
 **/
public class TCPServer {

    public static void main(String[] args) throws Exception {

        //创建socket并绑定socket的端口号
        ServerSocket ss = new ServerSocket(65000);
        //用死循环使的socket一直等待客户端的连接请求
        while (true){
            //接收客户端发送的连接请求，并返回连接是否成功
            Socket socket = ss.accept();
            //处理客户端请求过来的数据的线程，执行相关的业务操作
            new LengthCalculator(socket).start();
        }
    }
}
