/**
 * Copyright © 2017 本代码版权归周林波所有，严禁未经许可使用。
 *
 * @Author: 周林波
 * @date: 2017/3/1 23:34
 * @version: V1.0
 */
package com.mckay.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 *@Description :示列processor
 *@Author: 周林波
 *@Date :Created in 2017/3/1  23:34
 */
public class DemoProcessor implements PageProcessor {

    private Site site=Site.me().setRetryTimes(3).setSleepTime(1000).setUserAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0");

    @Override
    public void process(Page page) {
        page.putField("context",page.getHtml());
    }

    @Override
    public Site getSite() {
        return site;
    }
}
