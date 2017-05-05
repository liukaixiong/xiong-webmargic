import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;
import java.util.Random;
import java.util.Set;

/**
 * 利用Selenium获取登陆新浪微博weibo.cn的cookie
 *
 * @author hu
 */
public class WeiboCN {

    /**
     * 获取新浪微博的cookie，这个方法针对weibo.cn有效，对weibo.com无效
     * weibo.cn以明文形式传输数据，请使用小号
     *
     * @param username 新浪微博用户名
     * @param password 新浪微博密码
     * @return
     * @throws Exception
     */
    public static String getSinaCookie(String username, String password) throws Exception {
        StringBuilder sb = new StringBuilder();
        System.setProperty("webdriver.firefox.bin",
                "D:\\install\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
//        driver.setJavascriptEnabled(true);
        driver.get("http://192.168.0.15/");

        WebElement mobile = driver.findElement(By.id("username"));
        mobile.sendKeys(username);
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys(password);
//        WebElement rem = driver.findElementByCssSelector("input[name=remember]");
//        rem.click();
        WebElement submit = driver.findElement(By.xpath("/html/body/div[2]/div/form/div[3]/button"));
        submit.click();


        Set<Cookie> cookieSet = driver.manage().getCookies();
        driver.close();
        for (Cookie cookie : cookieSet) {
            sb.append(cookie.getName() + "=" + cookie.getValue() + ";");
        }
        String result = sb.toString();
        if (result.contains("gsid_CTandWM")) {
            return result;
        } else {
            throw new Exception("weibo login failed");
        }
    }

    private static String login2(String username, String password) throws Exception {
        long waitLoadBaseTime = 10000;
        int waitLoadRandomTime = 3000;
        Random random = new Random(System.currentTimeMillis());
        // 设置 chrome 的路径
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        // 创建一个 ChromeDriver 的接口，用于连接 Chrome
        @SuppressWarnings("deprecation")
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:\\Users\\admin\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe")).usingAnyFreePort().build();
        service.start();
        // 创建一个 Chrome 的浏览器实例
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.15/"),
                DesiredCapabilities.chrome());
        WebElement element = driver.findElement(By.className("input[name=username]"));
        element.sendKeys(username);
        WebElement pass = driver.findElement(By.className("input[name^=password]"));
        pass.sendKeys(password);
//        WebElement rem = driver.findElementByCssSelector("input[name=remember]");
//        rem.click();
        WebElement submit = driver.findElement(By.xpath("/html/body/div[2]/div/form/div[3]/button"));
        submit.click();

        Set<Cookie> cookieSet = driver.manage().getCookies();
        driver.close();
        StringBuffer sb = new StringBuffer();
        for (Cookie cookie : cookieSet) {
            sb.append(cookie.getName() + "=" + cookie.getValue() + ";");
        }
        String result = sb.toString();
        if (result.contains("gsid_CTandWM")) {
            return result;
        } else {
            throw new Exception("weibo login failed");
        }
    }


    public static void main(String[] args) throws Exception {
        String sinaCookie = getSinaCookie("admin", "elab@123");
        System.out.println("-->" + sinaCookie);
//        String admin = login2("admin", "elab@123");
//        System.out.println("---2》 "+admin);
    }

}