import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端接受信息
 */
public class ServerRead implements Runnable {

    private ServerSocket serverSocket;

    @Override
    public void run() {
        try {
            while (true){
                Socket ss = serverSocket.accept();
                System.out.println("--来了一个新的客户端--");
                Channel channel = new Channel(ss);
                Server.getUsers().add(channel);
                // 提交线程
                Server.POOL.submit(channel);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ServerRead(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
}
