package com.webmargic.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 评论工具类
 *
 * @author Liukx
 * @create 2017-05-24 13:36
 * @email liukx@elab-plus.com
 **/
public class CommentUtils {

    private static int default_size = 10;

    /**
     * long 类型转换成 date类型
     *
     * @param time
     * @return
     */
    public static Date timestampConvertDate(Long time) {
        time = time * 1000L;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        return date;
    }

    /**
     * 判断是否为优质评论
     *
     * @param text
     * @return
     */
    public static boolean commentFilter(String text) {
        // 纯文本
        String content = Html2Text(text);

        //字数必须大于10
        if (StringUtils.isBlank(content) || content.length() < default_size) {
            return false;
        }

        // 防止用标点符号以及乱输入的字母凑数
        String replaceContet = replaceFilerSpace(content);
        if (replaceContet.length() < default_size) {
            return false;
        }

        //防止用重复凑字数
        int count = replaceRepeatCharacters(replaceContet);
        if (count < default_size) {
            return false;
        }
        return true;
    }

    public static String Html2Text(String inputString) {
        String htmlStr = inputString; // 含html标签的字符串
        String textStr = "";
        Pattern p_script;
        Matcher m_script;
        Pattern p_style;
        Matcher m_style;
        Pattern p_html;
        Matcher m_html;
        Pattern p_html1;
        Matcher m_html1;
        try {
            String regEx_script = "<[//s]*?script[^>]*?>[//s//S]*?<[//s]*?///[//s]*?script[//s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[//s//S]*?<///script>
            String regEx_style = "<[//s]*?style[^>]*?>[//s//S]*?<[//s]*?///[//s]*?style[//s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[//s//S]*?<///style>
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
            String regEx_html1 = "<[^>]+";
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签

            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签

            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签

            p_html1 = Pattern.compile(regEx_html1, Pattern.CASE_INSENSITIVE);
            m_html1 = p_html1.matcher(htmlStr);
            htmlStr = m_html1.replaceAll(""); // 过滤html标签
            textStr = htmlStr;
        } catch (Exception e) {

        }
        return textStr;// 返回文本字符串
    }

    /**
     * 替换标点符号,包括英文字母
     *
     * @param text
     * @return
     */
    private static String replaceFilerSpace(String text) {
        String s = text.replaceAll("[\\pP$~^+‘’“”:]", "").replaceAll("[a-z0-9A-Z]", "").replaceAll(" ", "");
        return s;
    }


    /**
     * 过滤重复字数,防止出现类似与  我爱你,我爱你,我爱你等词语
     *
     * @param text
     * @return
     */
    private static int replaceRepeatCharacters(String text) {
        Set<Character> characters = new HashSet<Character>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            characters.add(c);
        }
        return characters.size();
    }

    public static void main(String[] args) throws ParseException {
//        String s = "我爱你我爱你我爱你我爱你我爱你我爱你我爱你我爱你";
//        int i = replaceRepeatCharacters(s);
//        System.out.println(i);
        //1495856684
        //1495856733541
        Long time = 1495856684L;
        Date date = timestampConvertDate(time);
        System.out.println(date);
    }
}
