/**
 * Created by admin on 2017/6/6.
 */


function doAjax(url, method, data, callBackMethod) {
    $.ajax({
        url: url,
        type: method, //GET
        //async:true,    //或false,是否异步
        data: data,
        timeout: 5000,    //超时时间
        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        //beforeSend: function (xhr) {
        //    console.log(xhr)
        //    console.log('发送前')
        //},
        success: function (data) {
            callBackMethod(data);
        },
        error: function (xhr, textStatus) {
            console.log('错误')
            console.log(xhr)
            console.log(textStatus)
        }
        //, complete: function () {
        //    console.log('结束')
        //}
    })
}
