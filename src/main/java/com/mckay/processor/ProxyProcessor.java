/**
 * Copyright © 2017 本代码版权归周林波所有，严禁未经许可使用。
 *
 * @Author: 周林波
 * @date: 2017/3/2 21:07
 * @version: V1.0
 */
package com.mckay.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 *@Description :代理爬取过程
 *@Author: 周林波
 *@Date :Created in 2017/3/2  21:07
 */
public class ProxyProcessor implements PageProcessor {

    private Site site=Site.me().setRetryTimes(4).setSleepTime(1000).setUserAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0");


    @Override
    public void process(Page page) {
        page.putField("odd",page.getHtml().xpath("//tr[@class='odd']").all());
        page.putField("proxyIp",page.getHtml().xpath("//tr[@class=' ']").regex("\\d*\\.\\d*\\.\\d*\\.\\d*").all());
        page.putField("proxyPort",page.getHtml().xpath("//tr[@class=' ']").regex("<td>\\d+</td>").all());
        page.putField("origin",page.getHtml().xpath("//tr[@class=' ']").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public void setSite(Site site){
        this.site=site;
    }
}
