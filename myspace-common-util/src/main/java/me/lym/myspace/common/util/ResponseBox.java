package me.lym.myspace.common.util;

import lombok.Data;

@Data
public class ResponseBox<T> {

    private Integer status;
    private String message;
    private T data;

    public ResponseBox(T data) {
        status = 200;
        message = "success";
        this.data = data;
    }

    public ResponseBox(Integer status, T data) {
        if (status >= 200 && status < 300) {
            message = "success";
        } else if (status >= 400 && status < 500) {
            message = "客户端错误";
        } else if (status >= 500 && status < 600) {
            message = "服务器端出现错误";
        } else {
            throw new IllegalArgumentException("状态码不合法");
        }
        this.status = status;
        this.data = data;
    }

    public ResponseBox(Integer status, String message){
        this.status = status;
        this.message = message;
    }

    public ResponseBox(Integer status, String message, T data) {
        if (status < 200 || status >= 600) {
            throw new IllegalArgumentException("状态码不合法");
        }
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <V> ResponseBox<V> ok(V data) {
        return new ResponseBox<>(data);
    }
    public static ResponseBox<?> ok(){
        return new ResponseBox<>(200, "success");
    }

    public static <V> ResponseBox<V> bad(String message) {
        return new ResponseBox<>(500, message);
    }
    public static <V> ResponseBox<V> bad(Integer status,String message) {
        return new ResponseBox<>(status, message);
    }
}
