import java.io.*;
import java.net.ServerSocket;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务端 - 用单例模式
 */
public class Server {

    public static final Server INSTANCE = new Server();
    private static ServerFrame frame = new ServerFrame();
    // 读端口 8887
    private static ServerSocket serverSocketRead;
    // 写端口 8888
    private static ServerSocket serverSocketWrite;
    private static CopyOnWriteArrayList<Channel> users;
    public static ExecutorService POOL;

    private Server(){
        try {
            serverSocketRead = new ServerSocket(8887);
            serverSocketWrite = new ServerSocket(8888);
            POOL = Executors.newFixedThreadPool(10);
            users = new CopyOnWriteArrayList<>();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void listen(){
        new Thread(new ServerRead(serverSocketRead)).start();
        new Thread(new ServerWrite(serverSocketWrite)).start();
    }

    public static CopyOnWriteArrayList<Channel> getUsers() {
        return users;
    }

    public static ServerFrame getFrame() {
        return frame;
    }
}
