/**
 * Copyright © 2017 本代码版权归周林波所有，严禁未经许可使用。
 *
 * @Author: 周林波
 * @date: 2017/3/4 18:21
 * @version: V1.0
 */
package com.mckay.spider;

import com.mckay.processor.ProxyProcessor;
import com.mckay.util.BaseHttpRequest;
import org.junit.Test;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.example.BaiduBaikePageProcessor;

import java.io.BufferedReader;
import java.util.Map;

/**
 *@Description :TODO
 *@Author: 周林波
 *@Date :Created in 2017/3/4  18:21
 */

public class testDemo {

    @Test
    public void test(){

        BaseHttpRequest request=new BaseHttpRequest();
        String url="https://www.jd.com/";
        String url2="https://xueqiu.com/S/SZ399006";
        Spider spider = Spider.create(new ProxyProcessor()).thread(2);
        String urlTemplate = "http://www.xicidaili.com/";
        ResultItems resultItems = (ResultItems)spider.get(urlTemplate);
        System.out.println(resultItems);
    }
}
