package com.example.hormone.config;

//用于封装消息


import lombok.Data;

@Data
public class R<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

//    private Map map = new HashMap(); //动态数据

    public static <T> R<T> success(T object) {
        R<T> r = new R<>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }

//    public R<T> add(String key, Object value) {
//        this.map.put(key, value);
//        return this;
//    }

    public static <T> R<T>  success(int code, String msg, T data) {
        R<T> r = new R<>();
        r.setCode(200);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static <T> R<T>  success() {
        return success(200, null, null);
    }

    public static <T> R<T>  success(String msg) {
        return success(200, msg, null);
    }

    public static <T> R<T> success(String msg, T data) {
        return success(200, msg, data);
    }


    public static <T> R<T>  fail(int code, String msg, T data) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static <T> R<T> fail(int code) {
        return success(code, null, null);
    }

    public static <T> R<T> fail(int code, String msg) {
        return success(code, msg, null);
    }

    public static <T> R<T> fail() {
        return success(404, null, null);
    }

}

