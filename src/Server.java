import java.io.*;
import java.net.ServerSocket;
import java.util.concurrent.CopyOnWriteArraySet;
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
    private static CopyOnWriteArraySet<Channel> users;
    public static ExecutorService POOL;

    private Server(){
        try {
            serverSocketRead = new ServerSocket(8887);
            POOL = Executors.newFixedThreadPool(10);
            users = new CopyOnWriteArraySet<>();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void listen(){
        new Thread(new ServerVerify()).start(); // 验证监听线程
        new Thread(new ServerRead(serverSocketRead, frame)).start();
    }

    public static CopyOnWriteArraySet<Channel> getUsers() {
        return users;
    }

    public static void addUser(Channel channel){
        users.add(channel);
    }

    public static void removeUser(String name){
        for (Channel user : users) {
            if (name.equals(user.getName())){
                users.remove(user);
                break;
            }
        }
    }

    public static ServerFrame getFrame() {
        return frame;
    }

    /**
     * 刷新服务器端的用户列表
     */
    public static void flushUsers(){
        frame.getTextArea2().setText(ChatUtils.genUserList(users));
    }

    /**
     * 发送服务端通知消息
     */
    public static void sendServerMsg(String msg){
        msg = "<SYSTEM>消息: " + msg;
        ChatUtils.broadCast(msg);
        // 服务端也输出
        System.out.println(msg);
    }
}
