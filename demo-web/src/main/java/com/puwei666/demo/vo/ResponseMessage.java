package com.puwei666.demo.vo;

import lombok.Data;

@Data
public class ResponseMessage<T> {

    private int code;
    private String message;
    private T data;

    public ResponseMessage() { }

    public ResponseMessage(T data) {
        this.data = data;
    }

    public ResponseMessage(int code) {
        this.code = code;
    }

    public ResponseMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseMessage(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseMessage(int code, T data) {
        this.code = code;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
