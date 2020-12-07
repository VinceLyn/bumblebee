package com.robots.bumblebee.utils;

import com.robots.bumblebee.entity.db.UserEntity;

import javax.servlet.http.HttpServletRequest;

public class CurrentUserUtil {

    private CurrentUserUtil(){}

    public static String getCurUserId(HttpServletRequest httpServletRequest) {
        UserEntity currentUserEntity = getCurUser(httpServletRequest);
        return currentUserEntity.getId();
    }

    public static UserEntity getCurUser(HttpServletRequest httpServletRequest){
        UserEntity currentUserEntity = (UserEntity) httpServletRequest.getAttribute("user");
        if(currentUserEntity == null){
            throw new RuntimeException("HttpServletRequest中不存在当前用户信息");
        }
        return currentUserEntity;
    }


}
