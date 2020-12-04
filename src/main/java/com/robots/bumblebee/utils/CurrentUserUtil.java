package com.robots.bumblebee.utils;

import com.robots.bumblebee.entity.db.User;

import javax.servlet.http.HttpServletRequest;

public class CurrentUserUtil {

    private CurrentUserUtil(){}

    public static long getCurUserId(HttpServletRequest httpServletRequest) {
        User currentUser = getCurUser(httpServletRequest);
        return currentUser.getId();
    }

    public static User getCurUser(HttpServletRequest httpServletRequest){
        User currentUser = (User) httpServletRequest.getAttribute("user");
        if(currentUser == null){
            throw new RuntimeException("HttpServletRequest中不存在当前用户信息");
        }
        return currentUser;
    }


}
