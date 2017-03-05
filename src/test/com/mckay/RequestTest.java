/**
 * Copyright © 2017 本代码版权归周林波所有，严禁未经许可使用。
 *
 * @Author: 周林波
 * @date: 2017/3/5 13:44
 * @version: V1.0
 */
package com.mckay;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;


/**
 *@Description :TODO
 *@Author: 周林波
 *@Date :Created in 2017/3/5  13:44
 */
public class RequestTest {

    @Test
    public void test(){

        String url="https://red.jd.com/";

        // 核心应用类
        HttpClient httpClient = new DefaultHttpClient();


        HttpGet httpget = new HttpGet(url);
        // 加入头信息
        httpget.addHeader("Accept", "text/html");
        httpget.addHeader("Accept-Charset", "utf-8");
        httpget.addHeader("Accept-Encoding", "gzip");
        httpget.addHeader("Accept-Language", "zh-CN,zh");
        httpget.addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.160 Safari/537.22");

        try {
            HttpResponse response = httpClient.execute(httpget);
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }catch (Exception e){

        }

    }
}
