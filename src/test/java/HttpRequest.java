
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpRequest {

    public static void main(String[] args) {


//        ProxyCralwerUnusedVPN vpn = new ProxyCralwerUnusedVPN();
//
//        String s = vpn.startCrawler(10);
//
//        JSONObject jsonObject = JSON.parseObject(s);
//
//        JSONObject data = jsonObject.getJSONObject("data");
//        JSONArray proxy = data.getJSONArray("proxy");


        List<JSONObject> proxy = new ArrayList<>();
        proxy.add(getList("121.232.147.84","9000"));
        proxy.add(getList("115.183.11.158","9999"));
        proxy.add(getList("121.232.146.110","9000"));
        proxy.add(getList("117.90.5.15","9000"));
        proxy.add(getList("121.232.145.9","9000"));
        proxy.add(getList("122.96.59.103","83"));
        proxy.add(getList("121.232.145.90","9000"));
        proxy.add(getList("183.47.65.170","8998"));
        proxy.add(getList("113.72.113.231","8998"));
        proxy.add(getList("60.178.130.236","8081"));

        for (int i = 0; i < proxy.size(); i++) {
            JSONObject object = proxy.get(i);
            String ip = object.getString("ip");
            String port = object.getString("port");
            System.out.println("设置 ip : " + ip + "\t port : " + port);
            // 如果不设置，只要代理IP和代理端口正确,此项不设置也可以
            System.getProperties().setProperty("http.proxyHost", ip);
            System.getProperties().setProperty("http.proxyPort", port);
            // 判断代理是否设置成功
            // 发送 GET 请求
            System.out.println(sendGet(
                    "https://www.jianshu.com/p/828035ec764f",
                    ""));
            // 发送 POST 请求
        }


    }


    private static JSONObject getList(String ip, String port) {
        JSONObject json = new JSONObject();
        json.put("ip", ip);
        json.put("port", port);
        return json;
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
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
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
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}