package com.webmargic.vo;

/**
 * 请求参数类
 *
 * @author Liukx
 * @create 2017-03-31 10:06
 * @email liukx@elab-plus.com
 **/
public class RequestModel {
    private String username;
    private String password;
    private String rememberLogin = "true";
    //当前页数值
    private Integer offset;
    //每页最大数
    private Integer limit;
    private boolean total;

    public boolean isTotal() {
        return total;
    }

    public void setTotal(boolean total) {
        this.total = total;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRememberLogin() {
        return rememberLogin;
    }

    public void setRememberLogin(String rememberLogin) {
        this.rememberLogin = rememberLogin;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
