package com.crawler.webmargic.main;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vladsch.flexmark.html2md.converter.FlexmarkHtmlConverter;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class JKSJTest {
    private static Pattern pattern = Pattern.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]");

    private static String cookie = "LF_ID=1591421469637-1763-4652418; _ga=GA1.2.735293742.1591421470; GCID=0166ff0-59eaeb5-c96dc14-0655901; GRID=0166ff0-59eaeb5-c96dc14-0655901; ERID=bed5baf-37821c0-6880c74-4eb353d; gksskpitn=6d2d4d31-d457-46ee-af66-dc7282479f17; _gid=GA1.2.797339240.1605620885; _gat=1; GCESS=BQMEddezXwcE3LU4MgYEU3CvHQsCBQAIAQMJAQECBHXXs18EBAAvDQAFBAAAAAAMAQEKBAAAAAABCORDIwAAAAAA; Hm_lvt_022f847c4e3acd44d4a2481d9187f1e6=1605621123,1605621161,1605621603,1605621621; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%222311140%22%2C%22first_id%22%3A%22175d6815856a84-0305cebc17ef5f-3b3d5203-2073600-175d681585784b%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E4%BB%98%E8%B4%B9%E5%B9%BF%E5%91%8A%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Faccount.infoq.cn%2F%22%2C%22%24latest_landing_page%22%3A%22https%3A%2F%2Ftime.geekbang.org%2Fdashboard%2Fcourse%3Futm_source%3Dpinpaizhuanqu%26utm_medium%3Dgeektime%26utm_campaign%3Dguanwang%26utm_term%3Dguanwang%26utm_content%3D0511%22%2C%22%24latest_utm_source%22%3A%22pinpaizhuanqu%22%2C%22%24latest_utm_medium%22%3A%22geektime%22%2C%22%24latest_utm_campaign%22%3A%22guanwang%22%2C%22%24latest_utm_content%22%3A%220511%22%2C%22%24latest_utm_term%22%3A%22guanwang%22%7D%2C%22%24device_id%22%3A%22173903aeccb5a8-08266a23af47b7-3e3e5f0e-2073600-173903aeccc929%22%7D; Hm_lvt_59c4ff31a9ee6263811b23eb921a5083=1605410920,1605620885,1605621161,1605621625; Hm_lpvt_59c4ff31a9ee6263811b23eb921a5083=1605621631; Hm_lpvt_022f847c4e3acd44d4a2481d9187f1e6=1605621631;";

    public static void main(String[] args) throws Exception {

        String bookListUrl = "https://time.geekbang.org/serv/v1/column/articles";

        String baseDir = "E:\\08_github\\极客时间";
        String courseTitle = "面试秘籍";
        String path = baseDir + "\\" + courseTitle;
        String articleId = "188816";

        Map<String, String> headerMap = baseHeaderMap(articleId);

        String body = "{\"cid\":" + 274 + ",\"size\":100,\"prev\":0,\"order\":\"earliest\",\"sample\":false}\n";
//        String responseJson = HttpClientUtil.doPostAndCookie(bookListUrl, headerMap, jsonObject, cookie);
//        System.out.println(responseJson);
        String resultJson = HttpUtil.createPost(bookListUrl).headerMap(headerMap, true).body(body).execute().body();
        JSONObject jsonObject = JSON.parseObject(resultJson);
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray list = data.getJSONArray("list");
        for (int i = 0; i < list.size(); i++) {
            JSONObject obj = list.getJSONObject(i);
            String articleTitle = obj.getString("article_title");
            Integer id = obj.getInteger("id");
            String nodeBody = "{\"id\":\"" + id + "\",\"include_neighbors\":true,\"is_freelyread\":true}";

            JSONObject nodeResult = getBody("https://time.geekbang.org/serv/v1/article", articleId, nodeBody);

            JSONObject nd1 = nodeResult.getJSONObject("data");
            String articleContent = nd1.getString("article_content");
            String filePath = path + "\\" + filteringCharacters(articleTitle) + ".md";
            String content = htmlToMd(articleContent);

            if (!FileUtil.exist(filePath)) {
                FileUtil.touch(filePath);
            }
            File file = new File(filePath);
            FileUtil.writeString(content, file, Charset.defaultCharset());
            System.out.println("标题 : " + articleTitle);
            Thread.sleep(2000);
        }
    }

    public static String filteringCharacters(String title) {
        title = title.replaceAll(" | ", "_");
        return title == null ? null : pattern.matcher(title).replaceAll("");
    }

    public static String htmlToMd(String html) {
        MutableDataSet options = new MutableDataSet();
        String md = FlexmarkHtmlConverter.builder(options).build().convert(html);
        return md;
    }

    public static JSONObject getBody(String url, String articleId, String body) throws Exception {
        Map<String, String> headerMap = baseHeaderMap(articleId);
        String resultJson = HttpUtil.createPost(url).headerMap(headerMap, true).body(body).execute().body();
        try {
            return JSON.parseObject(resultJson);
        } catch (Exception e) {
            System.out.println("爬取国语频繁,休眠再试试:" + resultJson);
            Thread.sleep(5000);
            return getBody(url, articleId, body);
        }
    }

    private static Map<String, String> baseHeaderMap(String articleId) {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Cookie", cookie);
        headerMap.put("Referer", "https://time.geekbang.org/column/article/" + articleId + "?utm_source=pinpaizhuanqu&utm_medium=geektime&utm_campaign=guanwang&utm_term=guanwang&utm_content=0511");
        headerMap.put("Content-Type", "application/json");
        headerMap.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537." + RandomUtil.randomNumbers(2));
        return headerMap;
    }


}
