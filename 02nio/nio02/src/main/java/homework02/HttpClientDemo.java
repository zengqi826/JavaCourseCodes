package homework02;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * HttpClientDemo
 * use HttpClient to access NettyHttpServer  demo
 *
 * @author zengqi
 * @date 2021/7/06 10:20
 */
public class HttpClientDemo {
    public static void main(String[] args) {
        String url ="http://localhost:8808";
        String urlWithTest ="http://localhost:8808/test";
        getByHttpClient(url);
        getByHttpClient(urlWithTest);
    }

    private static void getByHttpClient(String url) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet(url);
        getRequest.addHeader("accept", "application/xml");
        try {
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK)
            {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            HttpEntity httpEntity = response.getEntity();
            String httpEntityString = EntityUtils.toString(httpEntity);
            System.out.println(httpEntityString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
