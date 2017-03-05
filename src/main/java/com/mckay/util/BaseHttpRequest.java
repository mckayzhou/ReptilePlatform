/**
 * Copyright © 2017 本代码版权归周林波所有，严禁未经许可使用。
 *
 * @Author: 周林波
 * @date: 2017/3/4 9:54
 * @version: V1.0
 */
package com.mckay.util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 *@Description :TODO
 *@Author: 周林波
 *@Date :Created in 2017/3/4  9:54
 */
public class BaseHttpRequest {

    private Logger log=Logger.getLogger(BaseHttpRequest.class);
    public Map<String,Object> sendGet(String url, String param){

        String result=null;
        BufferedReader in =null;
        Map<String,Object> map=null;
        String reqUrl=url+"?"+param;
        try {
            URL realUrl=new URL(reqUrl);
            URLConnection connection=realUrl.openConnection();
            //设置通用请求属性,并取得连接
            connection.setRequestProperty("accept","*/*");
            connection.setRequestProperty("connection","Keep-Alive");
            connection.setRequestProperty("use-agent","Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0");
            connection.connect();
            //获取响应头字段
            Map<String,List<String>> headMap =connection.getHeaderFields();
            map.put("head",headMap);
            //获取连接的输入流内容
            in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            map.put("context",in);
        }catch (Exception e){
            log.error(e);
        }finally {
            try {
                in.close();
            }catch (Exception e){
                log.error(e);
            }
        }
        return map;
    }

    public Map<String,Object> sendPost(String url, String param){

        PrintWriter out=null;
        BufferedReader in=null;
        Map<String,Object> map=null;
        try{
            URL postUrl=new URL(url);
            URLConnection connection=postUrl.openConnection();
            //设置属性
            connection.setRequestProperty("accept","*/*");
            connection.setRequestProperty("connection","Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0");
            //post请求必须设置的属性
            connection.setDoOutput(true);
            connection.setDoInput(true);
            //获取CONNECTION对象对应的输出流
            out=new PrintWriter(connection.getOutputStream());
            //发送请求参数
            out.print(param);
            out.flush();
            //读取响应头
            Map<String ,List<String >> headMap=connection.getHeaderFields();
            map.put("head",headMap);
            //读取请求响应
            in =new BufferedReader(new InputStreamReader(connection.getInputStream()));
            map.put("context",in);
        }catch (Exception e){
            log.error(e);
        }finally {
            try {
                out.close();
                in.close();
            }catch (Exception e){
                log.error(e);
            }
        }
        return map;
    }
}
