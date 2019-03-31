package com.eric.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LengthCalculator extends Thread{

    private final Socket socket;

    public LengthCalculator(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            //获取socket输出流
            OutputStream os = socket.getOutputStream();
            //获取socket的输入流
            InputStream is = socket.getInputStream();
            //存储byte数组的长度
            int ch;
            //用来存储客户端发来的内容
            byte[] buff = new byte[1024];
            //读取客户端发送的数据并存进buff中，然后读取byte的长度
            ch = is.read(buff);
            //将接收流的byte数组转成字符串，这里获取的内容是客户端发送过来的字符串参数
            String content = new String(buff,0, ch);
            System.out.println("server content: " + content);
            //往输出流里写入获取到的字符长度并返回给客户端
            os.write(String.valueOf(content.length()).getBytes());
            //关闭输入流和输出流
            is.close();
            os.close();
            //关闭socket
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
