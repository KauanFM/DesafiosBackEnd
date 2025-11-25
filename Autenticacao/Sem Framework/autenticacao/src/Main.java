import config.HttpConfig;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpConfig httpConfig = new HttpConfig();
        httpConfig.newServer();
    }
}
