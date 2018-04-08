# xiong-webmargic

---
## 项目介绍 :
    闲来无事对爬虫很感兴趣,网上找了很多爬虫框架,发现webmargic还挺不错的,打算学习一下,也希望能对感兴趣的人提供一些帮助!
    对于一些需要登录才能够爬取的采取直接使用cookie的方式:
    登录某个网站,F12获取到cookie信息,然后集成到项目当中,某些爬取不到的内容的可能是你的cookie过期了，
    项目中的微博爬取采用模拟登录的方式,就不会每次都过期.
## 框架使用: 
    springMVC + spring +Mybatis + webmargic + mongodb (集成中)
## 目录结构介绍:
    com
        controller - 请求访问层
        dao        - 数据访问层 包括mysql - mongodb(集成中)
        model      - 实体类
        service    - 业务层处理
        webmargic  - 爬虫 webmargic入口
            main   - main方法测试 可以直接运行
            utils  - 爬取需要用到的工具类
            vo     - 爬取的数据对应的实体
            
### 爬取的内容

网站 | 爬取的内容 | 对应的运行类位置
---|---|---
网易云 | 主要包括评论、用户、歌曲信息 | com.webmargic.main.WangYiYunTest
微博 | 主要包括微博内容、微博评论 | com.webmargic.main.WeiBoTest
知乎|主要包括提问、答题|com.webmargic.main.ZhiHuTest

# cookie 设置方式（微博为例）：
    1.可以自己用帐号登录之后，F12获取cookie；
    2.模拟微博登录直接获取cookie ->  WeiBoUtils.login("帐号","密码");
# 数据库脚本位置
    sql/xiong.sql

## mongodb 
######     目前网易云的评论爬虫已经集成了mongdb,目前只实现添加接口其他的都是采用mysql存储方式,后面的话会慢慢迁移到mongdb上面来.
    mongodb3.4.4下载连接             :    http://pan.baidu.com/s/1eSxLioE
    mongdb客户端操作工具下载连接     :    http://pan.baidu.com/s/1eRRXerK
    
    

---
本人也在学习当中,如果有什么问题可以添加QQ:**444368875**
共同进步~

计划改造成Spring-boot形式..