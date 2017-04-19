package com.model.common;

/**
 * 返回结果实体
 *
 * @author Liukx
 * @create 2017-04-06 10:37
 * @email liukx@elab-plus.com
 **/
public class ResultDTO {
    private boolean success = true;
    private String message;
    private Object object;


    public ResultDTO(boolean success, String message, Object object) {
        this.success = success;
        this.message = message;
        this.object = object;
    }

    public static ResultDTO isOK(Object object) {
        return new ResultDTO(true, null, object);
    }

    public static ResultDTO isNo(String message) {
        return new ResultDTO(false, message, null);
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
