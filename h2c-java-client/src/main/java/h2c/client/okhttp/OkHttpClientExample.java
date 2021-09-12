package h2c.client.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

import java.util.Arrays;

class OkHttpClientExample {

    public static void main(String[] args) throws Exception {
        testH2C();
    }

    public static void testH2C() throws Exception {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .protocols(Arrays.asList(Protocol.H2_PRIOR_KNOWLEDGE))
                .build();

        Request request = new Request.Builder()
                .url("http://127.0.0.1:8080/")
                .build();
        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.toString());
        System.out.println(response.body().string());
    }
}