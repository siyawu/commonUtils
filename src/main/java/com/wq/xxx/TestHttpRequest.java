package com.wq.xxx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class TestHttpRequest {
    private static final CookieStore COOKIE_STORE = new BasicCookieStore();
    
    public static void main(String[] args) {
        String url = "http://localhost:8855/higgs/work-order";
        String cookie = "AF68E95AE58E37B924E7AE067D58E5E1";
        BasicClientCookie clientCookie = new BasicClientCookie("Cookie", cookie);
        clientCookie.setVersion(0);
        clientCookie.setDomain("localhost:8855");
        clientCookie.setPath("/higgs");
        COOKIE_STORE.addCookie(clientCookie);
        String jsonParam = "{\"customerId\":11,\"customerContactId\":13," +
                "\"customerAddressId\":18,\"productList\":[200],\"businessId\":1,\"serviceTypeId\":1,\"serviceContentId\":1,\"workOrderTypeId\":1,\"description\":\"      \",\"priorityId\":2,\"planTime\":\"2021/01/26 10:01:82\"}";
        
        doPost(url, jsonParam);
    }
    
    public static void doPost(String url, String jsonParam) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String result = "";
        // 配置请求参数实例
        RequestConfig requestConfig = RequestConfig.custom()
//                .setCookieSpec(CookieSpecs.STANDARD_STRICT)
                .setConnectTimeout(35000)// 设置连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
                .setSocketTimeout(60000)// 设置读取数据连接超时时间
                .setRedirectsEnabled(false)
                .build();
        // 创建httpClient实例
//        httpClient = HttpClients.createDefault();
        httpClient = HttpClients.custom()
                .setDefaultCookieStore(COOKIE_STORE)
//                .setRedirectStrategy(new LaxRedirectStrategy())
                .setDefaultRequestConfig(requestConfig)
                .build();
        
        // 创建httpPost远程连接实例
        HttpPost httpPost = new HttpPost(url);
        // 为httpPost实例设置配置
        httpPost.setConfig(requestConfig);
        // 设置请求头
        httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
        httpPost.addHeader("CustomerId", "26");
        httpPost.addHeader("Connection", "keep-alive");
//        httpPost.addHeader("Origin", "http://xgs.test.xiyukeji.net");
        httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");
        httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.9");
//        httpPost.addHeader(new BasicHeader("Cookie", "40B6167E23CE25035164B7813C9C1F4D"));
        
        // 封装post请求参数
        if (jsonParam != null && jsonParam.length() > 0) {
            // 为httpPost设置封装好的请求参数
            try {
                JSONObject jsonObject = JSON.parseObject(jsonParam);
                httpPost.setEntity(new StringEntity(jsonObject.toString()));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            // httpClient对象执行post请求,并返回响应参数对象
            httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            System.out.println(statusCode);
            // 从响应对象中获取响应内容
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
