package com.robots.bumblebee.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description= "评论VO")
public class CommentVO {

    @ApiModelProperty(value = "评论id")
    private long cid;

    @ApiModelProperty(value = "帖子id")
    private long aid;

    @ApiModelProperty(value = "评论内容")
    private String text;

    @ApiModelProperty(value = "评论来源")
    private String source;

    @ApiModelProperty(value = "评论作者的用户信息")
    private SimpleUserVO commentUser;

    @ApiModelProperty(value = "评论来源评论，当本评论属于对另一评论的回复时返回此字段")
    private CommentVO replyComment;

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public SimpleUserVO getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(SimpleUserVO commentUser) {
        this.commentUser = commentUser;
    }

    public CommentVO getReplyComment() {
        return replyComment;
    }

    public void setReplyComment(CommentVO replyComment) {
        this.replyComment = replyComment;
    }
}
