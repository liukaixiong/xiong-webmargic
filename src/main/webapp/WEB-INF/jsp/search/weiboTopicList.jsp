<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/6/6
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>今日头条评论</title>
</head>
<link href="<c:url value="/js/layui/css/layui.css" />" type="text/css" rel="stylesheet"/>
<script src="<c:url value="/js/layui/layui.js" />"></script>
<script src="<c:url value="/js/jquery.v1.11.1.js" />"></script>
<script src="<c:url value="/js/common.js" />"></script>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>头条评论查询</legend>
</fieldset>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">标题名称</label>

            <div class="layui-input-inline">
                <input type="tel" name="phone" lay-verify="phone" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">评论字数长度大于</label>

            <div class="layui-input-inline">
                <input type="text" name="email" lay-verify="email" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
</form>
<div class="layui-form">
    <table class="layui-table">
        <colgroup>
            <col width="50">
            <col width="150">
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose"></th>
            <th>标题编号</th>
            <th>标题</th>
            <th>用户名称</th>
            <th>评论内容</th>
            <th>点赞数</th>
            <th>创建时间</th>
            <th>同步时间</th>
        </tr>
        </thead>
        <tbody id="htmlId">
        </tbody>
    </table>
    <div id="demo7"></div>
</div>

<script id="demo" type="text/html">
    {{#  layui.each(d.list, function(index, item){ }}
    <tr>
        <td><input type="checkbox" name="" lay-skin="primary"></td>
        <td>{{ item.topicId }}</td>
        <td>{{ item.title }}</td>
        <td>{{ item.username || '' }}</td>
        <td style="width: 40%">{{ item.text || '' }}</td>
        <td>{{ item.likeCount || '' }}</td>
        <td>{{ item.fmtCreatedTime  }}</td>
        <td>{{ item.fmtSystemTime   }}</td>
    </tr>
    {{#  }); }}
</script>


<script type="application/javascript">
    //    var data = {
    //        "title": "Layui常用模块"
    //        , "list": [{"modname": "弹层", "alias": "layer", "site": "layer.layui.com"}, {"modname": "表单", "alias": "form"}]
    //    };


    layui.use(['laytpl', 'laypage', 'layer'], function () {
        var laytpl = layui.laytpl;
        var laypage = layui.laypage;
        var layer = layui.layer;

        var getTpl = $("#demo").html();
        // 模版引擎
//        laytpl(getTpl).render(data, function (html) {
//            $("#htmlId").html(html);
//        });

        // 分页
        laypage({
            cont: 'demo7'
            , pages: 100
            , skip: true
            , jump: function (obj, first) {
                //得到了当前页，用于向服务端请求对应数据
                var curr = obj.curr;

                var req = {
                    pageNo: curr,
                    pageSize: 20
                }

                var data = {};
                doAjax("/tt/search", "post", req, function (data) {
                    if (data.success == true) {
                        data = data.object;
                        laytpl(getTpl).render(data, function (html) {
                            $("#htmlId").html(html);
                        });
                    } else {
                        console.info(data);
                    }
                })
//                var data = {
//                    "title": "Layui常用模块"
//                    ,
//                    "list": [{
//                        "modname": "弹层" + obj.curr,
//                        "alias": "layer",
//                        "site": "layer.layui.com"
//                    }, {"modname": "表单", "alias": "form"}]
//                };

            }
        });
    });
</script>
</body>
</html>
