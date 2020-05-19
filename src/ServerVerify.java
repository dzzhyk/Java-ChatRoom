import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 验证端接受线程
 * 规定：host为exit字样时代表退出
 */
public class ServerVerify implements Runnable {

    private ServerSocket serverSocket;

    @Override
    public void run() {
        try {

            while (true){
                Socket ss = serverSocket.accept();
                DataInputStream dis = new DataInputStream(ss.getInputStream());
                String host = dis.readUTF();
                int port = dis.readInt();
                String name = dis.readUTF();
                String msg;
                if (!"exit".equals(host)){
                    // 如果发来的host不是退出消息
                    System.out.println("接收到登录请求==>" + host + "@"+port+":"+ name);
                    Server.addUser(new Channel(host, port, name));
                    msg = "<SYSTEM>: " + name + "加入了聊天室";
                }else {
                    // 移除用户
                    Server.removeUser(name);
                    System.out.println("用户登出==>" + host + "@"+port+":"+ name);
                    // 打印退出信息
                    msg = "<SYSTEM>: " + name + "退出了聊天室";
                }
                // 广播欢迎信息
                ChatUtils.broadCast(msg);
                // 刷新用户列表
                Server.flushUsers();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ServerVerify(){
        try {
            this.serverSocket = new ServerSocket(8889);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
