import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端读
 */
public class ClientRead implements Runnable {


    private ServerSocket serverSocket;
    private GuiOutputStream gos;
    private ClientFrame frame;

    @Override
    public void run() {
        System.setOut(gos);
        DataInputStream dis;
        try {
            while (true){
                Socket ss = serverSocket.accept();
                dis = new DataInputStream(ss.getInputStream());
                System.out.println(dis.readUTF());
                dis.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            release();
        }
    }

    /**
     * 回收资源
     */
    private void release(){
        ChatUtils.close(serverSocket, gos);
    }

    public ClientRead(ServerSocket serverSocket, ClientFrame frame) {
        this.serverSocket = serverSocket;
        this.frame = frame;
        gos = new GuiOutputStream(System.out, frame.getTextArea1());
    }
}
