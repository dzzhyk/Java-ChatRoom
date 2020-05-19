import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 服务端通讯封装类
 */
public class Channel implements Runnable {

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean isRunning = true;
    private String name;

    @Override
    public void run() {
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            name = recv();  // 获取名字
            ChatUtils.setServerOnlineClients(); // 更新用户列表
            broadCast(name + "加入了聊天室");

            // 退出之后
            Server.getUsers().remove(this);
            ChatUtils.setServerOnlineClients(); // 更新用户列表
            broadCast(name + "退出了聊天室");
        }catch (IOException e){
            e.printStackTrace();
            release();
        }
    }

    /**
     * 接收
     */
    private String recv(){
        String msg = "";
        try {
            msg = dis.readUTF();
            System.out.println("server接收");
        }catch (Exception e){
            release();
        }
        return msg;
    }






    public Channel(Socket socket) {
        this.socket = socket;
    }

    public String getName() {
        return name;
    }


}
