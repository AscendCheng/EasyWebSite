package com.website.video.utils;

import javax.servlet.http.HttpServletResponse;

public class JsonResult {
    private int code;
    private Object data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JsonResult(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public JsonResult(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static JsonResult success() {
        return new JsonResult(HttpServletResponse.SC_OK, null);
    }

    public static JsonResult success(Object data) {
        return new JsonResult(HttpServletResponse.SC_OK, data);
    }

    public static JsonResult fail(Object data, String msg) {
        return new JsonResult(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, data, msg);
    }

    public static JsonResult fail(String msg) {
        return new JsonResult(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, msg);
    }
}
