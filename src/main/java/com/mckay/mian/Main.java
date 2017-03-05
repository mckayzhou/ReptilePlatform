/**
 * Copyright © 2017 本代码版权归周林波所有，严禁未经许可使用。
 *
 * @Author: 周林波
 * @date: 2017/3/1 23:33
 * @version: V1.0
 */
package com.mckay.mian;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.example.BaiduBaikePageProcessor;

/**
 *@Description :TODO
 *@Author: 周林波
 *@Date :Created in 2017/3/1  23:33
 */
public class Main {

    public static void main(){

        Spider spider = Spider.create(new BaiduBaikePageProcessor()).thread(2);

    }
}
