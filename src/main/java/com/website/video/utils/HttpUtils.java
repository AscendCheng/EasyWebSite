package com.website.video.utils;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class HttpUtils {

    private static final Gson gson = new Gson();

    private static final RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(5000)//连接超时
            .setConnectionRequestTimeout(5000)//请求超时
            .setSocketTimeout(5000)
            .setRedirectsEnabled(true)//允许自动重定向
            .build();

    /**
     * GET方法
     */
    public static Map<String, Object> doGet(String url) {
        Map<String, Object> result = new HashMap<>();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == HttpServletResponse.SC_OK) {
                String jsonResult = EntityUtils.toString(httpResponse.getEntity());
                result = gson.fromJson(jsonResult, Map.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * POST方法
     */
    public static Map<String, Object> doPOST(String url, String data) {
        Map<String, Object> result = new HashMap<>();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-Type", "text/html; charset=UTF-8");
        if (data != null && data instanceof String) {
            StringEntity stringEntity = new StringEntity(data, "UTF-8");
            httpPost.setEntity(stringEntity);
        }
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpResponse httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == HttpServletResponse.SC_OK) {
                String jsonResult = EntityUtils.toString(httpResponse.getEntity());
                result = gson.fromJson(jsonResult, Map.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
