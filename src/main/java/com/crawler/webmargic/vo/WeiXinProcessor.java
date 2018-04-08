package com.crawler.webmargic.vo;

import com.crawler.model.common.RequestTaskModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 微信文章评论获取
 *
 * @author Liukx
 * @create 2017-05-12 15:05
 * @email liukx@elab-plus.com
 **/
public class WeiXinProcessor implements PageProcessor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Site site;

    // 接口调用需要返回的认证token
//    private String authorization = "oauth c3cef7c66a1843f8b3a9e6a1e3160e20";

    //详情地址
    private String contentMatch = "http://www.toutiao.com/a\\d+";

    private String contentMatch2 = "https://m.toutiao.com/group";

    //关键字
    private String keyword;

    private String base_url = "qq.com";

//    private AtomicInteger count = new AtomicInteger();

    //主域名
//    public static final String BASE_Node_URL = "http://www.toutiao.com/search/?keyword=%E5%91%A8%E6%9D%B0%E4%BC%A6";
    public String BASE_Node_URL = "https://mp.weixin.qq.com/s?__biz=MzA5OTM0MzU5Mg==&mid=2651941663&idx=6&sn=5b5866ae0f9b216833af924d9f796bbf&chksm=8b660698bc118f8ecdd2447c39b1ac78f5d7825d5b4e14d326b111f54b88432ef472e12c9eab&mpshare=1&scene=23&srcid=0524Gh3mqjtw9yt75HGBl4p8#rd";

    private RequestTaskModel requestTaskModel;


    /**
     * 具体要执行的抓去内容处理
     *
     * @param page
     */
    public void process(Page page) {
        System.out.println("======================================");
    }

    /**
     * @return
     */
    public Site getSite() {
        if (site == null) {
            site = Site.me().setDomain(base_url);//.addStartUrl(BASE_Node_URL);
        }
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new WeiXinProcessor()).thread(5).run();
    }
}
