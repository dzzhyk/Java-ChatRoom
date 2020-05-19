import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * server写线程 8888
 */
public class ServerWrite implements Runnable {

    private ServerSocket serverSocket;
    private DataOutputStream dos;

    @Override
    public void run() {
        try {
            dos = new DataOutputStream(ss.getOutputStream());

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 发送
     */
    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
            System.out.println("server发送");
        }catch (Exception e){
            release();
        }
    }

    // 系统消息
    public void broadCast(String msg){
        for (Channel user : Server.getUsers()) {
            user.send("<系统消息>: " + msg);
        }
    }

    /**
     * 回收资源
     */
    private void release(){
        ChatUtils.close(serverSocket, dos);
    }

    public ServerWrite(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
}
