package com.eric.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description TCP客户端
 * @Date 2019/3/31 18:04
 * @Author LSM
 **/
public class TCPClient {

    public static void main(String[] args) throws Exception {

        //创建socket并指定连接的地址和端口
        Socket socket = new Socket("127.0.0.1", 65000);
        //获取socket的输出流
        OutputStream os = socket.getOutputStream();
        //获取socket的输入流
        InputStream is = socket.getInputStream();
        //把要计算过的字符串写给服务端
        os.write(new String("hello world").getBytes());
        //存储byte数组长度
        int ch;
        //存储数据内容
        byte[] buff = new byte[1024];
        //得到数组长度
        ch = is.read(buff);
        //把内容转成字符串
        String content = new String(buff,0,ch);
        System.out.println("client content:" + content);
        //关闭输入流和输出流
        is.close();
        os.close();
        //关闭socket
        socket.close();
    }
}
