package com.robots.bumblebee.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("新建帖子po")
public class Article {

    @ApiModelProperty(value = "标题" ,required = true)
    private String title;

    @ApiModelProperty(value = "正文内容",required = true)
    private String text;

    @ApiModelProperty(hidden = true)
    private long userId;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
