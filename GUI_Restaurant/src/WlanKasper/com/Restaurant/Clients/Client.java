package WlanKasper.com.Restaurant.Clients;

public class Client {
    String name;
    String prefers;

    public Client (String name) {
        this.name = name;
        this.prefers = "";
    }

    public String getName () {
        return name;
    }

    public String getPrefers () {
        return prefers;
    }
}
