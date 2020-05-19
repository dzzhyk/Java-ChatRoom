import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 工具类
 */
public class ChatUtils {

    private static Scanner in = new Scanner(System.in);

    public static void close(Closeable... target){
        try {
            for (Closeable closeable : target) {
                closeable.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String readFromConsole(){
        return in.nextLine();
    }

    /**
     * 设置client聊天信息框内容
     * @param frame 客户端frame
     */
    public static void setClientOutputMessage(ClientFrame frame, String msg){
        JTextArea textArea1 = frame.getTextArea1();
        textArea1.setText(textArea1.getText() + "\n" + msg);
    }

    /**
     * 获取client输入框内容
     * @param frame
     * @return
     */
    public static String getClientInputMessage(ClientFrame frame){
        JTextField textArea2 = frame.getTextArea2();
        return textArea2.getText();
    }

    /**
     * 设置server聊天信息框内容
     * @param frame
     */
    public static void setServerOutputMessage(ServerFrame frame, String msg){
        JTextArea textArea1 = frame.getTextArea1();
    }

    /**
     * 设置server在线用户内容
     */
    public static void setServerOnlineClients(){
        JTextArea textArea2 = Server.getFrame().getTextArea2();
//        textArea2.setText(genUserList(Server.getUsers()));
    }

    public static String genUserList(CopyOnWriteArraySet<Channel> users){
        StringBuilder builder = new StringBuilder();
        for (Channel user : users) {
            if (user==null){
                continue;
            }
            builder.append(user.getName()).append("\n");
        }
        return builder.toString();
    }

    /**
     * 将消息广播给所有用户
     */
    public static void broadCast(String msg){
        if (!"".equals(msg)){
            for (Channel user : Server.getUsers()) {
                new Thread(new ServerWrite(user.getHost(), user.getPort(), msg)).start();
            }
        }
    }
}
