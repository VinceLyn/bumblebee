package com.robots.bumblebee.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yichengdong
 * @date 2020/12/3
 */
@ApiModel("新建帖子po")
public class Article {

    @ApiModelProperty(value = "标题" ,required = true,example = "")
    private String title;

    @ApiModelProperty(value = "正文内容",required = true,example = "")
    private String content;

    @ApiModelProperty(value = "话题",example = "")
    private String topic;

    @ApiModelProperty(value = "所属圈子类型id",required = true,example = "1")
    private int typeId;

    @ApiModelProperty("图片地址")
    private String picUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
