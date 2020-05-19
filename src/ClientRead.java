import java.io.*;
import java.net.Socket;

/**
 * 客户端读
 */
public class ClientRead implements Runnable {

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean isRunning = true;
    private ClientFrame frame;
    private GuiOutputStream gos;
    private String name;

    @Override
    public void run() {
        System.setOut(gos);
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            // 在开始读之前发送自身信息
            dos.writeUTF(name);
            dos.flush();
            // 之后就一直接受信息
            while (isRunning){
                recv();
            }
        }catch (IOException e){
            e.printStackTrace();
            release();
        }
    }

    public void recv(){
        try {
            String s = dis.readUTF();
            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
            release();
        }
    }

    /**
     * 回收资源
     */
    private void release(){
        ChatUtils.close(socket, dis);
        isRunning = false;
    }

    public ClientRead(Socket socket, ClientFrame frame, String name) {
        this.socket = socket;
        this.frame = frame;
        this.name = name;
        gos = new GuiOutputStream(System.out, frame.getTextArea1());    // gui输出
    }
}
