package com.example.hormone.VO;

//用于封装消息


import lombok.Data;

@Data
public class Result<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

//    private Map map = new HashMap(); //动态数据

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<>();
        result.data = object;
        result.code = 1;
        return result;
    }

    public static <T> Result error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }

//    public R<T> add(String key, Object value) {
//        this.map.put(key, value);
//        return this;
//    }

    public static <T> Result<T> success(int code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success() {
        return success(200, null, null);
    }

    public static <T> Result<T> success(String msg) {
        return success(200, msg, null);
    }

    public static <T> Result<T> success(String msg, T data) {
        return success(200, msg, data);
    }


    public static <T> Result<T> fail(int code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(int code) {
        return success(code, null, null);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return success(code, msg, null);
    }

    public static <T> Result<T> fail() {
        return success(404, null, null);
    }

}

