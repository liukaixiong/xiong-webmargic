package com.crawler.webmargic;

import com.alibaba.fastjson.JSONObject;
import com.crawler.webmargic.utils.HttpClientUtil;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 快代理ip获取
 *
 * @author Liukx
 * @create 2017-05-12 15:05
 * @email liukx@elab-plus.com
 **/
public class KuaiProxyListProcessor implements PageProcessor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Site site;

    private String base_url = "xicidaili.com";

    //主域名
//    public static final String BASE_Node_URL = "http://www.toutiao.com/search/?keyword=%E5%91%A8%E6%9D%B0%E4%BC%A6";
    public String BASE_Node_URL = "http://www.xicidaili.com/wt/";

    private int index = 1;

    private String url;

    public KuaiProxyListProcessor(String url) {
        this.url = url;
    }

    private Executor executor = new ThreadPoolExecutor(0, 20,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());

    /**
     * 具体要执行的抓去内容处理
     *
     * @param page
     */
    public void process(Page page) {
        List<String> ipList = page.getHtml().xpath("//*[@id=\"ip_list\"]/tbody/tr/td[2]/text()").all();
        List<String> portList = page.getHtml().xpath("//*[@id=\"ip_list\"]/tbody/tr/td[3]/text()").all();
        int successCount = 0;
        int errorCount = 0;
        for (int i = 0; i < ipList.size(); i++) {
            String ip = ipList.get(i);
            String port = portList.get(i);
            ProxyList run = new ProxyList(ip, port, url);
            executor.execute(run);
        }

        index++;
        if (index > 10) {
            return;
        }
        page.addTargetRequest(BASE_Node_URL + index);

        System.out.println("成功 : " + successCount + "\t 失败:" + errorCount);
    }

    private JSONObject createDate(String ip, String port) {
        JSONObject json = new JSONObject();
        json.put("ip", ip);
        json.put("port", port);
        return json;
    }


    public static String getRadomMobileType() {
        String[] mobileUserAgents = new String[]{
                "Nokia",//诺基亚，有山寨机也写这个的，总还算是手机，Mozilla/5.0 (Nokia5800 XpressMusic)UC AppleWebkit(like Gecko) Safari/530
                "SAMSUNG",//三星手机 SAMSUNG-GT-B7722/1.0+SHP/VPP/R5+Dolfin/1.5+Nextreaming+SMM-MMS/1.2.0+profile/MIDP-2.1+configuration/CLDC-1.1
                "MIDP-2",//j2me2.0，Mozilla/5.0 (SymbianOS/9.3; U; Series60/3.2 NokiaE75-1 /110.48.125 Profile/MIDP-2.1 Configuration/CLDC-1.1 ) AppleWebKit/413 (KHTML like Gecko) Safari/413
                "CLDC1.1",//M600/MIDP2.0/CLDC1.1/Screen-240X320
                "SymbianOS",//塞班系统的，
                "MAUI",//MTK山寨机默认ua
                "UNTRUSTED/1.0",//疑似山寨机的ua，基本可以确定还是手机
                "Windows CE",//Windows CE，Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.11)
                "iPhone",//iPhone是否也转wap？不管它，先区分出来再说。Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_1 like Mac OS X; zh-cn) AppleWebKit/532.9 (KHTML like Gecko) Mobile/8B117
                "iPad",//iPad的ua，Mozilla/5.0 (iPad; U; CPU OS 3_2 like Mac OS X; zh-cn) AppleWebKit/531.21.10 (KHTML like Gecko) Version/4.0.4 Mobile/7B367 Safari/531.21.10
                "Android",//Android是否也转wap？Mozilla/5.0 (Linux; U; Android 2.1-update1; zh-cn; XT800 Build/TITA_M2_16.22.7) AppleWebKit/530.17 (KHTML like Gecko) Version/4.0 Mobile Safari/530.17
                "BlackBerry",//BlackBerry8310/2.7.0.106-4.5.0.182
                "UCWEB",//ucweb是否只给wap页面？ Nokia5800 XpressMusic/UCWEB7.5.0.66/50/999
                "ucweb",//小写的ucweb貌似是uc的代理服务器Mozilla/6.0 (compatible; MSIE 6.0;) Opera ucweb-squid
                "BREW",//很奇怪的ua，例如：REW-Applet/0x20068888 (BREW/3.1.5.20; DeviceId: 40105; Lang: zhcn) ucweb-squid
                "J2ME",//很奇怪的ua，只有J2ME四个字母
                "YULONG",//宇龙手机，YULONG-CoolpadN68/10.14 IPANEL/2.0 CTC/1.0
                "YuLong",//还是宇龙
                "COOLPAD",//宇龙酷派YL-COOLPADS100/08.10.S100 POLARIS/2.9 CTC/1.0
                "TIANYU",//天语手机TIANYU-KTOUCH/V209/MIDP2.0/CLDC1.1/Screen-240X320
                "TY-",//天语，TY-F6229/701116_6215_V0230 JUPITOR/2.2 CTC/1.0
                "K-Touch",//还是天语K-Touch_N2200_CMCC/TBG110022_1223_V0801 MTK/6223 Release/30.07.2008 Browser/WAP2.0
                "Haier",//海尔手机，Haier-HG-M217_CMCC/3.0 Release/12.1.2007 Browser/WAP2.0
                "DOPOD",//多普达手机
                "Lenovo",// 联想手机，Lenovo-P650WG/S100 LMP/LML Release/2010.02.22 Profile/MIDP2.0 Configuration/CLDC1.1
                "LENOVO",// 联想手机，比如：LENOVO-P780/176A
                "HUAQIN",//华勤手机
                "AIGO-",//爱国者居然也出过手机，AIGO-800C/2.04 TMSS-BROWSER/1.0.0 CTC/1.0
                "CTC/1.0",//含义不明
                "CTC/2.0",//含义不明
                "CMCC",//移动定制手机，K-Touch_N2200_CMCC/TBG110022_1223_V0801 MTK/6223 Release/30.07.2008 Browser/WAP2.0
                "DAXIAN",//大显手机DAXIAN X180 UP.Browser/6.2.3.2(GUI) MMP/2.0
                "MOT-",//摩托罗拉，MOT-MOTOROKRE6/1.0 LinuxOS/2.4.20 Release/8.4.2006 Browser/Opera8.00 Profile/MIDP2.0 Configuration/CLDC1.1 Software/R533_G_11.10.54R
                "SonyEricsson",// 索爱手机，SonyEricssonP990i/R100 Mozilla/4.0 (compatible; MSIE 6.0; Symbian OS; 405) Opera 8.65 [zh-CN]
                "GIONEE",//金立手机
                "HTC",//HTC手机
                "ZTE",//中兴手机，ZTE-A211/P109A2V1.0.0/WAP2.0 Profile
                "HUAWEI",//华为手机，
                "webOS",//palm手机，Mozilla/5.0 (webOS/1.4.5; U; zh-CN) AppleWebKit/532.2 (KHTML like Gecko) Version/1.0 Safari/532.2 Pre/1.0
                "GoBrowser",//3g GoBrowser.User-Agent=Nokia5230/GoBrowser/2.0.290 Safari
                "IEMobile",//Windows CE手机自带浏览器，
                "WAP2.0"//支持wap 2.0的
        };


        int i = RandomUtils.nextInt(0, mobileUserAgents.length);
        return mobileUserAgents[i];
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {

        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            //浏览器
            String liulanqi = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)";
            connection.setRequestProperty("user-agent",
                    liulanqi);
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * @return
     */
    public Site getSite() {
        if (site == null) {
            site = Site.me().setDomain(base_url) // .addStartUrl(BASE_Node_URL)
                    .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
            ;
        }
        return site;
    }

    class ProxyList implements Runnable {

        private String ip;
        private String port;
        private String url;

        public ProxyList(String ip, String port, String url) {
            this.ip = ip;
            this.port = port;
            this.url = url;
        }

        public void run() {
            // 如果不设置，只要代理IP和代理端口正确,此项不设置也可以
            System.getProperties().setProperty("http.proxyHost", ip);
            System.getProperties().setProperty("http.proxyPort", port);
            // 判断代理是否设置成功

            // 发送 GET 请求
            String response = HttpClientUtil.sendGetForm(url, "");
            if (StringUtils.isNotBlank(response)) {
                System.out.println("======================成功~");
            } else {
                System.out.println("=====================失败~");
            }
        }
    }

}
