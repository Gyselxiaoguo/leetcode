package io.BIO.one;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        try {
            // 1、定义一个ServerSocket对象进行服务端的端口注册
            ServerSocket ss = new ServerSocket(9999);
            //2、监听客户端的Socket链接请求
            Socket socket = ss.accept();
            // 3、从socket管道中得到一个字节输入流对象
            InputStream is = socket.getInputStream();
            //4、把字节输入流包装成一个缓冲字符输入流
            InputStreamReader isr = new InputStreamReader(is);  //字节转字符
            BufferedReader br = new BufferedReader(isr);    //一次性读取一大块数据放到内存缓冲区
            String msg;
            if((msg = br.readLine()) != null) {
                System.out.println("服务端接收到:" + msg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
