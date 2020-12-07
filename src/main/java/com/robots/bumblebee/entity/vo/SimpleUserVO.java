package com.robots.bumblebee.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description= "简单的用户信息")
public class SimpleUserVO {

    @ApiModelProperty(value = "用户id")
    private String id;

    @ApiModelProperty(value = "用戶账号")
    private String account;

    @ApiModelProperty(value = "用户头像地址")
    private String icon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String userImageUrl) {
        this.icon = icon;
    }
}
