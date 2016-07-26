package com.zhengxin;

import java.io.Serializable;

/**
 * Created by 136931 on 2016/6/30.
 */
public class CommentContentBean implements Serializable {

    private String feedId;
    private String content;
    private CommentContentBean referComment;

    public CommentContentBean(){}

    public CommentContentBean(String feedId, String content, CommentContentBean referComment){
        this.feedId = feedId;
        this.content = content;
        this.referComment = referComment;
    }

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CommentContentBean getReferComment() {
        return referComment;
    }

    public void setReferComment(CommentContentBean referComment) {
        this.referComment = referComment;
    }

    @Override
    public String toString(){
        return "feedId : " + this.feedId + ", content : " + this.content + ", referComment:" + (null == this.referComment ? "" : this.referComment.toString());
    }
}
