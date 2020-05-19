import java.util.Objects;

public class Channel{

    private String host;
    private int port;
    private String name;

    public Channel(String host, int port, String name) {
        this.host = host;
        this.port = port;
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return port == channel.port &&
                host.equals(channel.host) &&
                name.equals(channel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port, name);
    }
}
