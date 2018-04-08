package com.crawler.webmargic.main;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.crawler.dao.es.EsClient;
import com.crawler.model.es.EsModel;
import com.crawler.webmargic.utils.WangYiYunEncryptUtils;
import com.crawler.webmargic.vo.RequestModel;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Liukx
 * @create 2017-05-08 16:22
 * @email liukx@elab-plus.com
 **/
public class HTTPClientTest {
    public static final String BASE_URL = "http://music.163.com/";

    public static void main(String[] args) throws Exception {
        RequestModel model = new RequestModel();
        model.setLimit(100);
        model.setTotal(false);
        model.setOffset(0);
        EsClient client = new EsClient();
//        for (int c = 0; c < 100 + 1; c++) {
//            model.setOffset(c * 100);
        model.setOffset(1);
        JSONObject jsonObject = JSON.parseObject(crawlAjaxUrl("186016", model));
        JSONArray comments = jsonObject.getJSONArray("comments");
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < comments.size(); i++) {
            JSONObject o = (JSONObject) comments.get(i);
            o.remove("isRemoveHotComment");
            o.remove("beReplied");
            o.remove("user");
            o.remove("liked");
            dataList.add(o.toJSONString());

        }
        EsModel esModel = new EsModel();
        esModel.setIndex("告白气球");
        esModel.setType("comment");
        esModel.setJsonData(dataList);
        boolean b = client.insertIndex(esModel);
        System.out.println("添加结果-" + b);
//        }
    }

    //对AJAX数据进行单独请求
    public static String crawlAjaxUrl(String songId, RequestModel requestModel) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;

        try {
            //参数加密
            String secKey = new BigInteger(100, new SecureRandom()).toString(32).substring(0, 16);
            String text = JSON.toJSONString(requestModel);
            System.out.println("请求参数:" + text);
            Map<String, String> encrypt = WangYiYunEncryptUtils.encrypt(text);
//            System.out.println("加密时间:"+encrypt);
            HttpPost httpPost = new HttpPost("http://music.163.com/weapi/v1/resource/comments/R_SO_4_" + songId + "/?csrf_token=");
            httpPost.addHeader("Referer", BASE_URL);

            List<NameValuePair> ls = new ArrayList<NameValuePair>();
            ls.add(new BasicNameValuePair("params", encrypt.get("params").toString()));
            ls.add(new BasicNameValuePair("encSecKey", encrypt.get("encSecKey").toString()));

            UrlEncodedFormEntity paramEntity = new UrlEncodedFormEntity(ls, "utf-8");
            httpPost.setEntity(paramEntity);

            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                return EntityUtils.toString(entity, "utf-8");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "";
    }
}
