package com.robots.bumblebee.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    private ResponseUtil(){}

    /**
     * 验证失败时返回的数据
     *
     * @param body
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> IllegalArg(T body){
         return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(body);
    }

    /**
     * 未授权时返回的数据
     * @param body
     * @param <T>
     * @return
     */
    public static <T> ResponseEntity<T> unauthorized(T body){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(body);
    }



}
