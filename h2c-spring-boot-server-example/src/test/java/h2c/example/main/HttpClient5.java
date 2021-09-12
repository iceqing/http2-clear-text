package h2c.example.main;


import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.hc.core5.util.Timeout;

import java.io.IOException;

import static org.apache.hc.core5.http.HttpVersion.HTTP_2;

public class HttpClient5 {
    public static void main(String[] args) {
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpGet httpGet = null;
            URIBuilder uriBuilder = new URIBuilder("http://localhost:8080");
            httpGet = new HttpGet(uriBuilder.build());
            //配置
            RequestConfig config = RequestConfig.custom().setConnectTimeout(Timeout.ofSeconds(2000))
                    .setConnectionRequestTimeout(Timeout.ofSeconds(2000))
                    .setResponseTimeout(Timeout.ofSeconds(2000))
                    .build();
            httpGet.setConfig(config);
            httpGet.setVersion(HTTP_2);
            //http请求header设置
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36 Edg/88.0.705.68");

            //发起get请求
            response = client.execute(httpGet);
            if(response.getCode() != 200){
                return;
            }
            HttpEntity entity = response.getEntity();
            String html = EntityUtils.toString(entity, "utf8");
            System.out.println("html: "+html);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
