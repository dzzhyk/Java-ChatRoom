import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 客户端写
 */
public class ClientWrite implements Runnable {

    private Socket socket;
    private DataOutputStream dos;
    private ClientFrame frame;
    private String name;

    @Override
    public void run() {
        try {
            dos = new DataOutputStream(socket.getOutputStream());

            // 首先发送信息
            send(name);
            String msg = frame.getTextArea2().getText();
            send(msg);
            // 清空发送区
            frame.getTextArea2().setText("");
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
    }

    public ClientWrite(ClientFrame frame, String name) {
        try {
            this.socket = new Socket("localhost", 8887);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.frame = frame;
        this.name = name;
    }

}
