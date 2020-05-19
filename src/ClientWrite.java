import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 客户端写
 */
public class ClientWrite implements Runnable {

    private Socket socket;
    private DataOutputStream dos;
    private boolean isRunning = true;
    private ClientFrame frame;
    private String name;

    @Override
    public void run() {
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            String msg = frame.getTextArea2().getText();
            send(msg);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release();
        }
    }

    /**
     * 发送消息
     */
    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        }catch (IOException e){
            e.printStackTrace();
            release();
        }
    }

    /**
     * 回收资源
     */
    private void release(){
        ChatUtils.close(socket, dos);
        isRunning = false;
    }

    public ClientWrite(Socket socket, ClientFrame frame, String name) {
        this.socket = socket;
        this.frame = frame;
        this.name = name;
    }

}
