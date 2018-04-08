package com.crawler.webmargic.main;

import com.alibaba.fastjson.JSONObject;
import com.crawler.webmargic.KuaiProxyListProcessor;
import com.crawler.webmargic.ProxyIPProcessor;
import us.codecraft.webmagic.Spider;

import java.util.List;

/**
 * 通过代理去模拟多个ip刷去阅读量
 *
 * @author Liukx
 * @create 2017-06-12 13:56
 * @email liukx@elab-plus.com
 **/
public class ProxyTest {

    private static void addProxy(List<JSONObject> list, String ip, String port) {
        JSONObject j1 = new JSONObject();
        j1.put("ip", ip);
        j1.put("port", port);
        list.add(j1);
    }

    public static void main(String[] args) {
        //头条盘点：独在异乡为异客，一人一世界，孤独到心碎的感觉 ->http://www.toutiao.com/i6430210949306647042/
        //薛之谦兑现前妻承诺，你又有什么话想对前任说？ ->         http://www.toutiao.com/i6430574610307088898/
        //你听到这首曲子的时候,在想什么?                         http://www.toutiao.com/a6431067124336967937
        //不能说的秘密                                          http://www.toutiao.com/i6431403230189584898/
        // 相爱十年                                             http://www.toutiao.com/i6432057662094967298/
        String url = "http://www.toutiao.com/i6436902610204099074";
        Spider.create(new KuaiProxyListProcessor(url)).thread(5).run();
        Spider.create(new ProxyIPProcessor(url)).thread(5).run();

//        String url = "http://is.snssdk.com/2/article/information/v21/?group_id=6428723082555506946&item_id=6428713047522312562&aggr_type=1&context=1&from=click_search&article_page=0&iid=10702191108&device_id=13516101044&ac=wifi&channel=xiaomi&aid=13&app_name=news_article&version_code=617&version_name=6.1.7&device_platform=android&ab_version=120430%2C134939%2C126063%2C122834%2C130106%2C126068%2C134746%2C134127%2C136024%2C134514%2C126071%2C135623%2C125503%2C125174%2C135859%2C133018%2C136061%2C126058%2C133593%2C132482%2C133042%2C134952%2C135632%2C122948%2C130139%2C31646%2C132635%2C135291%2C131207%2C126101%2C114338%2C136039%2C133770&ab_client=a1%2Cc4%2Ce1%2Cf2%2Cg2%2Cf7&ab_feature=102749%2C94563&abflag=3&ssmix=a&device_type=MI+5&device_brand=Xiaomi&language=zh&os_api=24&os_version=7.0&manifest_version_code=617&resolution=1080*1920&dpi=480&update_version_code=6170";
//
//        List<JSONObject> list = new ArrayList<>();
//        addProxy(list, "121.232.147.33", "9000");
//        addProxy(list, "119.254.84.90", "80");
//        addProxy(list, "36.248.129.101", "808");
//        addProxy(list, "117.90.2.40", "9000");
//        addProxy(list, "121.232.147.114", "9000");
//        addProxy(list, "121.232.147.171", "9000");
//
//        for (int i = 0; i < 6; i++) {
//            JSONObject jsonObject = list.get(i);
//            String ip = jsonObject.getString("ip");
//            String port = jsonObject.getString("port");
//            System.getProperties().setProperty("http.proxyHost", ip);
//            System.getProperties().setProperty("http.proxyPort", port);
//            int count = org.apache.commons.lang3.RandomUtils.nextInt(1000, 9999);
//            String uuid = "&uuid=86916102692" + count;
//            System.out.println("请求的URL : "+url + count);
//            String s = HttpClientUtil.sendGetForm(url + uuid, "");
//        }

    }
}
