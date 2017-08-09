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
                <input type="text" id="title" name="title" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">标题编号</label>

            <div class="layui-input-inline">
                <input type="text" id="topicId" name="topicId" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">点赞范围</label>

            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="like_min" id="likeMin" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid">-</div>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="like_max" id="likeMax" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">查询</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
        <td>{{ item.fmtCreatedTime }}</td>
        <td>{{ item.fmtSystemTime }}</td>
    </tr>
    {{#  }); }}
</script>


<script type="application/javascript">

    layui.use(['form', 'laytpl', 'laypage', 'layer'], function () {
        var laytpl = layui.laytpl;
        var laypage = layui.laypage;
        var layer = layui.layer;
        var form = layui.form()

        var getTpl = $("#demo").html();

        searchPage();


        //监听提交
        form.on('submit(demo1)', function (data) {
//            layer.alert(JSON.stringify(data.field), {
//                title: '最终的提交信息'
//            });
            searchPage();
            return false;
        });


        function searchPage() {
            // 分页
            laypage({
                cont: 'demo7'
                , pages: 1000
                , skip: true
                , jump: function (obj, first) {
                    //得到了当前页，用于向服务端请求对应数据
                    var curr = obj.curr;

                    var title = $("#title").val();
                    var likeMin = $("#likeMin").val();
                    var likeMax = $("#likeMax").val();
                    var topicId = $("#topicId").val();

                    var req = {
                        pageNo: curr,
                        pageSize: 20,
                        title: title,
                        likeMin: likeMin,
                        likeMax: likeMax,
                        topicId:topicId
                    };
                    doAjax("/tt/search", "post", req, function (data) {
                        if (data.success == true) {
                            var json = data.object;
                            var pages = json.pages;
                            obj.pages = pages;
                            laytpl(getTpl).render(json, function (html) {
                                $("#htmlId").html(html);
                            });
                        } else {
                            console.info(data);
                        }
                    })
                }
            });
        }

    });
</script>
</body>
</html>
