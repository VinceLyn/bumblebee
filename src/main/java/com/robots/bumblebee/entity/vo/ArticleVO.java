package com.robots.bumblebee.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="帖子VO")
public class ArticleVO {

    @ApiModelProperty(value = "帖子id")
    private String id;

    @ApiModelProperty(value = "创建时间")
    private long ctime;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "话题")
    private String topic;

    @ApiModelProperty(value = "正文")
    private String text;

    @ApiModelProperty(value = "转发来源")
    private String sid;

    @ApiModelProperty(value = "浏览次数",example = "1")
    private int viewCount;

    @ApiModelProperty(value = "转发数",example = "1")
    private int repostsCount;

    @ApiModelProperty(value = "评论数",example = "1")
    private int commentCount;

    @ApiModelProperty(value = "点赞数",example = "1")
    private int likeCount;

    @ApiModelProperty(value = "用戶信息")
    private SimpleUserVO simpleUserVO;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }


    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(int repostsCount) {
        this.repostsCount = repostsCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public SimpleUserVO getSimpleUserVO() {
        return simpleUserVO;
    }

    public void setSimpleUserVO(SimpleUserVO simpleUserVO) {
        this.simpleUserVO = simpleUserVO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public long getCtime() {
        return ctime;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }
}
