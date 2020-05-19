import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端接受信息
 */
public class ServerRead implements Runnable {

    private ServerSocket serverSocket;
    private GuiOutputStream gos;
    private ServerFrame frame;

    @Override
    public void run() {
        System.setOut(gos);
        DataInputStream dis;
        try {
            while (true){
                Socket ss = serverSocket.accept();
//                System.out.println("--来了一个新的客户端--");
                dis = new DataInputStream(ss.getInputStream());

                try {
                    // 把这些读到的内容全部转发
                    String name = dis.readUTF();
                    String msg = dis.readUTF();
                    msg = "[" + name +"]: " + msg;
                    ChatUtils.broadCast(msg);

                    // 服务端也输出
                    System.out.println(msg);
                }catch (EOFException e){
                    e.printStackTrace();
                }
                dis.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            release();
        }
    }

    public ServerRead(ServerSocket serverSocket, ServerFrame frame) {
        this.serverSocket = serverSocket;
        this.frame = frame;
        gos = new GuiOutputStream(System.out, frame.getTextArea1());    // 输出到服务端的信息框
    }

    /**
     * 回收资源
     */
    private void release(){
        ChatUtils.close(serverSocket);
    }

}
