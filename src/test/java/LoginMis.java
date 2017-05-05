import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginMis {
    private CloseableHttpClient httpclient;
    private HttpPost httppost;// 用于提交登陆数据  
    private HttpGet httpget;// 用于获得登录后的页面  
    private String login_success;// 用于构造上面的HttpGet  

    public LoginMis() {
        httpclient = HttpClients.createDefault();
        // mis登陆界面网址  
        httppost = new HttpPost("https://www.zhihu.com/login/phone_num");
    }

    public String getCookie(String name, String password) throws Exception {
        httppost.setHeader("Content-Type", "multipart/form-data");
        httppost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phone_num", name);
        jsonObject.put("password", password);
        jsonObject.put("captcha","qwea");
        httppost.setEntity(new StringEntity(jsonObject.toJSONString(), "utf-8"));

        // 提交登录数据
        HttpResponse re = httpclient.execute(httppost);

        System.out.println("response:   " + re);
        String response = EntityUtils.toString(re.getEntity());
        Map<String,String> result = new HashMap<>();
        Header[] h = re.getAllHeaders();
        StringBuffer sb = new StringBuffer();
        for (Header header : h) {
            System.out.println(header.toString());
            if (header.getName().equals("Set-Cookie")) {
                sb.append(header.getValue() + ";");
            }
        }
        return sb.toString();
    }

    public void PrintText(String name) throws IOException {
        httpget = new HttpGet(login_success);
        HttpResponse re2 = null;

        try {
            re2 = httpclient.execute(httpget);
            // 输出登录成功后的页面  
            String str = EntityUtils.toString(re2.getEntity());

            System.out.println("\n" + name + "首页信息如下:");
            System.out.println(str.substring(8250, 8400));
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        } finally {
            httppost.abort();
            httpget.abort();
            httpclient.close();
        }
    }

    public static void main(String[] args) throws Exception {
//        String name = "xxxxx", password = "xxxxxx";
//         自己的账号，口令
//        LoginMis lr = new LoginMis();
//        lr.logIn("", "");
//        lr.PrintText("");
//        Map map = new HashMap<>();
//        map.put("Cookie","sid=cc5d80f8-1092-4966-a45e-eb20b4e99c62; ");
//        String text = HttpClientUtil.doGetHeader("http://localhost:8080/dd/tag/info", map);
//        System.out.println(text);
        LoginMis l = new LoginMis();
        String cookie = l.getCookie("18321006757", "lkx3551211");
        Map params = new HashMap<>();
//        map.put("Cookie", cookie);
        params.put("content", "哈哈，我是上次那个测试的人哟~");

        Map header = new HashMap<>();
        header.put("Cookie", cookie);
    //    String response = HttpClientUtil.doPost("https://www.zhihu.com/api/v4/answers/56584856/comments?include=author%2Ccollapsed%2Creply_to_author%2Cdisliked%2Ccontent%2Cvoting%2Cvote_count%2Cis_parent_author%2Cis_author", header, params);
     //   System.out.println("-------->" + response);
    }
}  