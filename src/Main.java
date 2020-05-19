/**
 * 启动一个服务器
 */
public class Main {
    public static void main(String[] args) {
        Server server = Server.INSTANCE;
        server.listen();
    }
}
