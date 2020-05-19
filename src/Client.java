import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

/**
 * 客户端
 * 每个客户端有一个用于读的socket，写的socket是临时创建的
 * 读端口8888
 * 写端口8887
 */
public class Client {

    private Socket socketRead;
    private ClientFrame frame;
    private String name = "";
    private ClientRead read;

    private void init(){
        try {
            socketRead = new Socket("localhost", 8888);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void start(){
        if (!"".equals(name)){
            return;
        }
        name = JOptionPane.showInputDialog("输入用户名");
        read = new ClientRead(socketRead, frame, name);
        new Thread(read).start();
    }

    public Client(ClientFrame frame) {
        init();
        this.frame = frame;
    }

    public void send(){
        try {
            // 从写端口写入信息
            Socket temp = new Socket("localhost", 8887);
            new Thread(new ClientWrite(temp, frame, name)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
