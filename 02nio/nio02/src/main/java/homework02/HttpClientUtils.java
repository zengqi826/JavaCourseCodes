package homework02;

import io.netty.handler.codec.http.HttpHeaders;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

/**
 * HttpClientUtils
 *
 * @author zengqi
 * @date 2021/7/6 9:15
 */
public class HttpClientUtils {
    public static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static String getAsString(String url, HttpHeaders headers) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        if (headers == null) {
            httpGet.addHeader("accept", "application/xml");
        } else {
            for (Map.Entry<String, String> entry : headers.entries()) {
                httpGet.addHeader(entry.getKey(), entry.getValue());
            }
        }
        CloseableHttpResponse response1 = httpClient.execute(httpGet);
        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            return EntityUtils.toString(entity1, "UTF-8");
        } finally {
            response1.close();
        }
    }

    public static void main(String[] args) throws Exception {

        String url = "http://localhost:8808";
        String text = HttpClientUtils.getAsString(url, null);
        System.out.println("url: " + url + " ; response: \n" + text);

    }
}
