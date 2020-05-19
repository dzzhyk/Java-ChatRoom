import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * server写线程 8888
 */
public class ServerWrite implements Runnable {

    private Socket socket;
    private DataOutputStream dos;
    private String host;
    private int port;
    private String msg;

    @Override
    public void run() {
        send(msg);
    }

    /**
     * 发送
     */
    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
            System.out.println("Server==>"+host+"@"+port);
        }catch (Exception e){

        }finally {
            release();
        }
    }

    /**
     * 回收资源
     */
    private void release(){
        ChatUtils.close(socket, dos);
    }

    public ServerWrite(String host, int port, String msg) {
        this.host = host;
        this.port = port;
        this.msg = msg;
        try {
            this.socket = new Socket(host, port);
            this.dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
