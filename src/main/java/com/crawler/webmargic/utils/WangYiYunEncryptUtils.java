package com.crawler.webmargic.utils;

import org.apache.commons.lang3.RandomStringUtils;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * 网易云加密解密方法
 *
 * @author Liukx
 * @create 2017-03-30 14:13
 * @email liukx@elab-plus.com
 **/
public class WangYiYunEncryptUtils {
    public final static String modulus = "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7" +
            "b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280" +
            "104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932" +
            "575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b" +
            "3ece0462db0a22b8e7";

    private final static String nonce = "0CoJUm6Qyw8W8jud";
    private final static String pubKey = "010001";

    private static final String PARAMS = "params";
    private static final String ENCSECKEY = "encSecKey";

    /**
     * 加密同一入口
     *
     * @param text
     * @return
     */
    public static Map<String, String> encrypt(String text) {
        String secKey = RandomStringUtils.random(16, "0123456789abcde");
        String encText = aesEncrypt(aesEncrypt(text, nonce), secKey);
        String encSecKey = rsaEncrypt(secKey, pubKey, modulus);

        Map<String, String> map = new HashMap<String, String>();
        map.put(PARAMS, encText);
        map.put(ENCSECKEY, encSecKey);
        return map;
    }

    /**
     * 加密
     *
     * @param text
     * @param key
     * @return
     */
    public static String aesEncrypt(String text, String key) {
        try {
            IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
            String encode = new BASE64Encoder().encode(encrypted);
            return encode;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 解密
     *
     * @param text
     * @param pubKey
     * @param modulus
     * @return
     */
    private static String rsaEncrypt(String text, String pubKey, String modulus) {
        text = new StringBuilder(text).reverse().toString();
        BigInteger rs = new BigInteger(String.format("%x", new BigInteger(1, text.getBytes())), 16)
                .modPow(new BigInteger(pubKey, 16), new BigInteger(modulus, 16));
        String r = rs.toString(16);
        if (r.length() >= 256) {
            return r.substring(r.length() - 256, r.length());
        } else {
            while (r.length() < 256) {
                r = 0 + r;
            }
            return r;
        }
    }

    public static void main(String[] args) {
//        RequestModel requestModel = new RequestModel();
//        requestModel.setLimit(20);
//        requestModel.setOffset(1);
//        String text = "{\"logs\":\"[{\"action\":\"searchkeywordclient\",\"json\":{\"type\":\"song\",\"keyword\":\"如果\",\"offset\":210}}]\",\"csrf_token\":\"\"}";
//        JSONObject json = new JSONObject();
//        json.put("type","song");
//        json.put("keyword","如果");
//        json.put("offset","300");
//        JSONObject node = new JSONObject();
//        node.put("action","searchkeywordclient");
//        node.put("json",json);
//
//        List<JSONObject> list = new ArrayList<>();
//        list.add(node);
//        JSONObject logs = new JSONObject();
//        logs.put("logs", JSON.toJSONString(list));
//        logs.put("csrf_token","");

//        JSONObject jsonObject = JSON.parseObject(text);
//        System.out.println(logs.toJSONString());
//        JSONObject json = new JSONObject();
//        json.put("b","a");
//        json.put("a","b");
//        Map map = new HashMap<>();
//        map.put("b","a");
//        map.put("a","b");
        String text = "{\"logs\":\"[{\"action\":\"searchkeywordclient\",\"json\":{\"type\":\"song\",\"keyword\":\"如果\",\"offset\":330}}]\"}";
        aesEncrypt(text, nonce);
//        Map<String, String> encrypt = WangYiYunEncryptUtils.encrypt(text);
//        System.out.println("---encSecKey----" + encrypt.get("encSecKey").toString());
//        System.out.println("----params---" + encrypt.get("params").toString());
//        String username = "444368875%40qq.com";
//        String encode = new BASE64Encoder().encode(username);
//        System.out.println(encode);
    }

}
