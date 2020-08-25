package chat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author admin_cg
 * @date 2020/8/6 14:40
 */
public class TcpClientDemo01 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        try{
            // 1. 查找服务器地址
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            // 2. 创建一个socket连接
            socket = new Socket(serverIP, port);
            // 3.发送消息IO流
            os = socket.getOutputStream();
            os.write("Hello Welcome!".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(os != null) {
                try{
                    os.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try{
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
