package com.example.api.util;


import java.io.Serializable;

public class RestResponse<T> implements Serializable {

    private static final long serialVersionUID = -5365770240432602268L;
    private int code;

    private String msg;
    private T data;

    private RestResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static  <T> RestResponse<T> success() {
        return RestResponse.buildMsg(ResultType.SUCCESS.value, "操作成功", null);
    }

    public static <T> RestResponse<T> success(T data){
        return RestResponse.buildMsg(ResultType.SUCCESS.value, "success", data);

    }

    public static <T> RestResponse<T> error() {
        return new RestResponse(ResultType.ERROR.value, "操作异常", null);
    }

    public static <T> RestResponse<T> error(String msg) {
        return RestResponse.buildMsg(ResultType.ERROR.value, msg, null);
    }

    public static <T> RestResponse<T> error(String msg, T data) {
        return RestResponse.buildMsg(ResultType.ERROR.value, msg, data);
    }

    public static <T> RestResponse<T> paramError() {
        return RestResponse.buildMsg(ResultType.BAD_REQUEST.value, "参数错误", null);
    }


    public static <T> RestResponse<T> paramError(String msg) {
        return RestResponse.buildMsg(ResultType.BAD_REQUEST.value, msg, null);
    }


    public static <T> RestResponse<T> buildMsg(int code, String msg){
        return new RestResponse(code, msg, null);
    }


    public static <T> RestResponse<T> buildMsg(int code, String msg, T data){
        return new RestResponse(code, msg, data);
    }

    /**
     * 状态类型
     */
    public enum ResultType {
        /**
         * 成功
         */
        SUCCESS(0, "操作成功"),
        /**
         * 错误请求
         */
        BAD_REQUEST(400, "错误请求"),
        /**
         * 没有登录
         */
        NOT_LOGIN(401, "请重新登录"),
        /**
         * 用户已经注销
         */
        LOG_OUT(402, "用户已注销"),
        /**
         * 错误
         */
        ERROR(500, "操作异常");
        private final int value;
        private final String msg;

        ResultType(int value, String msg) {
            this.value = value;
            this.msg = msg;
        }

        public int value() {
            return this.value;
        }

        public String getMsg() {
            return msg;
        }
    }
}
