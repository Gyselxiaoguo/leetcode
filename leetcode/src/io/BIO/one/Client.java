package io.BIO.one;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        // 1. 创建客户端Socket，连接本机9999端口的服务端
        Socket socket = new Socket("127.0.0.1", 9999);

        // 2. 获取输出流，和服务端对称包装
        OutputStream os = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);    //字节流转字符流
        BufferedWriter bw = new BufferedWriter(osw);

        // 3. 发送一行文字
        bw.write("Hello Socket通信");
        bw.newLine(); // 换行，让服务端readLine可以读到结束
        bw.flush();   // 强制把缓冲区内容发送出去

        // 4. 关闭资源
        socket.close();
    }
}