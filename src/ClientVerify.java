import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 客户端验证线程
 */
public class ClientVerify implements Runnable {

    private String host;
    private int port;
    private String name;
    private Socket socket;
    private DataOutputStream dos;

    @Override
    public void run() {
        sendVerify(host, port, name);
    }

    public ClientVerify(String host, int port, String name) {
        this.host = host;
        this.port = port;
        this.name = name;
        try {
            socket = new Socket("localhost", 8889);
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendVerify(String host, int port, String name){
        try {
            dos.writeUTF(host);
            dos.flush();
            dos.writeInt(port);
            dos.flush();
            dos.writeUTF(name);
            dos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
