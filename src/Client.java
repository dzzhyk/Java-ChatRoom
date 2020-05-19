import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * 客户端
 * 每个客户端有一个用于读的socket，写的socket是临时创建的
 * 读端口随机
 * 写端口8887 - 这是服务器规定的
 * 验证端口8889 - 这是服务器规定的
 */
public class Client {

    private ServerSocket socketRead;
    private int port;
    private ClientFrame frame;
    private String name = null;
    private boolean isLogined = false;
    private ClientRead read;

    private void init(){
        try {
            socketRead = new ServerSocket(0);
            port = socketRead.getLocalPort();   // 客户端监听端口
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void start(){
        name = JOptionPane.showInputDialog("输入用户名");
        if (name==null || "".equals(name.trim())){
            return;
        }
        // 发送验证线程
        new Thread(new ClientVerify("localhost", port, name)).start();
        isLogined = true;

        // 客户端显示用户信息
        frame.getLabel3().setText(name);

        read = new ClientRead(socketRead, frame);
        new Thread(read).start();
    }

    public Client(ClientFrame frame) {
        init();
        this.frame = frame;
    }

    public void send(){
        if (!isLogined){
            start();
        }else {
            new Thread(new ClientWrite(frame, name)).start();
        }
    }

    public void exit() {
        new Thread(new ClientVerify("exit", port, name)).start();
        ChatUtils.close(socketRead);
    }
}
