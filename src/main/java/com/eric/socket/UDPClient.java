package com.eric.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Description UDP客户端
 * @Date 2019/3/31 20:25
 * @Author LSM
 **/
public class UDPClient {

    public static void main(String[] args) throws Exception {

        //创建socket
        DatagramSocket socket = new DatagramSocket();
        //发送给服务端的数据
        byte[] buff = "hello world".getBytes();
        //封装ip地址
        InetAddress address = InetAddress.getByName("127.0.0.1");
        //封装发送数据包
        DatagramPacket packet = new DatagramPacket(buff,buff.length,address,65001);
        //发送数据
        socket.send(packet);

        //接收服务端返回的数据
        byte[] data = new byte[1024];
        //receivedPacket存储服务端返回的数据封装
        DatagramPacket receivedPacket = new DatagramPacket(data,data.length);
        //把数据封装到receivedPacket中
        socket.receive(receivedPacket);
        //把数据转成字符串
        String content = new String(receivedPacket.getData(),0,receivedPacket.getLength());
        System.out.println("content: " + content);

        //关闭socket
        socket.close();
    }
}
