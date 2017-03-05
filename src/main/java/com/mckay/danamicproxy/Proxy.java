/**
 * Copyright © 2017 本代码版权归周林波所有，严禁未经许可使用。
 *
 * @Author: 周林波
 * @date: 2017/3/1 23:19
 * @version: V1.0
 */
package com.mckay.danamicproxy;

import com.mckay.processor.ProxyProcessor;
import org.apache.log4j.Logger;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Spider;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *@Description :用于维护一个动态代理库
 *@Author: 周林波
 *@Date :Created in 2017/3/1  23:19
 */
public class Proxy implements Runnable {

    private Logger log=Logger.getLogger(Proxy.class);
    private LinkedBlockingQueue queue;
    private int num;
    private long sleepTime;
    private String url;
    private HashMap<String,String> proxyMap;
    private volatile boolean run=true;

    public Proxy(LinkedBlockingQueue queue, int num, long sleepTime , String url , HashMap<String,String> proxyMap){
        this.queue=queue;
        this.num=num;
        this.sleepTime=sleepTime;
        this.url=url;
        this.proxyMap=proxyMap;
    }

    public Proxy(LinkedBlockingQueue queue,String url){
        this.queue=queue;
        this.num=1000;
        this.sleepTime=3000000;
        this.url=url;
    }

    public void stop(){
        run=false;
    }

    @Override
    public void run() {
        while (run){
            try {
                //获取代理、筛选有效代理
                Spider proxySipder=Spider.create(new ProxyProcessor());
                ResultItems resultItems=proxySipder.get(url);
                String result=resultItems.get("proxyIp");
                proxyMap.put("ip",result);
                Thread.sleep(sleepTime);
            }catch (Exception e){
                log.error("<<<Proxy error>>>"+e);
            }
        }
    }
}
