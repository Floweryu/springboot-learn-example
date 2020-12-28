package com.example.redis.result;

import lombok.Data;

@Data
public class CodeMsg {
    private int code;
    private String msg;

    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500, "Server exception");

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
