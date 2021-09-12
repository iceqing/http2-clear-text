package h2c.client.reactor;


import reactor.netty.http.HttpProtocol;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.client.HttpClientResponse;

public class ReactorDemo {
    public static void main(String[] args) {
        HttpClient client = HttpClient.create().protocol(HttpProtocol.H2C);  //<1>
        HttpClientResponse response = client.get()                       //<2>
                .uri("http://localhost:8080") //<3>
                .response()                  //<4>
                .block();
        System.out.println("response = " + response);
    }
}
