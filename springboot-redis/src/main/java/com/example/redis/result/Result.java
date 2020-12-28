package com.example.redis.result;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    /**
     * 成功时构造函数
     * @param data  成功返回data
     */
    private Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    /**
     * 失败时构造函数
     * @param codeMsg   状态码和错误信息
     */
    private Result(CodeMsg codeMsg) {
        if (codeMsg == null) {
            return;
        }
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }
    /**
     * 成功时调用
     * @param data  返回值
     * @param <T>   类型
     * @return  Result对象
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }


    /**
     * 失败时调用
     * @param codeMsg   状态码和错误信息
     * @return  Result对象
     */
    public static <T> Result<T> error(CodeMsg codeMsg) {
        return new Result<>(codeMsg);
    }
}
