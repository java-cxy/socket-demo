package com.eric.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Description UDP服务端
 * @Date 2019/3/31 20:05
 * @Author LSM
 **/
public class UDPServer {

    public static void main(String[] args) throws Exception {

        System.out.println("-------------is coming-------------");

        //创建socket并绑定端口号
        DatagramSocket socket = new DatagramSocket(65001);
        //创建byte数组存储客户端发来的数据
        byte[] buff = new byte[1024];
        //接收客户端发来的内容并封装到packet中
        DatagramPacket packet = new DatagramPacket(buff,buff.length);
        socket.receive(packet);

        //从packet封装中读取客户端数据
        byte[] data = packet.getData();
        String content = new String(data,0,packet.getLength());
        System.out.println("UPDServer content:" + content);

        //将返回客户端的数据转成二进制
        byte[] sendContent = String.valueOf(content.length()).getBytes();

        //从packet中获取客户端的地址和端口并把发送内容封装到packetToClient中
        DatagramPacket packetToClient = new DatagramPacket(sendContent,sendContent.length,
                packet.getAddress(),packet.getPort());
        //发送数据给客户端
        socket.send(packetToClient);

        //关闭socket
        socket.close();

    }
}
